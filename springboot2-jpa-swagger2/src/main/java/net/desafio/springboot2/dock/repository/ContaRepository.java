package net.desafio.springboot2.dock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.desafio.springboot2.dock.model.Conta;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
