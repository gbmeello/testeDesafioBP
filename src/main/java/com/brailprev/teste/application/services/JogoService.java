package com.brailprev.teste.application.services;

import com.brailprev.teste.domain.entities.Jogador;
import com.brailprev.teste.domain.entities.Jogo;
import com.brailprev.teste.domain.entities.Propriedade;
import com.brailprev.teste.infrastructure.persistence.JogoRepository;
import com.brailprev.teste.application.usecases.ExecutarPartida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Jogador vencedor = executarPartida.executar(jogadores, propriedades);

        // Salvar no banco de dados
        Jogo jogoSalvo = new Jogo(
                vencedor.getTipo().name(),
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

        Jogador vencedor = executarPartida.executar(jogadores, propriedades);

        // 🔹 Garante que há um vencedor
        if (vencedor == null) {
            return Map.of("erro", "Nenhum jogador venceu dentro do limite de rodadas.");
        }

        // 🔹 Ordenar jogadores por saldo, do maior para o menor
        jogadores.sort(Comparator.comparingInt(Jogador::getSaldo).reversed());

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("vencedor", vencedor.getTipo().name());
        resultado.put("jogadores", jogadores.stream().map(j -> j.getTipo().name()).toList());

        return resultado;
    }
}