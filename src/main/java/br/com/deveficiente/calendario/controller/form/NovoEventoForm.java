package br.com.deveficiente.calendario.controller.form;

import br.com.deveficiente.calendario.model.Agenda;
import br.com.deveficiente.calendario.model.Evento;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.AgendaRepository;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class NovoEventoForm {

    @NotBlank
    @Length(max = 100)
    private String titulo;

    @Future
    @NotNull
    private LocalDateTime inico;

    @Future
    @NotNull
    private LocalDateTime termino;

    @NotBlank
    @Length(max = 255)
    private String descricao;

    private List<@Email String> emailsConvidados = new ArrayList<>();

    @NotNull
    private Long idAgenda;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getInico() {
        return inico;
    }

    public void setInico(final LocalDateTime inico) {
        this.inico = inico;
    }

    public LocalDateTime getTermino() {
        return termino;
    }

    public void setTermino(final LocalDateTime termino) {
        this.termino = termino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public List<String> getEmailsConvidados() {
        return emailsConvidados;
    }

    public void setEmailsConvidados(final List<String> emailsConvidados) {
        this.emailsConvidados = emailsConvidados;
    }

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(final Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Evento toModel(final AgendaRepository agendaRepository, final UsuarioRepository usuarioRepository,
                          final Usuario dono) {
        final Agenda agenda = agendaRepository.findById(idAgenda)
                .orElseThrow(() -> new IllegalArgumentException("Agenda com id " + idAgenda + " não existe"));

        final Set<Usuario> convidados = emailsConvidados.stream()
                .map(email -> usuarioRepository.findByLogin(email).get())
                .collect(Collectors.toSet());

        return new Evento(titulo, inico, termino, descricao, convidados, agenda, dono);
    }

    public boolean isTerminoAfterInicio() {
        return termino.isAfter(inico);
    }
}
