package br.com.suporte.bo;

import br.com.suporte.dto.ChamadoDTO;
import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.model.Chamado;
import br.com.suporte.model.Cliente;
import br.com.suporte.repository.ChamadoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class ChamadoBO {
    @Autowired
    ChamadoRepository chamadoRepository;
    public ChamadoDTO inserirChamado(ChamadoDTO chamadoDTO) throws Exception{
        ClienteDTO nome = chamadoDTO.getCliente();
        chamadoDTO.getTecnico();
        chamadoDTO.getTitulo();
        chamadoDTO.getObservacao();
        chamadoDTO.getDataAbertura();
        chamadoDTO.getObservacao();


        chamadoRepository.save(new Chamado());

        return chamadoDTO;
    }

}
