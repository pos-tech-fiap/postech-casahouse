package br.com.fiap.postechcasahouse.DTO.gestaoUsuarios;

import br.com.fiap.postechcasahouse.entity.gestaoUsuarios.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;


public class UsuarioDTO {
    private UUID id;
    @NotNull
    private String nome;
    @NotNull
    private String CPF;
    @NotNull
    private String origem;
    @NotNull
    private String passaporte;
    @NotNull
    private LocalDateTime dataNascimento;
    @NotNull
    private String endereco;
    @NotNull
    private String telefone;
    @NotNull
    private String email;

    public UsuarioDTO(UUID id, String nome, String CPF, String origem, String passaporte, LocalDateTime dataNascimento, String endereço, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.origem = origem;
        this.passaporte = passaporte;
        this.dataNascimento = dataNascimento;
        this.endereco = endereço;
        this.telefone = telefone;
        this.email = email;
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.CPF = usuario.getCPF();
        this.origem = usuario.getOrigem();
        this.passaporte = usuario.getPassaporte();
        this.dataNascimento = usuario.getDataNascimento();
        this.endereco = usuario.getEndereco();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
