package br.com.fiap.postechcasahouse.repository.gestaoUsuarios;

import br.com.fiap.postechcasahouse.entity.gestaoUsuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, UUID> {
}
