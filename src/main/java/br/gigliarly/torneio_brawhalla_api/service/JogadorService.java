package br.gigliarly.torneio_brawhalla_api.service;

import br.gigliarly.torneio_brawhalla_api.dto.JogadorDTO;
import br.gigliarly.torneio_brawhalla_api.entity.Jogador;

public interface JogadorService {
    Jogador findById(Long id);

    Jogador save(JogadorDTO jogador);

    void delete(Long id);

    Jogador update(Long id, JogadorDTO jogadorDTO);
}
