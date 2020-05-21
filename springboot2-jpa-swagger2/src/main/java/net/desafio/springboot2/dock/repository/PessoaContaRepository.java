package net.desafio.springboot2.dock.repository;

import net.desafio.springboot2.dock.model.PessoaConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaContaRepository extends JpaRepository<PessoaConta, Long> {
}
