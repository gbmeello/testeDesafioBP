package com.brailprev.teste.application.usecases.jogo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vencedor;
    private LocalDateTime dataExecucao;

    @ElementCollection
    private List<String> jogadores;

    public Jogo() {}

    public Jogo(String vencedor, List<String> jogadores) {
        this.vencedor = vencedor;
        this.jogadores = jogadores;
        this.dataExecucao = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getVencedor() { return vencedor; }
    public LocalDateTime getDataExecucao() { return dataExecucao; }
    public List<String> getJogadores() { return jogadores; }
}

