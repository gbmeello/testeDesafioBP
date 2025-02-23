package com.brailprev.domain.jogo.services;


import com.brailprev.domain.jogo.entities.Propriedade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PropriedadeService {
    public List<Propriedade> inicializarPropriedades(int numPropriedades) {
        List<Propriedade> propriedades = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numPropriedades; i++) {
            propriedades.add(new Propriedade(i, random.nextInt(200) + 50, random.nextInt(50) + 10));
        }
        return propriedades;
    }
}
