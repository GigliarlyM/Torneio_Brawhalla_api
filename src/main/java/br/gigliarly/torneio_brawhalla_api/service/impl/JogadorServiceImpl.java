package br.gigliarly.torneio_brawhalla_api.service.impl;

import br.gigliarly.torneio_brawhalla_api.dto.JogadorDTO;
import br.gigliarly.torneio_brawhalla_api.entity.Jogador;
import br.gigliarly.torneio_brawhalla_api.exception.BusinessException;
import br.gigliarly.torneio_brawhalla_api.repository.JogadorRepository;
import br.gigliarly.torneio_brawhalla_api.service.JogadorService;
import org.springframework.stereotype.Service;

@Service
public class JogadorServiceImpl implements JogadorService {
    private final JogadorRepository repository;

    public JogadorServiceImpl(JogadorRepository repo) {
        this.repository = repo;
    }

    private void verifyId(Long id) {
        if (id == null) {
            throw new BusinessException("Id nao pode esta vazio");
        }

        if (!repository.existsById(id)) {
            throw new BusinessException("Esse id de jogador nao existe");
        }
    }

    @Override
    public Jogador findById(Long id) {
        verifyId(id);

        return repository.findById(id).orElseThrow(NoSuchFieldError::new);
    }

    @Override
    public Jogador save(JogadorDTO jogadorDTO) {
        Jogador result = jogadorDTO.toEntity();
        return repository.save(result);
    }

    @Override
    public void delete(Long id) {
        Jogador jogador = this.findById(id);
        repository.delete(jogador);
    }

    @Override
    public Jogador update(Long id, JogadorDTO jogadorDTO) {
        verifyId(id);
        Jogador result = jogadorDTO.toEntity();
        result.setId(id);
        return repository.save(result);
    }
}
