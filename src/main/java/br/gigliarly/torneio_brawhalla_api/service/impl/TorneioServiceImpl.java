package br.gigliarly.torneio_brawhalla_api.service.impl;

import br.gigliarly.torneio_brawhalla_api.entity.Torneio;
import br.gigliarly.torneio_brawhalla_api.entity.summary.TimeResumido;
import br.gigliarly.torneio_brawhalla_api.entity.summary.TorneioResumido;
import br.gigliarly.torneio_brawhalla_api.exception.BusinessException;
import br.gigliarly.torneio_brawhalla_api.repository.TorneioRepository;
import br.gigliarly.torneio_brawhalla_api.service.TimeService;
import br.gigliarly.torneio_brawhalla_api.service.TorneioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class TorneioServiceImpl implements TorneioService {

    private final TorneioRepository torneioRepository;
    private final TimeService timeService;

    public TorneioServiceImpl(TorneioRepository torneioRepository, TimeService timeService) {
        this.torneioRepository = torneioRepository;
        this.timeService = timeService;
    }

    @Override
    public Torneio findById(Long id) {
        if (id == null) {
            throw new BusinessException("Id não pode ser nulo");
        }

        return torneioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /* A meta eh receber uma reposta que eh agrupada pelos dados do torneio
     *  e retornar agrupado, junto dessa requisicao, o nomes e apelidos dos times
     * que estao participando desse torneio */
    @Override
    public TorneioResumido getTorneioResumido(Long id) {
        if (id == null) {
            throw new BusinessException("Id não pode ser nulo");
        }

        var torneio = this.findById(id);
        var listTime = timeService.findAll();
        var timesResumido = listTime.stream()
                .filter(time -> Objects.equals(time.getTorneio().getId(), id))
                .map(time -> new TimeResumido(
                        time.getId(),
                        time.getNome(),
                        time.getApto(),
                        time.getConfirIntegrantes(),
                        time.getNacionalidade()
                )).toList();


        return new TorneioResumido(
                torneio.getId(),
                torneio.getTitulo(),
                torneio.getDataInicio(),
                torneio.getEstado(),
                torneio.getCidade(),
                torneio.getConcluido(),
                timesResumido
        );
    }
}
