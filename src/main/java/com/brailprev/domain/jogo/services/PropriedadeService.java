package com.brailprev.domain.jogo.services;

import com.brailprev.domain.jogo.entities.Propriedade;
import com.brailprev.domain.jogo.repositories.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PropriedadeService {

    private final PropriedadeRepository propriedadeRepository;

    @Autowired
    public PropriedadeService(PropriedadeRepository propriedadeRepository) {
        this.propriedadeRepository = propriedadeRepository;
    }

    public Propriedade buscarPorId(Long id) {
        return propriedadeRepository.findById(id).orElse(null);
    }

    public List<Propriedade> listarPropriedades() {
        return propriedadeRepository.findAll();
    }

    public List<Propriedade> inicializarPropriedades(int numPropriedades) {
        List<Propriedade> propriedades = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numPropriedades; i++) {
            propriedades.add(new Propriedade(i, random.nextInt(200) + 50, random.nextInt(50) + 10));
        }
        return propriedades;
    }
}