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

    public Agenda(final String nome, final String descricao, final Usuario dono) {
        this.nome = nome;
        this.descricao = descricao;
        this.dono = dono;
    }
}
