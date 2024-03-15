package br.com.fiap.postechcasahouse.entity.gestaoQuartos;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_tipo_quarto")
public class TipoQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private Integer totCamas;
    private Integer totPessoas;
    private Integer totBanheiros;
    private Double valorDiaria;
    @Enumerated(EnumType.STRING)
    private Set<Descricao> descricao;

    public Integer getTotBanheiros() {
        return totBanheiros;
    }

    public void setTotBanheiros(Integer totBanheiros) {
        this.totBanheiros = totBanheiros;
    }

    public Double getvalorDiaria() {
        return valorDiaria;
    }

    public void setvalorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTotCamas() {
        return totCamas;
    }

    public void setTotCamas(Integer totCamas) {
        this.totCamas = totCamas;
    }

    public Integer getTotPessoas() {
        return totPessoas;
    }

    public void setTotPessoas(Integer totPessoas) {
        this.totPessoas = totPessoas;
    }

    public Set<Descricao> getDescricao() {
        return descricao;
    }

    public void setDescricao(Set<Descricao> descricao) {
        this.descricao = descricao;
    }
}
