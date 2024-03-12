package br.com.fiap.postechcasahouse.DTO.gestaoServicos;

import java.util.UUID;

import br.com.fiap.postechcasahouse.entity.gestaoServicos.Servico;
import jakarta.validation.constraints.NotBlank;


public class ServicoDTO {

    private UUID id;

    @NotBlank
    private String nome;

    @NotBlank
    private Double valor;

    public ServicoDTO(Servico servico) {
        this.id = servico.getId();
        this.nome = servico.getNome();
        this.valor = servico.getValor();
    }

    public ServicoDTO(String nome, Double valor) {
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
