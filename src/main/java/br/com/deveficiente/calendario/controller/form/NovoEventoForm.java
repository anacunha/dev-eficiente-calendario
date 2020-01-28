package br.com.deveficiente.calendario.controller.form;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NovoEventoForm {

    @NotBlank
    @Length(max = 100)
    private String titulo;

    @Future
    @NotNull
    private LocalDateTime inico;

    @Future
    @NotNull
    private LocalDateTime termino;

    private List<@Email String> emailsConvidados;

    @NotBlank
    @Length(max = 255)
    private String descricao;

    @NotNull
    private Long idAgenda;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getInico() {
        return inico;
    }

    public void setInico(final LocalDateTime inico) {
        this.inico = inico;
    }

    public LocalDateTime getTermino() {
        return termino;
    }

    public void setTermino(final LocalDateTime termino) {
        this.termino = termino;
    }

    public List<String> getEmailsConvidados() {
        return emailsConvidados;
    }

    public void setEmailsConvidados(final List<String> emailsConvidados) {
        this.emailsConvidados = emailsConvidados;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(final Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    @Override
    public String toString() {
        return "NovoEventoForm{" +
                "titulo='" + titulo + '\'' +
                ", inico=" + inico +
                ", termino=" + termino +
                ", emailsConvidados=" + emailsConvidados +
                ", descricao='" + descricao + '\'' +
                ", idAgenda=" + idAgenda +
                '}';
    }
}
