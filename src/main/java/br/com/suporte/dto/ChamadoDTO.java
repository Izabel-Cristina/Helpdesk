package br.com.suporte.dto;

import br.com.suporte.model.Cliente;
import br.com.suporte.model.Enum.Prioridade;
import br.com.suporte.model.Enum.Status;
import br.com.suporte.model.Tecnico;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ChamadoDTO {
    private Long id;
    private Date dataAbertura;
    private Date dataFechamento;
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteDTO cliente;

}
