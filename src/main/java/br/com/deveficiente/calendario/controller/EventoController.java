package br.com.deveficiente.calendario.controller;

import br.com.deveficiente.calendario.controller.form.NovoEventoForm;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import br.com.deveficiente.calendario.validator.PeriodoEventoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class EventoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @InitBinder
    public void init(final WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new PeriodoEventoValidator());
    }

    @PostMapping("/api/evento")
    @Transactional
    public void cria(@RequestBody @Valid final NovoEventoForm form) {
        System.out.println(form);

        // TODO Validar lista de e-mails
        // TODO Carregar Usuário logado
        // TODO Carregar Agenda a partir do id
        // TODO Criar Evento
        // TODO Salvar Evento
    }
}
