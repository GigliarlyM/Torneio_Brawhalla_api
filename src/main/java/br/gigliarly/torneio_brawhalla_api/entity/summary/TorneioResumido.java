package br.gigliarly.torneio_brawhalla_api.entity.summary;

import java.util.List;

public class TorneioResumido {
    Long id;
    String titulo;
    String dataInicio;
    String estado;
    String cidade;
    Boolean concluido;
    List<TimeResumido> times;

    public TorneioResumido(Long id, String titulo, String dataInicio, String estado, String cidade, Boolean concluido, List<TimeResumido> times) {
        this.id = id;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.estado = estado;
        this.cidade = cidade;
        this.concluido = concluido;
        this.times = times;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TimeResumido> getTimes() {
        return times;
    }

    public void setTimes(List<TimeResumido> times) {
        this.times = times;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }
}
