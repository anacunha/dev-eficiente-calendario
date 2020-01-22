package br.com.deveficiente.calendario.controller;

import br.com.deveficiente.calendario.controller.form.NovoUsuarioForm;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/api/usuario")
    public void cadastra(@RequestBody @Valid final NovoUsuarioForm form) {
        final Usuario usuario = form.toModel();
        usuarioRepository.save(usuario);
    }
}
