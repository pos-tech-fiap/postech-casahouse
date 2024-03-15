package br.com.fiap.postechcasahouse.entity.gestaoQuartos;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_quarto")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private UUID predioId;
    private UUID tipoQuartoId;

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

    public void setPredioId(UUID predioId) {
        this.predioId = predioId;
    }

    public UUID getTipoQuartoId() {
        return this.tipoQuartoId;
    }

    public void setTipoQuartoId(UUID tipoQuartoId) {
        this.tipoQuartoId = tipoQuartoId;
    }
}
