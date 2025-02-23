package br.gigliarly.torneio_brawhalla_api.service.impl;

import br.gigliarly.torneio_brawhalla_api.entity.Time;
import br.gigliarly.torneio_brawhalla_api.exception.BusinessException;
import br.gigliarly.torneio_brawhalla_api.repository.TimeRepository;
import br.gigliarly.torneio_brawhalla_api.service.TimeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TimeServiceImpl implements TimeService {

    private final TimeRepository timeRepository;

    public TimeServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public Time findById(Long id) {
        if (id == null) {
            throw new BusinessException("Id não pode ser nulo");
        }

        return this.timeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Time save(Time time) {
        if (time.getId() != null && timeRepository.existsById(time.getId())) {
            throw new BusinessException("Id already exists");
        }

        return timeRepository.save(time);
    }

    @Override
    public List<Time> findAll() {
        return timeRepository.findAll();
    }

    @Override
    public Time update(Long id, Time time) {
        Time dbTime = this.findById(id);

        if (dbTime.getId().equals(time.getId())) {
            throw new BusinessException("Ids do time não coincidem");
        }

        dbTime.setNome(time.getNome());
        dbTime.setApto(time.getApto());

        return this.timeRepository.save(dbTime);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new BusinessException("Id não pode ser nulo");
        }

        timeRepository.deleteById(id);
    }

}
