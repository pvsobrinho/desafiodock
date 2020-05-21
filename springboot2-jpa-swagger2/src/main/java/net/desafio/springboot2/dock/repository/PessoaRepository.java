package net.desafio.springboot2.dock.repository;

import net.desafio.springboot2.dock.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    List<Pessoa> findByCpf(String cpf);
}
