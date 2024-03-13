package br.com.fiap.postechcasahouse.entity.gestaoReservas;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCliente;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    @Transient
    private List<String> quartos = new ArrayList<>();
    @Transient
    private List<String> servicos = new ArrayList<>();
    @Transient
    private List<String> itens = new ArrayList<>();
    private Integer quantidadePessoas;
    private Double valorTotal;

    public Reserva(){
    }

    public Reserva(Long id, Long idCliente, LocalDateTime dataEntrada, LocalDateTime dataSaida, List<String> quartos,
                   List<String> servicos, List<String> itens, Integer quantidadePessoas, Double valorTotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quartos = quartos;
        this.servicos = servicos;
        this.itens = itens;
        this.quantidadePessoas = quantidadePessoas;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public List<String> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<String> quartos) {
        this.quartos = quartos;
    }

    public List<String> getServicos() {
        return servicos;
    }

    public void setServicos(List<String> servicos) {
        this.servicos = servicos;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
