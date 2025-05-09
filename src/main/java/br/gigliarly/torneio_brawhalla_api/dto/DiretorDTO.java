package br.gigliarly.torneio_brawhalla_api.dto;

import br.gigliarly.torneio_brawhalla_api.entity.Diretor;

public record DiretorDTO(
        Long id,
        String nome,
        int idade,
        String nacionalidade,
        String estado,
        String cidade
) {
    public Diretor toEntity(){
        Diretor result = new Diretor();

        result.setId(id);
        result.setNome(nome);
        result.setIdade(idade);
        result.setNacionalidade(nacionalidade);
        result.setEstado(estado);
        result.setCidade(cidade);

        return result;
    }
}
