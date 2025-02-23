package com.brailprev.infrastructure.controllers.jogador;

import com.brailprev.domain.jogador.entities.Jogador;
import com.brailprev.domain.jogador.services.JogadorService;
import com.brailprev.domain.jogo.entities.Propriedade;
import com.brailprev.domain.jogo.services.PropriedadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private final JogadorService jogadorService;
    private final PropriedadeService propriedadeService;

    @Autowired
    public JogadorController(JogadorService jogadorService, PropriedadeService propriedadeService) {
        this.jogadorService = jogadorService;
        this.propriedadeService = propriedadeService;
    }

    @PostMapping("/comprar-propriedade")
    public ResponseEntity<String> comprarPropriedade(@RequestParam Long jogadorId, @RequestParam Long propriedadeId) {
        Jogador jogador = jogadorService.buscarPorId(jogadorId);
        Propriedade propriedade = propriedadeService.buscarPorId(propriedadeId);

        if (jogador == null || propriedade == null) {
            return ResponseEntity.badRequest().body("Jogador ou propriedade não encontrados.");
        }

        jogadorService.comprarPropriedade(jogador, propriedade);
        return ResponseEntity.ok("Propriedade comprada com sucesso.");
    }
}