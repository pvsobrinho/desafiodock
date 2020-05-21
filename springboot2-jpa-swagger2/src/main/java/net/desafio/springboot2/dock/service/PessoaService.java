package net.desafio.springboot2.dock.service;

import net.desafio.springboot2.dock.exception.ResourceNotFoundException;
import net.desafio.springboot2.dock.interfaceService.IPessoaService;
import net.desafio.springboot2.dock.model.Pessoa;
import net.desafio.springboot2.dock.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService implements IPessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    /**
     *
     * @param pessoa
     * @return Pessoa
     */
    public Pessoa save(Pessoa pessoa) throws  Exception{
        List<Pessoa> listPessoa  = new ArrayList<>();
        listPessoa.addAll(pessoaRepository.findByCpf(pessoa.getCpf()));
        if(listPessoa.size() > 0){
              throw new Exception("Já existe uma pessoa cadastrada com o CPF informado.");
        }

        pessoa.setIdPessoa(0);
        return pessoaRepository.save(pessoa);
    }

    /**
     *
     * @param idPessoa
     * @return Pessoa
     * @throws ResourceNotFoundException
     */
    public Pessoa findByIdPessoa(Long idPessoa) throws ResourceNotFoundException {
        return  pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada para o id: " + idPessoa));
    }

    /**
     *
     * @param cpf
     * @return List<Pessoa>
     */
    public List<Pessoa> findByCpf(String cpf) {
        return  pessoaRepository.findByCpf(cpf);

    }

}
