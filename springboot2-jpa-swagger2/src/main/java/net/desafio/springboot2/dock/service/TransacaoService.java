package net.desafio.springboot2.dock.service;

import net.desafio.springboot2.dock.interfaceService.ITransacaoService;
import net.desafio.springboot2.dock.model.Transacao;
import net.desafio.springboot2.dock.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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


    /**
     *
     * @param periodoInicialV
     * @param periodoFinalV
     * @return
     */
    public List<Transacao> findByDataTransacaoAfterAndDataTransacaoBefore(String periodoInicialV, String periodoFinalV) throws Exception {

        // FORMATO DE DATA  "May 2, 2020";
        try {
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date periodoInicial = format.parse(periodoInicialV);
            Date periodoFinal = format.parse(periodoFinalV);

            return transacaoRepository.findByDataTransacaoAfterAndDataTransacaoBefore(periodoInicial, periodoFinal);
        }catch (Exception e){
            throw new Exception("Formato incorreto " + e.getMessage());
        }
    }

}
