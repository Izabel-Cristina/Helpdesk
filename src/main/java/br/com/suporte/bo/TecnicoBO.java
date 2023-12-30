package br.com.suporte.bo;

import br.com.suporte.dto.ClienteDTO;
import br.com.suporte.dto.TecnicoDTO;
import br.com.suporte.mapper.TecnicoMapper;
import br.com.suporte.model.Cliente;
import br.com.suporte.model.Pessoa;
import br.com.suporte.model.Tecnico;
import br.com.suporte.repository.PessoaRepository;
import br.com.suporte.repository.TecnicoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Component
public class TecnicoBO {

    private final PessoaRepository pessoaRepository;
    private final TecnicoRepository tecnicoRepository;
    private final TecnicoMapper tecnicoMapper;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public TecnicoBO(PessoaRepository pessoaRepository, TecnicoRepository tecnicoRepository, TecnicoMapper tecnicoMapper) {
        this.pessoaRepository = pessoaRepository;
        this.tecnicoRepository = tecnicoRepository;
        this.tecnicoMapper = tecnicoMapper;
    }

    public String inserirTecnico(TecnicoDTO tecnicoDTO) throws Exception, ExceptionInInitializerError {
        String nome = tecnicoDTO.getNome();
        String sobrenome = tecnicoDTO.getSobrenome();
        String email = tecnicoDTO.getEmail();
        String senha = bCryptPasswordEncoder.encode(tecnicoDTO.getSenha());
        tecnicoDTO.setSenha(senha);

        LocalDate dataCriacao = LocalDate.now();
        tecnicoDTO.setDataCriacao(Date.valueOf(dataCriacao));

        if (nome.trim().isEmpty() || sobrenome.trim().isEmpty() || email.trim().isEmpty()) {
            throw new Exception("Nome, sobrenome e email são obrigatórios");
        }

        Optional<Pessoa> consultaLogin = pessoaRepository.findByEmail(email);

        if (consultaLogin.isPresent()) {
            throw new ExceptionInInitializerError("Login já existente!");
        }

        // Mapeie ClienteDTO para Cliente usando o Mapper
        Tecnico tecnico = tecnicoMapper.toEntity(tecnicoDTO);

        // Salve o cliente no repositório
        tecnicoRepository.save(tecnico);


        String mensagem = "Usuário incluido com sucesso!";

        return mensagem;
    }

    public TecnicoDTO alterarTecnico(TecnicoDTO tecnicoDTO) throws Exception, ExceptionInInitializerError {
        Long id = tecnicoDTO.getId();
        String nome = tecnicoDTO.getNome();
        String sobrenome = tecnicoDTO.getSobrenome();
        String email =tecnicoDTO.getEmail();
        String senha = bCryptPasswordEncoder.encode(tecnicoDTO.getSenha());


        if (nome.trim().isEmpty() || sobrenome.trim().isEmpty() || email.trim().isEmpty()) {
            throw new Exception("Nome, sobrenome e email são obrigatórios");
        }

        // Verifique se o cliente existe
        Tecnico tecnicoExistente = tecnicoRepository.findById(id).orElse(null);
        if (tecnicoExistente == null) {
            throw new Exception("Cliente não encontrado");
        }

        // Mantenha a data de criação inalterada
        Date dataCriacao = tecnicoExistente.getDataCriacao();
        tecnicoExistente.setDataCriacao(dataCriacao);
        // Atualize os campos do cliente existente
        tecnicoExistente.setNome(nome);
        tecnicoExistente.setSobrenome(sobrenome);
        tecnicoExistente.setEmail(email);
        tecnicoExistente.setSenha(senha);
        LocalDate dataAlteracao = LocalDate.now();
        tecnicoExistente.setDataAlterado(Date.valueOf(dataAlteracao));
        // Salve o cliente no repositório
        tecnicoRepository.save(tecnicoExistente);

        return tecnicoDTO;
    }
    public String deletarTecnico(Long id) {
        String mensagem = null;
        Long codigoTecnico= id;
        Optional<Tecnico> idEncontrado = (tecnicoRepository.findById(codigoTecnico));
        if (idEncontrado.isPresent()) {
            tecnicoRepository.deleteById(codigoTecnico);
            mensagem = "Cliente removido com sucesso!";
        } else {
            mensagem = "Cliente não encontrado";
        }
        return mensagem;
    }
}
