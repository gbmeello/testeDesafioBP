package com.brailprev.teste.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private List<Propriedade> propriedades;

    public Tabuleiro(int numPropriedades) {
        this.propriedades = new ArrayList<>();
        for (int i = 0; i < numPropriedades; i++) {
            propriedades.add(new Propriedade(i, new java.util.Random().nextInt(200) + 50, new java.util.Random().nextInt(50) + 10));
        }
    }

    public Propriedade getPropriedade(int posicao) {
        return propriedades.get(posicao);
    }
}