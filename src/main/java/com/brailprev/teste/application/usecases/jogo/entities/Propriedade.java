package com.brailprev.teste.application.usecases.jogo.entities;

import com.brailprev.teste.application.usecases.jogador.entities.Jogador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Propriedade {
    private int id;
    private int valor;
    private int aluguel;
    private Jogador dono;

    public Propriedade(int id, int valor, int aluguel) {
        this.id = id;
        this.valor = valor;
        this.aluguel = aluguel;
        this.dono = null;
    }

    public int getValor() { return valor; }
    public int getAluguel() { return aluguel; }
    public Jogador getDono() { return dono; }
    public void setDono(Jogador dono) { this.dono = dono; }
}
