package com.brailprev.teste.application.usecases;

import com.brailprev.teste.domain.entities.Jogador;
import com.brailprev.teste.domain.entities.Propriedade;
import com.brailprev.teste.application.services.JogadorService;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Component
public class ExecutarPartida {

    private static final int MAX_RODADAS = 1000; // 🔹 Evita loop infinito
    private final Random random = new Random();
    private final JogadorService jogadorService;

    public ExecutarPartida(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    public Jogador executar(List<Jogador> jogadores, List<Propriedade> propriedades) {
        int rodadas = 0;

        while (jogadores.size() > 1 && rodadas < MAX_RODADAS) {
            Iterator<Jogador> iterator = jogadores.iterator();
            while (iterator.hasNext()) {
                Jogador jogador = iterator.next();
                int dado = random.nextInt(6) + 1;
                jogador.mover(dado, propriedades.size());

                Propriedade propriedade = propriedades.get(jogador.getPosicao());

                if (propriedade.getDono() == null && jogador.deveComprar(propriedade)) {
                    jogador.comprarPropriedade(propriedade);
                } else if (propriedade.getDono() != null && !propriedade.getDono().equals(jogador)) {
                    jogador.pagarAluguel(propriedade);
                }
            }
            jogadorService.removerJogadoresSemSaldo(jogadores);
            rodadas++;
        }

        // 🔹 Se atingir o limite, retorna o jogador com mais saldo
        return jogadores.stream().max((j1, j2) -> Integer.compare(j1.getSaldo(), j2.getSaldo())).orElse(null);
    }
}
