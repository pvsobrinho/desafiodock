package net.desafio.springboot2.dock.service;

import net.desafio.springboot2.dock.exception.ResourceNotFoundException;
import net.desafio.springboot2.dock.interfaceService.IContaService;
import net.desafio.springboot2.dock.model.Conta;
import net.desafio.springboot2.dock.model.Pessoa;
import net.desafio.springboot2.dock.model.PessoaConta;
import net.desafio.springboot2.dock.model.Transacao;
import net.desafio.springboot2.dock.repository.ContaRepository;
import net.desafio.springboot2.dock.repository.PessoaContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Service
public class ContaService implements IContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private PessoaContaRepository pessoaContaRepository;

    @Autowired
    private  PessoaService pessoaService;

    @Autowired
    private  TransacaoService transacaoService;

    public List<Conta> findAll(){
        return contaRepository.findAll();
    }

    /**
     *
     * @param idConta
     * @return Conta
     * @throws ResourceNotFoundException
     */
    public Conta findByIdConta(Long idConta) throws ResourceNotFoundException {
        return  contaRepository.findById(idConta)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada para o id: " + idConta));
    }

    /**
     *
     * @param idConta
     * @param valorDebitar
     * @return String
     * @throws ResourceNotFoundException
     */
    public String saqueByIdConta(Long idConta, BigDecimal valorDebitar) throws Exception{
        Conta conta = new Conta();
        conta = findByIdConta(idConta);
        if(conta.isFlagAtivo().equals(0L)){
            throw new Exception("ERRO ao realizar deposito. A conta " + idConta + " não está ativa.");
        }
        if(valorDebitar.compareTo(conta.getLimiteSaqueDiario()) == 1){
            throw new Exception("OPERAÇÃO NÃO REALIZADA: Limite de saque diário insuficiente. Valor do limite R$ " + conta.getLimiteSaqueDiario().toString());

        }
        if(valorDebitar.compareTo(conta.getSaldo()) == 1){
            throw new Exception("OPERAÇÃO NÃO REALIZADA: Saldo  insuficiente. Valor do saldo atual R$ " + conta.getSaldo().toString());
        }
        conta.setLimiteSaqueDiario(conta.getLimiteSaqueDiario().subtract(valorDebitar));
        conta.setSaldo(conta.getSaldo().subtract(valorDebitar));
        Transacao transacao = new Transacao();
        transacao.setDataTransacao(new Date());
        transacao.setIdTransacao(0);
        transacao.setIdConta(idConta);
        transacao.setValor(valorDebitar.negate());
        transacao.setDescricao("DEBITO EM CONTA");
        try {
            transacaoService.save(transacao);
        }catch (Exception e){
            throw new Exception("ERRO ao realizar saque.");
        }
        contaRepository.save(conta);
        return "O valor foi debitado da conta.";
    }

    /**
     *
     * @param idConta
     * @param valorCreditar
     * @return String
     * @throws ResourceNotFoundException
     */
    public String depositoByIdConta(Long idConta, BigDecimal valorCreditar) throws Exception{
        Conta conta = new Conta();
        conta = findByIdConta(idConta);
        if(conta.isFlagAtivo().equals(0L)){
            throw new Exception("ERRO ao realizar deposito. A conta " + idConta + " não está ativa.");
        }
        conta.setSaldo(conta.getSaldo().add(valorCreditar));
        Transacao transacao = new Transacao();
        transacao.setDataTransacao(new Date());
        transacao.setIdTransacao(0);
        transacao.setIdConta(idConta);
        transacao.setValor(valorCreditar);
        transacao.setDescricao("CREDITO EM CONTA");
        try {
            transacaoService.save(transacao);
        }catch (Exception e){
            throw new Exception("ERRO ao realizar deposito");
        }
        contaRepository.save(conta);
        return "O valor foi creditado da conta.";
    }

    /**
     *
     * @param idConta
     * @return String
     * @throws ResourceNotFoundException
     */
    public String findSaldoByIdConta(Long idConta) throws ResourceNotFoundException{
        Conta conta = new Conta();
        conta = contaRepository.findById(idConta)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada para o id: " + idConta));
        Pessoa pessoa = new Pessoa();
        pessoa = pessoaService.findByIdPessoa(conta.getIdPessoa());
        return "Saldo da conta de  " + pessoa.getNome() + " -  R$ " + conta.getSaldo().toString();
    }

    /**
     *
     * @param conta
     * @return Conta
     */
    public Conta save(Conta conta) throws ResourceNotFoundException {
        Pessoa pessoa = new Pessoa();
        pessoa = pessoaService.findByIdPessoa(conta.getIdPessoa());
        Conta contaNova = new Conta();
        contaNova =  contaRepository.save(conta);
        PessoaConta pessoaConta = new PessoaConta();
        pessoaConta.setIdConta(contaNova.getIdConta());
        pessoaConta.setIdPessoa(pessoa.getIdPessoa());
        pessoaContaRepository.save(pessoaConta);

        return contaNova;
    }

    /**
     *
     * @param idConta
     * @param contaDetails
     * @return Conta
     * @throws ResourceNotFoundException
     */
    public Conta updateConta(Long idConta, Conta contaDetails) throws ResourceNotFoundException {
        Conta conta = contaRepository.findById(idConta)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada para o id:: " + idConta));

        conta.setSaldo(contaDetails.getSaldo());
        conta.setIdPessoa(contaDetails.getIdPessoa());
        final Conta updatedConta = contaRepository.save(conta);
        return updatedConta;
    }

    /**
     *
     * @param idConta
     * @return Conta
     * @throws ResourceNotFoundException
     */
    public Conta desativarContaByIdConta(Long idConta) throws ResourceNotFoundException{
        Conta conta = contaRepository.findById(idConta)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada para o id :: " + idConta));
        conta.setFlagAtivo(0L);
        return contaRepository.save(conta);
    }

    /**
     *
     * @param idConta
     * @return Conta
     * @throws ResourceNotFoundException
     */
    public Conta ativarContaByIdConta(Long idConta) throws ResourceNotFoundException{
        Conta conta = contaRepository.findById(idConta)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada para o id :: " + idConta));

        conta.setFlagAtivo(1L);
        return contaRepository.save(conta);

    }

}
