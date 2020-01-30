package br.com.deveficiente.calendario.validator;

import br.com.deveficiente.calendario.controller.form.NovoEventoForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PeriodoEventoValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return NovoEventoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        final NovoEventoForm novoEventoForm = (NovoEventoForm) target;

        if (!novoEventoForm.isTerminoAfterInicio()) {
            errors.rejectValue("termino", null, "Término do evento deve ocorrer após o Início do evento");
        }
    }
}
