package br.gigliarly.torneio_brawhalla_api.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean apto;
    @Column(name = "confirmacao_integrantes")
    private Boolean confirIntegrantes;
    private String nacionalidade;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Jogador> jogadores;
    @OneToOne(cascade = CascadeType.ALL)
    private Diretor diretor;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Torneio torneio;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }
}
