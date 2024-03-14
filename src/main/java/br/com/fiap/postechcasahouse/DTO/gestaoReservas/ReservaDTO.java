package br.com.fiap.postechcasahouse.DTO.gestaoReservas;

import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.*;

public class ReservaDTO {

    private UUID id;

    @NotNull(message = "Campo obrigatório")
    private UUID idCliente;

    @NotNull(message = "Campo obrigatório")
    @FutureOrPresent(message = "A data não pode estar no passado")
    private LocalDateTime dataEntrada;

    @FutureOrPresent(message = "A data não pode estar no passado")
    private LocalDateTime dataSaida;

    @NotNull(message = "Campo obrigatório")
    private Integer quantidadePessoas;

    @Positive(message = "Preço dever ser um valor positivo")
    private Double valorTotal;

    @NotNull(message = "Campo obrigatório")
    private Set<UUID> quartos = new HashSet<>();

    private List<UUID> servicos = new ArrayList<>();

    private List<UUID> itens = new ArrayList<>();

    public ReservaDTO() {
    }

    public ReservaDTO(UUID id, UUID idCliente, LocalDateTime dataEntrada, LocalDateTime dataSaida, Integer quantidadePessoas,
                      Double valorTotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quantidadePessoas = quantidadePessoas;
        this.valorTotal = valorTotal;
    }

    public ReservaDTO(Reserva reserva) {
        this.id = reserva.getId();
        this.idCliente = reserva.getIdCliente();
        this.dataEntrada = reserva.getDataEntrada();
        this.dataSaida = reserva.getDataSaida();
        this.quantidadePessoas = reserva.getQuantidadePessoas();
        this.valorTotal = reserva.getValorTotal();
    }

    public ReservaDTO(Reserva reserva, Set<UUID> quartosIds) {
        this(reserva);
        this.quartos.addAll(quartosIds);
    }

    public ReservaDTO(Reserva reserva, Set<UUID> quartosIds, List<UUID> servicosIds) {
        this(reserva);
        this.quartos.addAll(quartosIds);
        this.servicos.addAll(servicosIds);
    }

    public ReservaDTO(Reserva reserva, Set<UUID> quartosIds, List<UUID> servicosIds, List<UUID> itensIds) {
        this(reserva);
        this.quartos.addAll(quartosIds);
        this.servicos.addAll(servicosIds);
        this.itens.addAll(itensIds);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
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

    public Set<UUID> getQuartos() {
        return quartos;
    }

    public void setQuartos(Set<UUID> quartos) {
        this.quartos = quartos;
    }

    public List<UUID> getServicos() {
        return servicos;
    }

    public void setServicos(List<UUID> servicos) {
        this.servicos = servicos;
    }

    public List<UUID> getItens() {
        return itens;
    }

    public void setItens(List<UUID> itens) {
        this.itens = itens;
    }
}
