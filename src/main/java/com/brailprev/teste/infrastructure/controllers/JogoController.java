package com.brailprev.teste.infrastructure.controllers;

import com.brailprev.teste.application.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    private final JogoService jogoService;

    @Autowired
    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @PostMapping("/iniciar")
    public ResponseEntity<?> iniciarJogo() {
        return ResponseEntity.ok(jogoService.simularJogo());
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarJogos() {
        return ResponseEntity.ok(jogoService.listarJogos());
    }

    @GetMapping("/simular")
    public ResponseEntity<Map<String, Object>> simularJogo() {
        return ResponseEntity.ok(jogoService.simularJogo());
    }
}
