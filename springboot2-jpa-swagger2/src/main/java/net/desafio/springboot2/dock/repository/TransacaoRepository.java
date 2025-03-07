package net.desafio.springboot2.dock.repository;

import net.desafio.springboot2.dock.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findByIdConta(long idConta);

    List<Transacao> findByDataTransacaoAfterAndDataTransacaoBefore(Date periodoInicial, Date periodoFinal);


}
