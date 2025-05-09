package br.gigliarly.torneio_brawhalla_api.dto;

import br.gigliarly.torneio_brawhalla_api.entity.Torneio;

public record TorneioDTO(
        Long id,
        String titulo,
        String dataInicio,
        String estado,
        String cidade,
        Boolean concluido
        //List<TimeResumido>times
) {
    public Torneio toEntity() {
        Torneio result = new Torneio();

        result.setId(id);
        result.setTitulo(titulo);
        result.setDataInicio(dataInicio);
        result.setEstado(estado);
        result.setCidade(cidade);
        result.setConcluido(concluido);

        return result;
    }
}
