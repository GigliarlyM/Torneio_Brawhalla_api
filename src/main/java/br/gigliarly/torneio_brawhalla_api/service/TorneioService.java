package br.gigliarly.torneio_brawhalla_api.service;

import br.gigliarly.torneio_brawhalla_api.dto.TorneioDTO;
import br.gigliarly.torneio_brawhalla_api.entity.Torneio;

public interface TorneioService {

    Torneio findById(Long id);

    Torneio save(TorneioDTO torneioDTO);

    void deleteById(Long id);

    Torneio update(Long id, TorneioDTO torneioDTO);

}
