package br.com.deveficiente.calendario.controller.exception;

public class AgendaNotFoundException extends RuntimeException {

    public AgendaNotFoundException(final String message) {
        super(message);
    }
}
