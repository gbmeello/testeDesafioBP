package com.brailprev.domain.jogador.services;

import com.brailprev.domain.jogador.entities.Jogador;
import com.brailprev.domain.jogador.enums.TipoJogador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JogadorService {

    public List<Jogador> inicializarJogadores() {
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador(TipoJogador.IMPULSIVO, 300));
        jogadores.add(new Jogador(TipoJogador.EXIGENTE, 300));
        jogadores.add(new Jogador(TipoJogador.CAUTELOSO, 300));
        jogadores.add(new Jogador(TipoJogador.ALEATORIO, 300));
        return jogadores;
    }

    public void removerJogadoresSemSaldo(List<Jogador> jogadores) {
        jogadores.removeIf(j -> j.getSaldo() < 0);
    }
}
