package br.com.suporte.service;

import br.com.suporte.dto.ChamadoDTO;
import br.com.suporte.dto.ResponseDTO;

public interface ChamadoService {
    ResponseDTO<ChamadoDTO> inserirChamado(ChamadoDTO chamadoDTO);

}
