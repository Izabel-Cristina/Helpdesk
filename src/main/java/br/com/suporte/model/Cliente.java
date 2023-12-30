package br.com.suporte.model;

import br.com.suporte.model.Enum.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente", catalog = "projeto_suporte")
@DiscriminatorValue("CLIENTE")
@Setter
@Getter
@AllArgsConstructor
public class Cliente extends Pessoa {

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Chamado> listaChamados = new ArrayList<>();

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Long id, String nome, String sobrenome, String email, String senha, Date dataCriacao, Date dataAlterado) {
        super(id, nome,sobrenome, email, senha, dataCriacao, dataAlterado);
        addPerfil(Perfil.CLIENTE);
    }



    public Cliente(Long id, String nome, String sobrenome, String email, String senha, Date dataAlterado) {
        super(id, nome,sobrenome, email, senha,dataAlterado);
        addPerfil(Perfil.CLIENTE);
    }


}



