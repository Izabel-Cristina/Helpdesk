package br.com.suporte.bo;

import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.mapper.ClienteMapper;
import br.com.suporte.model.Cliente;
import br.com.suporte.model.Pessoa;
import br.com.suporte.repository.ClienteRepository;
import br.com.suporte.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ClienteBO {
    private final PessoaRepository pessoaRepository;
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public ClienteBO(ClienteRepository clienteRepository, ClienteMapper clienteMapper,
                     PessoaRepository pessoaRepository) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.pessoaRepository = pessoaRepository;
    }

    public String inserirCliente(ClienteDTO clienteDTO) throws Exception, ExceptionInInitializerError {
        String nome = clienteDTO.getNome();
        String sobrenome = clienteDTO.getSobrenome();
        String email = clienteDTO.getEmail();
        String senha = bCryptPasswordEncoder.encode(clienteDTO.getSenha());
        clienteDTO.setSenha(senha);

        LocalDate dataCriacao = LocalDate.now();
        clienteDTO.setDataCriacao(Date.valueOf(dataCriacao));

        if (nome.trim().isEmpty() || sobrenome.trim().isEmpty() || email.trim().isEmpty()) {
            throw new Exception("Nome, sobrenome e email são obrigatórios");
        }

        Optional<Pessoa> consultaLogin = pessoaRepository.findByEmail(email);

        if (consultaLogin.isPresent()) {
            throw new ExceptionInInitializerError("Login já existente!");
        }

        // Mapeie ClienteDTO para Cliente usando o Mapper
        Cliente cliente = clienteMapper.toEntity(clienteDTO);

        // Salve o cliente no repositório
        clienteRepository.save(cliente);
        log.debug("Data de criação antes de salvar: {}", cliente.getDataCriacao());


        String mensagem = "Usuário incluido com sucesso!";

        return mensagem;
    }

    public ClienteDTO alterarCliente(ClienteDTO clienteDTO) throws Exception, ExceptionInInitializerError {
        Long id = clienteDTO.getId();
        String nome = clienteDTO.getNome();
        String sobrenome = clienteDTO.getSobrenome();
        String email = clienteDTO.getEmail();
        String senha = bCryptPasswordEncoder.encode(clienteDTO.getSenha());


        if (nome.trim().isEmpty() || sobrenome.trim().isEmpty() || email.trim().isEmpty()) {
            throw new Exception("Nome, sobrenome e email são obrigatórios");
        }

        // Verifique se o cliente existe
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
        if (clienteExistente == null) {
            throw new Exception("Cliente não encontrado");
        }

        // Mantenha a data de criação inalterada
        Date dataCriacao = clienteExistente.getDataCriacao();
        clienteExistente.setDataCriacao(dataCriacao);
        // Atualize os campos do cliente existente
        clienteExistente.setNome(nome);
        clienteExistente.setSobrenome(sobrenome);
        clienteExistente.setEmail(email);
        clienteExistente.setSenha(senha);
        LocalDate dataAlteracao = LocalDate.now();
        clienteExistente.setDataAlterado(Date.valueOf(dataAlteracao));
        // Salve o cliente no repositório
        clienteRepository.save(clienteExistente);

        return clienteDTO;
    }

    public List<ClienteDTO>listarCliente(){
        List<ClienteDTO> clientes = new ArrayList<>();
        ClienteDTO cliente = (ClienteDTO) clienteRepository.findAll();

        return clientes;

    }
    public String deletarCliente(Long id) {
        String mensagem = null;
        Long codigoCliente = id;
        Optional<Cliente> idEncontrado = (clienteRepository.findById(codigoCliente));
        if (idEncontrado.isPresent()) {
            clienteRepository.deleteById(codigoCliente);
            mensagem = "Cliente removido com sucesso!";
        } else {
            mensagem = "Cliente não encontrado";
        }
        return mensagem;
    }

}
