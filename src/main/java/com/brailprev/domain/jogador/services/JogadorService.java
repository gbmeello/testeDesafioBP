package com.brailprev.domain.jogador.services;

import com.brailprev.domain.jogador.entities.Jogador;
import com.brailprev.domain.jogador.enums.TipoJogador;
import com.brailprev.domain.jogador.repository.JogadorRepository;
import com.brailprev.domain.jogo.entities.Propriedade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public Jogador buscarPorId(Long id) {
        return jogadorRepository.findById(id).orElse(null);
    }

    public void atualizarJogador(Jogador jogador) {
        jogadorRepository.save(jogador);
    }

    public void comprarPropriedade(Jogador jogador, Propriedade propriedade) {
        if (jogador.getSaldo() >= propriedade.getValor()) {
            jogador.comprarPropriedade(propriedade);
            jogadorRepository.save(jogador);
        }
    }

    public List<Jogador> listarJogadores() {
        return jogadorRepository.findAll();
    }

    public void removerJogadoresSemSaldo(List<Jogador> jogadores) {
        jogadores.removeIf(jogador -> jogador.getSaldo() < 0);
    }

    public List<Jogador> inicializarJogadores() {
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador(TipoJogador.IMPULSIVO, 300));
        jogadores.add(new Jogador(TipoJogador.EXIGENTE, 300));
        jogadores.add(new Jogador(TipoJogador.CAUTELOSO, 300));
        jogadores.add(new Jogador(TipoJogador.ALEATORIO, 300));
        return jogadores;
    }

}