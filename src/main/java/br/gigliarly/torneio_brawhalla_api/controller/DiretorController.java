package br.gigliarly.torneio_brawhalla_api.controller;

import br.gigliarly.torneio_brawhalla_api.dto.DiretorDTO;
import br.gigliarly.torneio_brawhalla_api.entity.Diretor;
import br.gigliarly.torneio_brawhalla_api.service.DiretorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diretor")
public class DiretorController {
    private final DiretorService service;

    public DiretorController(DiretorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diretor> findById(@PathVariable Long id) {
        Diretor result = service.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<Diretor> save(@RequestBody DiretorDTO diretorDTO) {
        return ResponseEntity.ok().body(service.save(diretorDTO));
    }
}
