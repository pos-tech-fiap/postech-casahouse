package br.com.fiap.postechcasahouse.entity.gestaoQuartos;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_predio")
public class Predio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private UUID localidadeID;

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

    public UUID getLocalidadeID() {
        return localidadeID;
    }

    public void setLocalidadeID(UUID localidadeID) {
        this.localidadeID = localidadeID;
    }
}
