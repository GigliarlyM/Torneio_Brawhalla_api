package br.gigliarly.torneio_brawhalla_api.dto;

import br.gigliarly.torneio_brawhalla_api.entity.Jogador;

public record JogadorDTO(
        Long id,
        String nome,
        int idade,
        String apelido,
        boolean apto,
        boolean documentos,
        String nacionalidade,
        String estado,
        String cidade
) {
    public Jogador toEntity() {
        Jogador result = new Jogador();

        result.setId(id);
        result.setNome(nome);
        result.setIdade(idade);
        result.setApelido(apelido);
        result.setApto(apto);
        result.setDocumentos(documentos);
        result.setNacionalidade(nacionalidade);
        result.setEstado(estado);
        result.setCidade(cidade);

        return result;
    }
}
