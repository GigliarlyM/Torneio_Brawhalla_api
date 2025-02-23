package br.gigliarly.torneio_brawhalla_api.controller;

import br.gigliarly.torneio_brawhalla_api.entity.summary.TorneioResumido;
import br.gigliarly.torneio_brawhalla_api.service.TorneioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/torneio")
public class TorneioController {

    public TorneioService torneioService;

    public TorneioController(TorneioService torneioService) {
        this.torneioService = torneioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TorneioResumido> findTorneioById (@PathVariable Long id) {
        var torneio = torneioService.getTorneioResumido(id);

        return ResponseEntity.ok(torneio);
    }
}
