package br.com.deveficiente.calendario.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(unique = true)
    private final String login;

    @NotBlank
    @Length(min = 6)
    private final String senha;

    @PastOrPresent
    @NotNull
    private final LocalDateTime dataCadastro = LocalDateTime.now();

    public Usuario(final String login, final String senha) {
        this.login = login;
        this.senha = senha;
    }
}
