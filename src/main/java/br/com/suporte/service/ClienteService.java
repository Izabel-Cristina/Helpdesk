package br.com.suporte.service;

import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.dto.ResponseDTO;
import org.springframework.stereotype.Service;


public interface ClienteService {
    ResponseDTO<String> inserirCliente(ClienteDTO clienteDTO);
    ResponseDTO<ClienteDTO> alterarCliente(ClienteDTO clienteDTO);
    ResponseDTO<String> deletarCliente(Long id);

}
