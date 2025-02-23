package com.brailprev.application.usecases.jogo;

import com.brailprev.domain.jogador.entities.Jogador;
import com.brailprev.domain.jogador.services.JogadorService;
import com.brailprev.domain.jogo.entities.Propriedade;
import com.brailprev.domain.jogo.entities.ResultadoPartida;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class ExecutarPartida {

    private static final int MAX_RODADAS = 1000; // 🔹 Evita loop infinito
    private final JogadorService jogadorService;

    public ExecutarPartida(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    public ResultadoPartida executar(List<Jogador> jogadores, List<Propriedade> propriedades) {
        int rodadas = 0;

        while (jogadores.size() > 1 && rodadas < MAX_RODADAS) {
            for (Jogador jogador : jogadores) {
                int dado = (int) (Math.random() * 6) + 1;
                jogador.mover(dado, propriedades.size());

                Propriedade propriedade = propriedades.get(jogador.getPosicao());

                if (propriedade.getDono() == null && jogador.deveComprar(propriedade)) {
                    jogador.comprarPropriedade(propriedade);
                } else if (propriedade.getDono() != null && !propriedade.getDono().equals(jogador)) {
                    jogador.pagarAluguel(propriedade);
                }
            }

            // 🔹 Remove jogadores sem saldo
            jogadorService.removerJogadoresSemSaldo(jogadores);

            rodadas++;
        }

        // 🔹 Ordenar jogadores por saldo (do maior para o menor)
        jogadores.sort(Comparator.comparingInt(Jogador::getSaldo).reversed());

        // 🔹 Calcular quem tem mais propriedades
        Jogador jogadorComMaisPropriedades = jogadores.stream()
                .max(Comparator.comparingInt(j -> j.getPropriedades().size()))
                .orElse(null);

        // 🔹 Calcular quem tem mais dinheiro
        Jogador jogadorComMaisDinheiro = jogadores.stream()
                .max(Comparator.comparingInt(Jogador::getSaldo))
                .orElse(null);

        // 🔹 Criar resultado da partida
        ResultadoPartida resultado = new ResultadoPartida();
        resultado.setVencedor(jogadores.get(0)); // Primeiro lugar
        resultado.setClassificacao(jogadores); // Classificação completa
        resultado.setJogadorComMaisPropriedades(jogadorComMaisPropriedades);
        resultado.setJogadorComMaisDinheiro(jogadorComMaisDinheiro);

        return resultado;
    }
}