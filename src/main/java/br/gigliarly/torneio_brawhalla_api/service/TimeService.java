package br.gigliarly.torneio_brawhalla_api.service;

import br.gigliarly.torneio_brawhalla_api.dto.TimeDto;
import br.gigliarly.torneio_brawhalla_api.entity.Time;

import java.util.List;

public interface TimeService {

    Time findById(Long id);

    Time save(TimeDto time);

    List<Time> findAll();

    Time update(Long id, TimeDto time);

    void deleteById(Long id);

}
