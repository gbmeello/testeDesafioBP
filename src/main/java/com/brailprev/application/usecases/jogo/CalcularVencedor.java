package com.brailprev.application.usecases.jogo;

import com.brailprev.domain.jogador.entities.Jogador;

import java.util.List;

public class CalcularVencedor {
    public Jogador determinarVencedor(List<Jogador> jogadores) {
        return jogadores.stream()
                .max((j1, j2) -> Integer.compare(j1.getSaldo(), j2.getSaldo()))
                .orElse(null);
    }
}