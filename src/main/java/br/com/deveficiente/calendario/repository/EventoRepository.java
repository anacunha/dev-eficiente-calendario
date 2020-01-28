package br.com.deveficiente.calendario.repository;

import br.com.deveficiente.calendario.model.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {
}
