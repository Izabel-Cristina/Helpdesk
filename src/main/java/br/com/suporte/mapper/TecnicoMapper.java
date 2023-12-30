package br.com.suporte.mapper;

import br.com.suporte.dto.TecnicoDTO;
import br.com.suporte.model.Tecnico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TecnicoMapper extends EntityMapper<TecnicoDTO, Tecnico> {
}
