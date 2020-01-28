package br.com.deveficiente.calendario.model;

import br.com.deveficiente.calendario.configuration.security.Password;
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
    private String login;

    @NotBlank
    @Length(min = 6)
    private String senha;

    @NotBlank
    private String nome;

    @PastOrPresent
    @NotNull
    private final LocalDateTime dataCadastro = LocalDateTime.now();

    @Deprecated
    public Usuario() {
    }

    public Usuario(final String login, final Password password, final String nome) {
        this.login = login;
        this.senha = password.getHash();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
