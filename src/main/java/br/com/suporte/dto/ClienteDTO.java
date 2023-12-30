package br.com.suporte.dto;

import br.com.suporte.model.Enum.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;


@Setter
@Getter
@EqualsAndHashCode
public class ClienteDTO{
    private Long id;
    @NotNull(message = "O nome não pode ser nulo")
    @NotEmpty(message = "O nome não pode ser vazio")
    private String nome;
    @NotNull(message = "O Sobrenome não pode ser nulo")
    @NotEmpty(message = "O Sobrenome não pode ser vazio")
    private String sobrenome;
    @Email
    private String email;
    @NotNull(message = "O campo Senha não pode ser nulo")
    @NotEmpty(message = "O campo Senha não pode ser vazio")
    private String senha;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataAlterado;


    public ClienteDTO() {
        super();
        Perfil.CLIENTE.getCodigo();
    }

    public ClienteDTO(Long id, String nome, String sobrenome, String email, String senha,Date dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    public ClienteDTO(Long id, String nome, String sobrenome, String email, String senha,Date dataCriacao, Date dataAlterado) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.dataAlterado = dataAlterado;
    }

}
