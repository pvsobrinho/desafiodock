package net.desafio.springboot2.dock.service;

import net.desafio.springboot2.dock.interfaceService.ITransacaoService;
import net.desafio.springboot2.dock.model.Transacao;
import net.desafio.springboot2.dock.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService implements ITransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    /**
     *
     * @param transacao
     * @return Transacao
     */
    public Transacao save(Transacao transacao){
        transacao.setIdTransacao(0);
        return transacaoRepository.save(transacao);
    }

    /**
     *
     * @param idConta
     * @return List<Transacao>
     */
    public List<Transacao> findByIdConta(long idConta){
        return transacaoRepository.findByIdConta(idConta);
    }

}
