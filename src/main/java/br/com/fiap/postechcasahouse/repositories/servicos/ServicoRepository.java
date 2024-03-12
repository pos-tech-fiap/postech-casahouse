package br.com.fiap.postechcasahouse.repositories.servicos;

import br.com.fiap.postechcasahouse.models.servicos.Servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, UUID>{

}
