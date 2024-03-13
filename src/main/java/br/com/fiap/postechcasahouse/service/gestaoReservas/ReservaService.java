package br.com.fiap.postechcasahouse.service.gestaoReservas;

import br.com.fiap.postechcasahouse.DTO.gestaoReservas.ReservaDTO;
import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import br.com.fiap.postechcasahouse.repository.gestaoReservas.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    @Transactional(readOnly = true)
    public Page<ReservaDTO> findAll(Pageable pageable) {
        Page<Reserva> reservas = reservaRepository.findAll(pageable);
        return reservas.map(ReservaDTO::new);
    }


}
