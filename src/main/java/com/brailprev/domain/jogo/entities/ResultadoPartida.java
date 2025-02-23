package com.brailprev.domain.jogo.entities;

import com.brailprev.domain.jogador.entities.Jogador;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoPartida {

    private Jogador vencedor;
    private List<Jogador> classificacao;
    private Jogador jogadorComMaisPropriedades;
    private Jogador jogadorComMaisDinheiro;
}
