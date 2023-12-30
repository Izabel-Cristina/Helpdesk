package br.com.suporte.service.serviceImp;

import br.com.suporte.bo.ClienteBO;
import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.dto.ResponseDTO;
import br.com.suporte.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    ClienteBO clienteBO;

    @Override
    public ResponseDTO<String> inserirCliente(ClienteDTO clienteDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            responseDTO.setCode(ResponseDTO.Status.SUCCESS.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setErrorMessage(ResponseDTO.Code.SUCCESS.getMessageCode());
            responseDTO.setData(clienteBO.inserirCliente(clienteDTO));
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
    public ResponseDTO<ClienteDTO> alterarCliente(ClienteDTO clienteDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            responseDTO.setCode(ResponseDTO.Status.SUCCESS.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setErrorMessage(ResponseDTO.Code.SUCCESS.getMessageCode());
            responseDTO.setData(clienteBO.alterarCliente(clienteDTO));
        } catch (ExceptionInInitializerError e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setErrorMessage(e.getMessage());

        } catch (Exception e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code. ERROR_ALTERAR_CLIENTE.getCode());
            responseDTO.setErrorMessage(ResponseDTO.Code. ERROR_ALTERAR_CLIENTE.getMessageCode());
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<String> deletarCliente(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            responseDTO.setCode(ResponseDTO.Status.SUCCESS.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setErrorMessage(ResponseDTO.Code.SUCCESS.getMessageCode());
            responseDTO.setData(clienteBO.deletarCliente(id));
        } catch (ExceptionInInitializerError e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setErrorMessage(e.getMessage());

        } catch (Exception e) {
            responseDTO.setCode(ResponseDTO.Status.ERROR.ordinal());
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_DELETAR_CLIENTE.getCode());
            responseDTO.setErrorMessage(ResponseDTO.Code.ERROR_DELETAR_CLIENTE.getMessageCode());
        }
        return responseDTO;
    }
}
