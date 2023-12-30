package br.com.suporte.model;

import br.com.suporte.model.Enum.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
@AllArgsConstructor
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public abstract class Pessoa implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "criado_em")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCriacao;
    @Column(name = "alterado_em")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataAlterado;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "senha")
    private String senha;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    protected Set<Integer> perfis = new HashSet<>();

    public Pessoa() {
        super();

    }

    public Pessoa(Long id, String nome, String sobrenome, String email, String senha, Date dataCriacao) {
        super();
        this.id = id;
        this.nome = nome;
        this.sobrenome= sobrenome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }
    public Pessoa(Long id, String nome, String sobrenome, String email, String senha,Date dataCriacao, Date dataAlterado) {
        super();
        this.id = id;
        this.nome = nome;
        this.sobrenome= sobrenome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.dataAlterado = dataAlterado;
    }

    public Pessoa( String nome, String sobrenome, String email, String senha,Date dataCriacao, Date dataAlterado) {
        super();
        this.nome = nome;
        this.sobrenome= sobrenome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.dataAlterado = dataAlterado;
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }
    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

}
