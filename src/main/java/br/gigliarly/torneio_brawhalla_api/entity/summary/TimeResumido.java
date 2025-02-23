package br.gigliarly.torneio_brawhalla_api.entity.summary;

public class TimeResumido {
    Long id;
    String nome;
    Boolean apto;
    Boolean confirIntegrantes;
    String nacionalidade;

    public TimeResumido(Long id, String nome, Boolean apto, Boolean confirIntegrantes, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.apto = apto;
        this.confirIntegrantes = confirIntegrantes;
        this.nacionalidade = nacionalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getApto() {
        return apto;
    }

    public void setApto(Boolean apto) {
        this.apto = apto;
    }

    public Boolean getConfirIntegrantes() {
        return confirIntegrantes;
    }

    public void setConfirIntegrantes(Boolean confirIntegrantes) {
        this.confirIntegrantes = confirIntegrantes;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
