package br.com.fiap.postechcasahouse.DTO.gestaoReservas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class EmailDTO {
    private UUID id;
    @NotNull
    private String para;
    @NotNull
    private String assunto;
    @NotNull
    private String texto;

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
