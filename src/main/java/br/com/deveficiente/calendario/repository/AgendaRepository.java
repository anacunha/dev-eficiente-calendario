package br.com.deveficiente.calendario.repository;

import br.com.deveficiente.calendario.model.Agenda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Long> {
}
