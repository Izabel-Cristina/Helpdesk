package br.com.suporte.model.Enum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public enum Status {
    ABERTO(1, "Aberto"),
    ANDAMENTO(2, "Em Andamento"),
    CONCLUIDO(3, "Concluído");
    private Integer codigo;
    private String descricao;

    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Status toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (Status x : Status.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Status inválido");
    }
}
