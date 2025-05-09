package br.gigliarly.torneio_brawhalla_api.dto;

import br.gigliarly.torneio_brawhalla_api.entity.Diretor;
import br.gigliarly.torneio_brawhalla_api.entity.Time;
import br.gigliarly.torneio_brawhalla_api.service.DiretorService;
import br.gigliarly.torneio_brawhalla_api.service.JogadorService;
import br.gigliarly.torneio_brawhalla_api.service.TimeService;
import br.gigliarly.torneio_brawhalla_api.service.TorneioService;

import java.util.List;

public record TimeDto(
        Long id,
        String nome,
        Boolean apto,
        boolean confirIntegrantes,
        String nacionalidade,
        List<Long> jogadoresId,
        Long diretorId,
        Long torneioId
) {

    public Time toEntity() {
        Time result = new Time();

        result.setId(id);
        result.setNome(nome);
        result.setApto(apto);
        result.setConfirIntegrantes(confirIntegrantes);
        result.setNacionalidade(nacionalidade);
//        if (jogadoresId != null) result.setJogadores(jogadoresId.stream().map(jogadorService::findById).toList());
//        result.setDiretor(diretorService.findById(diretorId));
//        result.setTorneio(torneioService.findById(torneioId));

        return result;
    }
}
