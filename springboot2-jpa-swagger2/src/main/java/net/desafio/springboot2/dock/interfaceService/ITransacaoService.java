package net.desafio.springboot2.dock.interfaceService;

import net.desafio.springboot2.dock.model.Transacao;

import java.util.Date;
import java.util.List;

public interface ITransacaoService {

    Transacao save(Transacao transacao);

    List<Transacao> findByIdConta(long idConta);

    List<Transacao> findByDataTransacaoAfterAndDataTransacaoBefore(String periodoInicial, String periodoFinal) throws Exception;

}
