package br.com.fiap.postechcasahouse.DTO.gestaoQuartos;

import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Predio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public class PredioDTO {
    private UUID id;
    @NotBlank
    private String nome;
    @NotNull
    private UUID localidadeId;


    public PredioDTO(UUID id, String nome, UUID localidadeId) {
        this.id = id;
        this.nome = nome;
        this.localidadeId = localidadeId;

    }

    public PredioDTO(Predio predio) {
        this.id = predio.getId();
        this.nome = predio.getNome();
        this.localidadeId = predio.getLocalidadeId();

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

    public UUID getLocalidadeId() {
        return localidadeId;
    }

    public void setLocalidadeId(UUID localidadeId) {
        this.localidadeId = localidadeId;
    }
}
