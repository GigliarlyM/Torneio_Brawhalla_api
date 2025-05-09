package br.gigliarly.torneio_brawhalla_api.service.impl;

import br.gigliarly.torneio_brawhalla_api.dto.DiretorDTO;
import br.gigliarly.torneio_brawhalla_api.entity.Diretor;
import br.gigliarly.torneio_brawhalla_api.exception.BusinessException;
import br.gigliarly.torneio_brawhalla_api.repository.DiretorRepository;
import br.gigliarly.torneio_brawhalla_api.service.DiretorService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DiretorSerivceImpl implements DiretorService {
    private final DiretorRepository repository;

    public DiretorSerivceImpl(DiretorRepository repository) {
        this.repository = repository;
    }

    private void verifyId(Long id) {
        if (id == null){
            throw new BusinessException("Id nao pode ser nulo");
        }
        if (!repository.existsById(id)){
            throw new BusinessException("Esse id de Diretor nao existe");
        }
    }

    @Override
    public Diretor findById(Long id) {
        verifyId(id);
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Diretor save(DiretorDTO diretorDTO) {
        return repository.save(diretorDTO.toEntity());
    }
}
