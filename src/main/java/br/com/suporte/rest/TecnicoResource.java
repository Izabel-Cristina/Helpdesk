package br.com.suporte.rest;

import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.dto.ResponseDTO;
import br.com.suporte.dto.TecnicoDTO;
import br.com.suporte.service.ClienteService;
import br.com.suporte.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1/tecnicos")
public class TecnicoResource extends BaseResource{
    @Autowired
    TecnicoService tecnicoService;

    @PostMapping("/inserirtecnico")
    public ResponseEntity<ResponseDTO> inserirTecnico(@RequestBody @Valid TecnicoDTO tecnicoDTO) {
        return (ResponseEntity<ResponseDTO>) createdCodeReturn(tecnicoService.inserirTecnico(tecnicoDTO));
    }
    @PutMapping("/alterartecnico")
    public ResponseEntity<ResponseDTO>alterarTecnico(@RequestBody(required = false) TecnicoDTO tecnicoDTO){
        return (ResponseEntity<ResponseDTO>) updatedCodeReturn(tecnicoService.alterarTecnico(tecnicoDTO));
    }

    @DeleteMapping("/deletartecnico/{id}")
    public ResponseEntity<ResponseDTO>deletarTecnico(@PathVariable(required = false)Long id){
        return (ResponseEntity<ResponseDTO>) deleteCodeReturn(tecnicoService.deletarTecnico(id));
    }
}
