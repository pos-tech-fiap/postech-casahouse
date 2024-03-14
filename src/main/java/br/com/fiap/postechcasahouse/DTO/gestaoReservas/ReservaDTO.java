package br.com.fiap.postechcasahouse.DTO.gestaoReservas;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.QuartoDTO;
import br.com.fiap.postechcasahouse.DTO.gestaoServicos.ServicoDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Quarto;
import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import br.com.fiap.postechcasahouse.entity.gestaoServicos.Servico;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ReservaDTO {

    private UUID id;

    @NotBlank(message = "Campo obrigatório")
    private UUID idCliente;

    @NotBlank(message = "Campo obrigatório")
    @FutureOrPresent(message = "A data não pode estar no passado")
    private LocalDateTime dataEntrada;

    @FutureOrPresent(message = "A data não pode estar no passado")
    private LocalDateTime dataSaida;

    @NotBlank(message = "Campo obrigatório")
    private Integer quantidadePessoas;

    @Positive(message = "Preço dever ser um valor positivo")
    private Double valorTotal;

    @NotBlank(message = "Campo obrigatório")
    private List<QuartoDTO> quartos = new ArrayList<>();

    private List<ServicoDTO> servicos = new ArrayList<>();

    private List<String> itens = new ArrayList<>();

    public ReservaDTO() {
    }

    public ReservaDTO(UUID id, UUID idCliente, LocalDateTime dataEntrada, LocalDateTime dataSaida, Integer quantidadePessoas,
                      Double valorTotal, List<String> itens) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quantidadePessoas = quantidadePessoas;
        this.valorTotal = valorTotal;
        this.itens = itens;
    }

    public ReservaDTO(Reserva reserva) {
        this.id = reserva.getId();
        this.idCliente = reserva.getIdCliente();
        this.dataEntrada = reserva.getDataEntrada();
        this.dataSaida = reserva.getDataSaida();
        this.quantidadePessoas = reserva.getQuantidadePessoas();
        this.valorTotal = reserva.getValorTotal();
    }

    public ReservaDTO(Reserva reserva, Set<Quarto> quartos, List<Servico> servicos) {
        this(reserva);
        quartos.forEach(quarto -> this.quartos.add(new QuartoDTO(quarto)));
        servicos.forEach(servico -> this.servicos.add(new ServicoDTO(servico)));
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

    public List<QuartoDTO> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<QuartoDTO> quartos) {
        this.quartos = quartos;
    }

    public List<ServicoDTO> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoDTO> servicos) {
        this.servicos = servicos;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }
}
