package br.gigliarly.torneio_brawhalla_api.service.impl;

import br.gigliarly.torneio_brawhalla_api.dto.TorneioDTO;
import br.gigliarly.torneio_brawhalla_api.entity.Torneio;
import br.gigliarly.torneio_brawhalla_api.exception.BusinessException;
import br.gigliarly.torneio_brawhalla_api.repository.TorneioRepository;
import br.gigliarly.torneio_brawhalla_api.service.TimeService;
import br.gigliarly.torneio_brawhalla_api.service.TorneioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TorneioServiceImpl implements TorneioService {

    private final TorneioRepository torneioRepository;

    public TorneioServiceImpl(TorneioRepository torneioRepository) {
        this.torneioRepository = torneioRepository;
    }

    @Override
    public Torneio findById(Long id) {
        if (id == null) {
            throw new BusinessException("Id não pode ser nulo");
        }
        if (!torneioRepository.existsById(id)) {
            throw new BusinessException("Esse id torneio não existe");
        }

        return torneioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Torneio save(TorneioDTO torneioDTO) {
        return torneioRepository.save(torneioDTO.toEntity());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new BusinessException("Id não pode ser nulo");
        }

        if (torneioRepository.existsById(id)) {
            throw new BusinessException("Esse id não existe");
        }

        torneioRepository.deleteById(id);
    }

    @Override
    public Torneio update(Long id, TorneioDTO torneioDTO) {
        Torneio torneio = this.findById(id);
        Torneio result = torneioDTO.toEntity();
        result.setId(torneio.getId());

        return torneioRepository.save(result);
    }

}
