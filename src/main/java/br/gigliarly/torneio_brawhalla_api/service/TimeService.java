package br.gigliarly.torneio_brawhalla_api.service;

import br.gigliarly.torneio_brawhalla_api.entity.Time;

import java.util.List;

public interface TimeService {

    Time findById(Long id);

    Time save(Time time);

    List<Time> findAll();

    Time update(Long id, Time time);

    void deleteById(Long id);

}
