package br.gigliarly.torneio_brawhalla_api.service;

import br.gigliarly.torneio_brawhalla_api.entity.Torneio;
import br.gigliarly.torneio_brawhalla_api.entity.summary.TorneioResumido;

public interface TorneioService {

    Torneio findById(Long id);

    TorneioResumido getTorneioResumido(Long id);

}
