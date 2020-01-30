package br.com.deveficiente.calendario.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(max = 100)
    private final String titulo;

    @Future
    @NotNull
    private final LocalDateTime inico;

    @Future
    @NotNull
    private final LocalDateTime termino;

    @NotBlank
    @Length(max = 255)
    private final String descricao;

    @ManyToMany
    private final Set<Usuario> convidados = new HashSet<>();

    @NotNull
    @ManyToOne
    private final Agenda agenda;

    @NotNull
    @ManyToOne
    private final Usuario dono;

    public Evento(@NotBlank @Length(max = 100) final String titulo, @Future @NotNull final LocalDateTime inico,
                  @Future @NotNull final LocalDateTime termino, @NotBlank @Length(max = 255) final String descricao,
                  final Set<Usuario> convidados, @NotNull final Agenda agenda,
                  @NotNull final Usuario dono) {
        this.titulo = titulo;
        this.inico = inico;
        this.termino = termino;
        this.descricao = descricao;
        this.convidados.addAll(convidados);
        this.agenda = agenda;
        this.dono = dono;
    }
}
