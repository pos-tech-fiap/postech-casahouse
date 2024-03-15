package br.com.fiap.postechcasahouse.DTO.gestaoServicos;

import br.com.fiap.postechcasahouse.entity.gestaoServicos.Servico;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;


public class ServicoDTO {

    @NotBlank
    private final String nome;
    @NotBlank
    private final Double valor;
    private UUID id;

    public ServicoDTO(Servico servico) {
        this.id = servico.getId();
        this.nome = servico.getNome();
        this.valor = servico.getValor();
    }

    public ServicoDTO(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }
}
