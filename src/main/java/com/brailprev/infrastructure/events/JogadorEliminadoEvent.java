package com.brailprev.infrastructure.events;

import com.brailprev.domain.jogador.entities.Jogador;

public class JogadorEliminadoEvent {

    private final Jogador jogador;

    public JogadorEliminadoEvent(Jogador jogador) {
        this.jogador = jogador;
    }

    public Jogador getJogador() {
        return jogador;
    }
}