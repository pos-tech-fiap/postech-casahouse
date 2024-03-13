package br.com.fiap.postechcasahouse.repository.gestaoReservas;

import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaRepository {

    @Autowired
    private IReservaRepository reservaRepository;

    public Page<Reserva> findAll(Pageable pageable) {
        return reservaRepository.findAll(pageable);
    }
}
