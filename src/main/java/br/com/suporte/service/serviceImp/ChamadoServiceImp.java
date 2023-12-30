package br.com.suporte.service.serviceImp;

import br.com.suporte.bo.ChamadoBO;
import br.com.suporte.dto.ChamadoDTO;
import br.com.suporte.dto.ResponseDTO;
import br.com.suporte.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadoServiceImp implements ChamadoService {

    @Autowired
    ChamadoBO chamadoBO;

    @Override
    public ResponseDTO<ChamadoDTO> inserirChamado(ChamadoDTO chamadoDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            responseDTO.setCode(ResponseDTO.Status.SUCCESS.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setErrorMessage(ResponseDTO.Code.SUCCESS.getMessageCode());
            responseDTO.setData(chamadoBO.inserirChamado(chamadoDTO));

        } catch (Exception e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_INSERIR_CLIENTE.getCode());
            responseDTO.setErrorMessage(ResponseDTO.Code.ERROR_INSERIR_CLIENTE.getMessageCode());
            responseDTO.setData(null);
        }
        return responseDTO;
    }
}
