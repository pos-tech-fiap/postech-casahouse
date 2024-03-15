package br.com.fiap.postechcasahouse.repository.gestaoReservas;

import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, UUID> {

    Optional<Object> findByQuartosInAndDataEntradaLessThanEqualAndDataSaidaGreaterThanEqual(Set<UUID> quartos, LocalDateTime dataEntrada, LocalDateTime dataSaida);
}
