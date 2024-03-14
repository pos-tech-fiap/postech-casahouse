package br.com.fiap.postechcasahouse.repository.gestaoQuartos;

import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IQuartoRepository extends JpaRepository<Quarto, UUID> {
}
