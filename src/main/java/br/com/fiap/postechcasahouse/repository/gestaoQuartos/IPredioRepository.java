package br.com.fiap.postechcasahouse.repository.gestaoQuartos;

import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Predio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPredioRepository extends JpaRepository<Predio, UUID> {

}
