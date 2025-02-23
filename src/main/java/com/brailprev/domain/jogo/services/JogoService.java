package com.brailprev.domain.jogo.services;

import com.brailprev.application.usecases.jogo.ExecutarPartida;
import com.brailprev.domain.jogador.entities.Jogador;
import com.brailprev.domain.jogador.services.JogadorService;
import com.brailprev.domain.jogo.entities.Jogo;
import com.brailprev.domain.jogo.entities.Propriedade;
import com.brailprev.domain.jogo.entities.ResultadoPartida;
import com.brailprev.domain.jogo.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class JogoService {

    private final JogadorService jogadorService;
    private final PropriedadeService propriedadeService;
    private final JogoRepository jogoRepository;
    private final ExecutarPartida executarPartida;

    @Autowired
    public JogoService(
            JogadorService jogadorService,
            PropriedadeService propriedadeService,
            JogoRepository jogoRepository,
            ExecutarPartida executarPartida) {
        this.jogadorService = jogadorService;
        this.propriedadeService = propriedadeService;
        this.jogoRepository = jogoRepository;
        this.executarPartida = executarPartida;
    }

    public Jogo iniciarJogo() {
        List<Jogador> jogadores = jogadorService.inicializarJogadores();
        List<Propriedade> propriedades = propriedadeService.inicializarPropriedades(20);

        System.out.println("Jogo iniciado com " + jogadores.size() + " jogadores e " + propriedades.size() + " propriedades.");

        // Simular a partida
        ResultadoPartida resultado = executarPartida.executar(jogadores, propriedades);

        // Salvar no banco de dados
        Jogo jogoSalvo = new Jogo(
                resultado.getVencedor().getTipo().name(),
                jogadores.stream().map(j -> j.getTipo().name()).toList()
        );

        return jogoRepository.save(jogoSalvo);
    }

    public List<Jogo> listarJogos() {
        return jogoRepository.findAll();
    }

    public Map<String, Object> simularJogo() {
        List<Jogador> jogadores = jogadorService.inicializarJogadores();
        List<Propriedade> propriedades = propriedadeService.inicializarPropriedades(20);

        ResultadoPartida resultado = executarPartida.executar(jogadores, propriedades);

        // 🔹 Garante que há um vencedor
        if (resultado.getVencedor() == null) {
            return Map.of("erro", "Nenhum jogador venceu dentro do limite de rodadas.");
        }

        // 🔹 Ordenar jogadores por saldo, do maior para o menor
        jogadores.sort(Comparator.comparingInt(Jogador::getSaldo).reversed());

        Map<String, Object> resultadoMap = new HashMap<>();
        resultadoMap.put("vencedor", resultado.getVencedor().getTipo().name());
        resultadoMap.put("classificacao", jogadores.stream().map(j -> j.getTipo().name()).toList());
        resultadoMap.put("jogadorComMaisPropriedades", resultado.getJogadorComMaisPropriedades().getTipo().name());
        resultadoMap.put("jogadorComMaisDinheiro", resultado.getJogadorComMaisDinheiro().getTipo().name());

        return resultadoMap;
    }
}