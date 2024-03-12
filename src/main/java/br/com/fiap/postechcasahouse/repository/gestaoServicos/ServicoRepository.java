package br.com.fiap.postechcasahouse.repository.gestaoServicos;

import br.com.fiap.postechcasahouse.entity.gestaoServicos.Servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, UUID>{

}
