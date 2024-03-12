package br.com.fiap.postechcasahouse.repository.gestaoQuartos;

import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Localidade;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ILocalidadeRepository extends JpaRepository<Localidade, UUID> {

}
