package br.gigliarly.torneio_brawhalla_api.controller;

import br.gigliarly.torneio_brawhalla_api.dto.JogadorDTO;
import br.gigliarly.torneio_brawhalla_api.entity.Jogador;
import br.gigliarly.torneio_brawhalla_api.service.JogadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
    private final JogadorService service;

    public JogadorController(JogadorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> findJogadorById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Jogador> save(@RequestBody JogadorDTO jogadorDTO) {
        return ResponseEntity.ok().body(service.save(jogadorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> update(@PathVariable Long id, @RequestBody JogadorDTO jogadorDTO) {
        return ResponseEntity.ok().body(service.update(id, jogadorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
