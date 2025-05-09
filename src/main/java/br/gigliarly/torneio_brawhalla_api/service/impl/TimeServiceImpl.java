package br.gigliarly.torneio_brawhalla_api.service.impl;

import br.gigliarly.torneio_brawhalla_api.dto.TimeDto;
import br.gigliarly.torneio_brawhalla_api.entity.Time;
import br.gigliarly.torneio_brawhalla_api.exception.BusinessException;
import br.gigliarly.torneio_brawhalla_api.repository.TimeRepository;
import br.gigliarly.torneio_brawhalla_api.service.DiretorService;
import br.gigliarly.torneio_brawhalla_api.service.JogadorService;
import br.gigliarly.torneio_brawhalla_api.service.TimeService;
import br.gigliarly.torneio_brawhalla_api.service.TorneioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TimeServiceImpl implements TimeService {

    private final TimeRepository timeRepository;
    private final TorneioService torneioService;
    private final JogadorService jogadorService;
    private final DiretorService diretorService;


    public TimeServiceImpl(TimeRepository timeRepository, TorneioService torneioService, JogadorService jogadorService, DiretorService diretorService) {
        this.timeRepository = timeRepository;
        this.torneioService = torneioService;
        this.jogadorService = jogadorService;
        this.diretorService = diretorService;
    }

    private void verifyId(Long id) {
        if (id == null) {
            throw new BusinessException("Id nao  pode ser nulo");
        }

        if (!timeRepository.existsById(id)) {
            throw new BusinessException("Esse id de time nao existe");
        }
    }

    @Override
    public Time findById(Long id) {
        verifyId(id);

        return this.timeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public Time save(TimeDto time) {
        if (timeRepository.existsByNome(time.nome())) {
            throw new BusinessException("Esse nome de time ja existe");
        }

        Time result = time.toEntity();
        result.setTorneio( torneioService.findById(time.torneioId()) );
        result.setJogadores( time.jogadoresId().stream().map(jogadorService::findById).toList() );
        result.setDiretor(diretorService.findById(time.diretorId()));

        return timeRepository.save(result);
    }

    @Override
    public List<Time> findAll() {
        return timeRepository.findAll();
    }

    @Override
    @Transactional
    public Time update(Long id, TimeDto timeDto) {
        verifyId(id);
        Time time = this.findById(id);
        Time result = timeDto.toEntity();
        result.setId(time.getId());
        result.setTorneio( torneioService.findById(timeDto.torneioId()) );
        result.setJogadores( timeDto.jogadoresId().stream().map(jogadorService::findById).toList() );
        result.setDiretor(diretorService.findById(timeDto.diretorId()));

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
