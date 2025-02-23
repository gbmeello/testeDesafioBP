package com.brailprev.application.usecases.jogador;

import com.brailprev.domain.jogador.entities.Jogador;
import com.brailprev.domain.jogador.services.JogadorService;
import com.brailprev.domain.jogo.entities.Propriedade;
import org.springframework.stereotype.Component;

@Component
public class ComprarPropriedade {

    private final JogadorService jogadorService;

    public ComprarPropriedade(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    public void execute(Jogador jogador, Propriedade propriedade) {
        if (jogador.deveComprar(propriedade)) {
            jogador.comprarPropriedade(propriedade);
            jogadorService.atualizarJogador(jogador); // Atualiza o jogador no repositório
        }
    }
}