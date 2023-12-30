package br.com.suporte.model;

import br.com.suporte.model.Enum.Prioridade;
import br.com.suporte.model.Enum.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "chamado")
public class Chamado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataAbertura;
    private Date dataFechamento;
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "tecnico")
    private Tecnico tecnico;
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

}
