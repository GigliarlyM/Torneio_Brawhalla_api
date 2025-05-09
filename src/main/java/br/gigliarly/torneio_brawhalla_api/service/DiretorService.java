package br.gigliarly.torneio_brawhalla_api.service;

import br.gigliarly.torneio_brawhalla_api.dto.DiretorDTO;
import br.gigliarly.torneio_brawhalla_api.entity.Diretor;

public interface DiretorService {
    Diretor findById(Long id);

    Diretor save(DiretorDTO diretorDTO);
}
