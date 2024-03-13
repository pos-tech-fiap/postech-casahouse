package br.com.fiap.postechcasahouse.DTO.gestaoReservas;

import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import jakarta.persistence.Transient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaDTO {

    private Long id;
    private Long idCliente;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private List<String> quartos = new ArrayList<>();
    private List<String> servicos;
    private List<String> itens;
    private Integer quantidadePessoas;
    private Double valorTotal;

    public ReservaDTO() {
    }

    public ReservaDTO(Long id, Long idCliente, LocalDateTime dataEntrada, LocalDateTime dataSaida, List<String> quartos,
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

    public ReservaDTO(Reserva reserva) {
        this.id = reserva.getId();
        this.idCliente = reserva.getIdCliente();
        this.dataEntrada = reserva.getDataEntrada();
        this.dataSaida = reserva.getDataSaida();
        this.quartos = reserva.getQuartos();
        this.servicos = reserva.getServicos();
        this.itens = reserva.getItens();
        this.quantidadePessoas = reserva.getQuantidadePessoas();
        this.valorTotal = reserva.getValorTotal();
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
}
