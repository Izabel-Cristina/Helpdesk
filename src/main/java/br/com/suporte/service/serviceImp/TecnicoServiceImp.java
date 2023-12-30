package br.com.suporte.service.serviceImp;

import br.com.suporte.bo.TecnicoBO;
import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.dto.ResponseDTO;
import br.com.suporte.dto.TecnicoDTO;
import br.com.suporte.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoServiceImp implements TecnicoService {
    @Autowired
    TecnicoBO tecnicoBO;

    @Override
    public ResponseDTO<String> inserirTecnico(TecnicoDTO tecnicoDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            responseDTO.setCode(ResponseDTO.Status.SUCCESS.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setErrorMessage(ResponseDTO.Code.SUCCESS.getMessageCode());
            responseDTO.setData(tecnicoBO.inserirTecnico(tecnicoDTO));
        } catch (ExceptionInInitializerError e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setErrorMessage(e.getMessage());

        } catch (Exception e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_INSERIR_CLIENTE.getCode());
            responseDTO.setErrorMessage(ResponseDTO.Code.ERROR_INSERIR_CLIENTE.getMessageCode());
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<ClienteDTO> alterarTecnico(TecnicoDTO tecnicoDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            responseDTO.setCode(ResponseDTO.Status.SUCCESS.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setErrorMessage(ResponseDTO.Code.SUCCESS.getMessageCode());
            responseDTO.setData(tecnicoBO.alterarTecnico(tecnicoDTO));
        } catch (ExceptionInInitializerError e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setErrorMessage(e.getMessage());

        } catch (Exception e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_INSERIR_CLIENTE.getCode());
            responseDTO.setErrorMessage(ResponseDTO.Code.ERROR_INSERIR_CLIENTE.getMessageCode());
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<String> deletarTecnico(Long id) {

        ResponseDTO responseDTO = new ResponseDTO();
        try {
            responseDTO.setCode(ResponseDTO.Status.SUCCESS.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setErrorMessage(ResponseDTO.Code.SUCCESS.getMessageCode());
            responseDTO.setData(tecnicoBO.deletarTecnico(id));
        } catch (ExceptionInInitializerError e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setErrorMessage(e.getMessage());

        } catch (Exception e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_INSERIR_CLIENTE.getCode());
            responseDTO.setErrorMessage(ResponseDTO.Code.ERROR_INSERIR_CLIENTE.getMessageCode());
        }
        return responseDTO;
    }
}
