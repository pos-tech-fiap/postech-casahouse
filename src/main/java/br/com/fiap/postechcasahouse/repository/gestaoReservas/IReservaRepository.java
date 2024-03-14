package br.com.fiap.postechcasahouse.repository.gestaoReservas;

import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, UUID> {
}
