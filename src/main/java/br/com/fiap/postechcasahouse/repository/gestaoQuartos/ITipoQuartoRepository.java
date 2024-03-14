package br.com.fiap.postechcasahouse.repository.gestaoQuartos;

import br.com.fiap.postechcasahouse.entity.gestaoQuartos.TipoQuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ITipoQuartoRepository extends JpaRepository<TipoQuarto, UUID> {

}
