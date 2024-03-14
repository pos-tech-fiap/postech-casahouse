package br.com.fiap.postechcasahouse.DTO.gestaoQuartos;

import java.util.*;

import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Amenidades;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Localidade;
import jakarta.validation.constraints.NotBlank;


public class LocalidadeDTO {
    private UUID id;
    @NotBlank
    private String nome;
    private Set<Amenidades> amenidades = new HashSet<>();
    @NotBlank
    private String rua;
    @NotBlank
    private String cep;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;

    public LocalidadeDTO(UUID id, String nome, Amenidades amenidades, String rua, String cep, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.amenidades.add(amenidades);
        this.rua = rua;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public LocalidadeDTO(Localidade localidade) {
        this.nome = localidade.getNome();
        this.rua = localidade.getRua();
        this.cep = localidade.getCep();
        this.amenidades = localidade.getAmenidades();
        this.cidade = localidade.getCidade();
        this.estado = localidade.getEstado();
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

    public Set<Amenidades> getAmenidades() {
        return amenidades;
    }

    public void setAmenidades(Amenidades amenidades) {
        this.amenidades = (Set<Amenidades>) Collections.singletonList(amenidades);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
