package br.gigliarly.torneio_brawhalla_api.service.impl;

import br.gigliarly.torneio_brawhalla_api.dto.TimeDto;
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

    private void verifyId(Long id) {
        if (id == null) {
            throw new BusinessException("Id nao  pode ser nulo");
        }

        if (!timeRepository.existsById(id)) {
            throw new BusinessException("Esse id nao existe");
        }
    }

    @Override
    public Time findById(Long id) {
        verifyId(id);

        return this.timeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Time save(TimeDto time) {
        if (timeRepository.existsByNome(time.nome())) {
            throw new BusinessException("Esse nome de time ja existe");
        }

        return timeRepository.save(time.toEntity());
    }

    @Override
    public List<Time> findAll() {
        return timeRepository.findAll();
    }

    @Override
    public Time update(Long id, TimeDto timeDto) {
        verifyId(id);
        Time time = this.findById(id);
        Time result = timeDto.toEntity();
        result.setId(time.getId());

        return timeRepository.save(result);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new BusinessException("Id não pode ser nulo");
        }

        if (!timeRepository.existsById(id)) {
            throw new BusinessException("Esse time não existe");
        }

        timeRepository.deleteById(id);
    }

}
