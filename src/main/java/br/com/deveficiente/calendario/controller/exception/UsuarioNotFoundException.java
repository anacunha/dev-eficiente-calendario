package br.com.deveficiente.calendario.controller.exception;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(final String message) {
        super(message);
    }
}
