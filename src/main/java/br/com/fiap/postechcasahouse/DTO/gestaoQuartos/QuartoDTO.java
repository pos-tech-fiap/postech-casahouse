package br.com.fiap.postechcasahouse.DTO.gestaoQuartos;

import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Quarto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public class QuartoDTO {
    private UUID id;
    @NotBlank
    private String nome;
    @NotNull
    private UUID predioId;
    @NotNull
    private UUID tipoQuartoId;



    public QuartoDTO(UUID id, String nome, UUID predioId, UUID tipoQuartoId) {
        this.id = id;
        this.nome = nome;
        this.predioId = predioId;
        this.tipoQuartoId = tipoQuartoId;

    }

    public QuartoDTO(Quarto quarto) {
        this.id = quarto.getId();
        this.nome = quarto.getNome();
        this.predioId = quarto.getPredioId();
        this.tipoQuartoId = quarto.getTipoQuartoId();
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

    public UUID getPredioId() {
        return predioId;
    }

    public void setPredioId(UUID localidadeId) {
        this.predioId = localidadeId;
    }

    public UUID getTipoQuartoId() {
        return tipoQuartoId;
    }

    public void setTipoQuartoId(UUID tipoQuartoId) {
        this.tipoQuartoId = tipoQuartoId;
    }
}
