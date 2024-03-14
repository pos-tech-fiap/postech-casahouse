package br.com.fiap.postechcasahouse.entity.gestaoServicos;

import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private Double valor;

    @ManyToMany(mappedBy = "servicos")
    private Set<Reserva> reservas = new HashSet<>();

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
