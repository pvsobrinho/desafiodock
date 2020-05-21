package net.desafio.springboot2.dock.interfaceService;

import net.desafio.springboot2.dock.exception.ResourceNotFoundException;
import net.desafio.springboot2.dock.model.Pessoa;

import java.util.List;

public interface IPessoaService {

    Pessoa save(Pessoa pessoa) throws Exception;

    Pessoa findByIdPessoa(Long idPessoa) throws ResourceNotFoundException;

    List<Pessoa> findByCpf(String cpf);

}
