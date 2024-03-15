package br.com.fiap.postechcasahouse.repository.gestaoQuartos;

import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IQuartoRepository extends JpaRepository<Quarto, UUID> {
    @Query(value = "SELECT q.* FROM tb_quarto q LEFT JOIN tb_reserva_quarto rq ON q.id = rq.quarto_id WHERE rq.reserva_id IS NULL", nativeQuery = true)
    List<Quarto> findAvailableRooms();
}
