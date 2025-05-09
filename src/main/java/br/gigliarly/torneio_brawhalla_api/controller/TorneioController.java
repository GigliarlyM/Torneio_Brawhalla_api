package br.gigliarly.torneio_brawhalla_api.controller;

import br.gigliarly.torneio_brawhalla_api.dto.TorneioDTO;
import br.gigliarly.torneio_brawhalla_api.entity.Torneio;
import br.gigliarly.torneio_brawhalla_api.service.TorneioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/torneio")
public class TorneioController {

    public TorneioService torneioService;

    public TorneioController(TorneioService torneioService) {
        this.torneioService = torneioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Torneio> findTorneioById(@PathVariable Long id) {
        var torneio = torneioService.findById(id);

        return ResponseEntity.ok().body(torneio);
    }

    @PostMapping
    public ResponseEntity<Torneio> saveTorneio(@RequestBody TorneioDTO torneioDTO) {
        Torneio torneio = torneioService.save(torneioDTO);
        return ResponseEntity.ok().body(torneio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Torneio> updateTorneioById(@PathVariable Long id, @RequestBody TorneioDTO torneioDTO) {
        Torneio result = torneioService.update(id, torneioDTO);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTorneioById(@PathVariable Long id) {
        torneioService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
