package br.com.fiap.postechcasahouse.entity.gestaoReservas;

import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Quarto;
import br.com.fiap.postechcasahouse.entity.gestaoServicos.Servico;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "tb_reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID idCliente;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private Integer quantidadePessoas;
    private Double valorTotal;

    @ElementCollection
    @CollectionTable(name = "tb_reserva_quarto", joinColumns = @JoinColumn(name = "reserva_id"))
    @Column(name = "quarto_id")
    private Set<UUID> quartos = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_reserva_servico",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id"))
    private List<Servico> servicos;

    @Transient
    private List<String> itens;

    public Reserva() {
    }

    public Reserva(UUID id, UUID idCliente, LocalDateTime dataEntrada, LocalDateTime dataSaida, Integer quantidadePessoas,
                   Double valorTotal, Set<UUID> quartos, List<Servico> servicos, List<String> itens) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quantidadePessoas = quantidadePessoas;
        this.valorTotal = valorTotal;
        this.quartos = quartos;
        this.servicos = servicos;
        this.itens = itens;
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

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
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
