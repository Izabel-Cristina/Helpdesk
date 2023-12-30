package br.com.suporte.model;

import br.com.suporte.model.Enum.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tecnico", catalog = "projeto_suporte")
@DiscriminatorValue("TECNICO")
@Setter
@Getter
@AllArgsConstructor
public class Tecnico extends Pessoa {
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
    private List<Chamado> listaChamados = new ArrayList<>();

    public Tecnico() {
        super();
        addPerfil(Perfil.TECNICO);
    }

    public Tecnico(Long id, String nome, String sobrenome, String email, String senha, Date dataCriacao, Date dataAlterado) {
        super(id, nome,sobrenome, email, senha, dataCriacao, dataAlterado);
        addPerfil(Perfil.TECNICO);
    }
}
