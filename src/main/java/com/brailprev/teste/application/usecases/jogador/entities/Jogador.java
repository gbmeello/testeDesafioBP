package com.brailprev.teste.application.usecases.jogador.entities;

import com.brailprev.teste.application.usecases.jogo.entities.Propriedade;
import com.brailprev.teste.application.usecases.jogador.enums.TipoJogador;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Jogador {

    private TipoJogador tipo;
    private int saldo;
    private int posicao;
    private List<Propriedade> propriedades;

    public Jogador(TipoJogador tipo, int saldo) {
        this.tipo = tipo;
        this.saldo = saldo;
        this.posicao = 0;
        this.propriedades = new ArrayList<>();
    }

    // ✅ Corrigido: Método mover implementado
    public void mover(int passos, int totalPropriedades) {
        this.posicao = (this.posicao + passos) % totalPropriedades;
    }

    // ✅ Corrigido: Método comprarPropriedade implementado
    public void comprarPropriedade(Propriedade propriedade) {
        if (saldo >= propriedade.getValor()) {
            saldo -= propriedade.getValor();
            propriedades.add(propriedade);
            propriedade.setDono(this);
        }
    }

    // ✅ Corrigido: Método pagarAluguel implementado
    public void pagarAluguel(Propriedade propriedade) {
        if (saldo >= propriedade.getAluguel()) {
            saldo -= propriedade.getAluguel();
            propriedade.getDono().adicionarSaldo(propriedade.getAluguel());
        }
    }

    public boolean deveComprar(Propriedade propriedade) {
        return switch (tipo) {
            case IMPULSIVO -> true;
            case EXIGENTE -> propriedade.getAluguel() > 50;
            case CAUTELOSO -> (saldo - propriedade.getValor()) >= 80;
            case ALEATORIO -> new Random().nextBoolean();
        };
    }

    public void adicionarSaldo(int valor) {
        saldo += valor;
    }
}
