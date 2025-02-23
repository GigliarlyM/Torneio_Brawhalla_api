package br.gigliarly.torneio_brawhalla_api.controller.dto;

import br.gigliarly.torneio_brawhalla_api.entity.Time;

public record TimeDto(
        String nome,
        Boolean apto
) {
    public TimeDto(Time model) {
        this(
                model.getNome(),
                model.getApto()
        );
    }

    public Time toModel() {
        return new Time() {{
            setNome(nome);
            setApto(apto);
        }};
    }
}

