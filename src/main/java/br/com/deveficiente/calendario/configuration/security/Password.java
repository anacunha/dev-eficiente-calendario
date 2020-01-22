package br.com.deveficiente.calendario.configuration.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {

    private final String hash;

    public Password(final String password, final boolean isHashed) {
        this.hash = isHashed ? password : hash(password);
    }

    private String hash(final String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public String getHash() {
        return this.hash;
    }
}
