package br.com.fiap.postechcasahouse.DTO.gestaoQuartos;

import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Amenidades;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Descricao;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.TipoQuarto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class TipoQuartoDTO {
    private UUID id;
    @NotBlank
    private String nome;
    @NotNull
    private Integer totCamas;
    @NotNull
    private Integer totPessoas;
    @NotNull
    private Integer totBanheiros;
    @NotNull
    private double valorDiaria;
    private Set<Descricao> descricao = new HashSet<>();

    public TipoQuartoDTO(UUID id, String nome, Integer totCamas, Integer totPessoas, Integer totBanheiros, double valorDiaria, Descricao descricao) {
        this.id = id;
        this.nome = nome;
        this.totCamas = totCamas;
        this.totPessoas = totPessoas;
        this.totBanheiros = totBanheiros;
        this.valorDiaria = valorDiaria;
        this.descricao.add(descricao);
    }

    public TipoQuartoDTO(TipoQuarto tipoQuarto) {
        this.id = tipoQuarto.getId();
        this.nome = tipoQuarto.getNome();
        this.descricao = tipoQuarto.getDescricao();
        this.totBanheiros = tipoQuarto.getTotBanheiros();
        this.totCamas = tipoQuarto.getTotCamas();
        this.totPessoas = tipoQuarto.getTotPessoas();
        this.valorDiaria = tipoQuarto.getvalorDiaria();

    }
    public Set<Descricao> getDescricao() {
        return descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = (Set<Descricao>) Collections.singletonList(descricao);
    }

    public UUID getId() {
        return id;
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

    public Integer getTotBanheiros() {
        return totBanheiros;
    }

    public void setTotBanheiros(Integer totBanheiros) {
        this.totBanheiros = totBanheiros;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
