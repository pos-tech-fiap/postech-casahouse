package br.com.fiap.postechcasahouse.repository.gestaoReservas;

import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository extends JpaRepository<Reserva, Long> {
}
