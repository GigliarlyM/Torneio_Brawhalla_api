package br.gigliarly.torneio_brawhalla_api.dto;

import br.gigliarly.torneio_brawhalla_api.entity.Time;

public record TimeDto(
        Long id,
        String nome,
        Boolean apto,
        boolean confirIntegrantes,
        String nacionalidade
) {

    public Time toEntity() {
        Time result = new Time();

        result.setId(id);
        result.setNome(nome);
        result.setApto(apto);
        result.setConfirIntegrantes(confirIntegrantes);
        result.setNacionalidade(nacionalidade);

        return result;
    }
}
