package br.com.suporte.rest;

import br.com.suporte.dto.ChamadoDTO;
import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.dto.ResponseDTO;
import br.com.suporte.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/v1/chamado")
public class ChamadoResource extends BaseResource{

    @Autowired
    ChamadoService chamadoService;

    @PostMapping("/inserirchamado")
    public ResponseEntity<ResponseDTO<ChamadoDTO>> inserirChamado(@RequestBody @Valid ChamadoDTO chamadoDTO) {
        return (ResponseEntity<ResponseDTO<ChamadoDTO>>) createdCodeReturn(chamadoService.inserirChamado(chamadoDTO));
    }

}
