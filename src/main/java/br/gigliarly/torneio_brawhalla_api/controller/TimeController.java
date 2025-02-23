package br.gigliarly.torneio_brawhalla_api.controller;

import br.gigliarly.torneio_brawhalla_api.controller.dto.TimeDto;
import br.gigliarly.torneio_brawhalla_api.entity.Time;
import br.gigliarly.torneio_brawhalla_api.service.TimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {

    private final TimeService service;

    public TimeController(TimeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Time> create(@RequestBody Time time) {
        var timeCreated = service.save(time);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(timeCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(timeCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> update(@PathVariable Long id, @RequestBody TimeDto time) {
        var timeUpdated = service.update(id, time.toModel());
        return ResponseEntity.ok().body(timeUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
