package net.desafio.springboot2.dock.interfaceService;

import net.desafio.springboot2.dock.exception.ResourceNotFoundException;
import net.desafio.springboot2.dock.model.Conta;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public interface IContaService  {

    List<Conta> findAll();

    Conta findByIdConta(Long idConta) throws ResourceNotFoundException;

    Conta desativarContaByIdConta(Long idConta) throws ResourceNotFoundException;

    Conta ativarContaByIdConta(Long idConta) throws ResourceNotFoundException;

    String findSaldoByIdConta(Long idConta) throws ResourceNotFoundException;

    String saqueByIdConta(Long idConta, BigDecimal valorDebitar) throws ResourceNotFoundException, Exception;

    String depositoByIdConta(Long idConta, BigDecimal valorCreditar) throws ResourceNotFoundException, Exception;

    Conta save(Conta conta) throws ResourceNotFoundException;

    Conta updateConta(Long idConta, Conta contaDetails) throws ResourceNotFoundException;

    Map<String, Boolean> deleteConta(Long idConta ) throws ResourceNotFoundException;

}
