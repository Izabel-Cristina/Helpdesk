package br.com.suporte.rest;

import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.dto.ResponseDTO;
import br.com.suporte.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1/clientes")
public class ClienteResource extends BaseResource{
    @Autowired
    ClienteService clienteService;

    @PostMapping("/inserircliente")
    public ResponseEntity<ResponseDTO> inserirCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        return (ResponseEntity<ResponseDTO>) createdCodeReturn(clienteService.inserirCliente(clienteDTO));
    }
    @PutMapping("/alterarcliente")
    public ResponseEntity<ResponseDTO>alterarCliente(@RequestBody(required = false) ClienteDTO clienteDTO){
        return (ResponseEntity<ResponseDTO>) updatedCodeReturn(clienteService.alterarCliente(clienteDTO));
    }

    @DeleteMapping("/deletarcliente/{id}")
    public ResponseEntity<ResponseDTO>deletarCliente(@PathVariable(required = false)Long id){
        return (ResponseEntity<ResponseDTO>) deleteCodeReturn(clienteService.deletarCliente(id));
    }

}
