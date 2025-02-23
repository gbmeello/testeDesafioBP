package com.brailprev.infrastructure.events;

import com.brailprev.domain.jogador.entities.Jogador;
import com.brailprev.domain.jogo.entities.Propriedade;

public class PropriedadeCompradaEvent {

    private final Jogador jogador;
    private final Propriedade propriedade;

    public PropriedadeCompradaEvent(Jogador jogador, Propriedade propriedade) {
        this.jogador = jogador;
        this.propriedade = propriedade;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }
}