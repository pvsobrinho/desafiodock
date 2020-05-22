package net.desafio.springboot2.dock.controller;

import io.swagger.annotations.*;
import net.desafio.springboot2.dock.exception.ResourceNotFoundException;
import net.desafio.springboot2.dock.interfaceService.ITransacaoService;
import net.desafio.springboot2.dock.model.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dock/transacao")
@Api(value="Transacoes Dock  - Management System", description="Transacoes de conta bancária")
public class TransacaoController {

    @Autowired
    ITransacaoService transacaoService;

    @ApiOperation(value = "Visualizar a lista de  transacoes de uma conta", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
            @ApiResponse(code = 400, message = "Formato incompatível."),
            @ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
            @ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
            @ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
            @ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
    @GetMapping("/listarByIdConta/{idConta}")
    public List<Transacao> getTransacoesByIdConta(
            @ApiParam(value = "ID da conta da qual o objeto da Transacao será recuperado", required = true)
            @PathVariable(value = "idConta") Long idConta)
            throws ResourceNotFoundException {

        return transacaoService.findByIdConta(idConta);
    }

    @ApiOperation(value = "Visualizar a lista de  transacoes de uma conta", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
            @ApiResponse(code = 400, message = "Formato incompatível."),
            @ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
            @ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
            @ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
            @ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
    @GetMapping("/listarByIdContaByPeriodo/{idConta}/periodoInicial/{periodoInicial}/periodoFinal/{periodoFinal}")
    public List<Transacao> getTransacoesByIdConta(
            @ApiParam(value = "ID da conta da qual o objeto da Transacao será recuperado", required = true)
            @PathVariable(value = "idConta") Long idConta,
            @PathVariable(value = "periodoInicial") String periodoInicial,
            @PathVariable(value = "periodoFinal") String periodoFinal)
            throws Exception {
        return transacaoService.findByDataTransacaoAfterAndDataTransacaoBefore(periodoInicial, periodoFinal);
    }
}
