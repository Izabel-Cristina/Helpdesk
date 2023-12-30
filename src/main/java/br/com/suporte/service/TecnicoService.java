package br.com.suporte.service;

import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.dto.ResponseDTO;
import br.com.suporte.dto.TecnicoDTO;

public interface TecnicoService {
    ResponseDTO<String> inserirTecnico(TecnicoDTO tecnicoDTO);
    ResponseDTO<ClienteDTO> alterarTecnico(TecnicoDTO tecnicoDTO);
    ResponseDTO<String> deletarTecnico(Long id);
}
