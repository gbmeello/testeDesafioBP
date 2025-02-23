package com.brailprev.teste.domain.jogo;

import com.brailprev.teste.application.usecases.jogador.entities.Jogador;

import java.util.List;

public class CalcularVencedor {
    public Jogador determinarVencedor(List<Jogador> jogadores) {
        return jogadores.stream()
                .max((j1, j2) -> Integer.compare(j1.getSaldo(), j2.getSaldo()))
                .orElse(null);
    }
}