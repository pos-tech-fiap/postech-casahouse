package br.com.fiap.postechcasahouse.DTO.gestaoServicos;

import br.com.fiap.postechcasahouse.entity.gestaoServicos.Item;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class ItemDTO {

    private UUID id;

    @NotBlank
    private String nome;

    @NotBlank
    private Double valor;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.nome = item.getNome();
        this.valor = item.getValor();
    }

    public ItemDTO(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }
}