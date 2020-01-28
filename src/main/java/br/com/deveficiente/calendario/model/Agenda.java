package br.com.deveficiente.calendario.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Agenda {

    private static final String DESCRICAO_DEFAULT = "Agenda %s";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private final String nome;

    @Length(max = 255)
    @NotEmpty
    private final String descricao;

    @ManyToOne
    @NotNull
    private final Usuario dono;

    public Agenda(final Usuario dono) {
        this.nome = dono.getNome();
        this.descricao = String.format(DESCRICAO_DEFAULT, dono.getNome());
        this.dono = dono;
    }
}
