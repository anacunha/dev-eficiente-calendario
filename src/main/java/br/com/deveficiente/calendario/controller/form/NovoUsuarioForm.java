package br.com.deveficiente.calendario.controller.form;

import br.com.deveficiente.calendario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NovoUsuarioForm {

    @NotBlank
    @Email
    private final String login;

    @NotBlank
    @Length(min = 6)
    private final String senha;

    public NovoUsuarioForm(@NotBlank @Email final String login, @NotBlank @Length(min = 6) final String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario toModel() {
        return new Usuario(this.login, this.senha);
    }
}
