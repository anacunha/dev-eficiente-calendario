package br.com.deveficiente.calendario.validator;

import br.com.deveficiente.calendario.controller.form.NovoEventoForm;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class ConvidadosEventoValidator implements Validator {

    private final UsuarioRepository usuarioRepository;

    public ConvidadosEventoValidator(final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public boolean supports(final Class<?> clazz) {
        return NovoEventoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        final NovoEventoForm novoEventoForm = (NovoEventoForm) target;
        final List<String> emailsConvidados = novoEventoForm.getEmailsConvidados();

        for (final String email : emailsConvidados) {
            if (!usuarioRepository.findByLogin(email).isPresent()) {
                errors.rejectValue("emailsConvidados", null, "E-mail [" + email + "] não cadastrado.");
            }
        }
    }
}
