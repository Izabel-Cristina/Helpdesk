package br.com.suporte.mapper;

import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.model.Cliente;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {})
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {

}
