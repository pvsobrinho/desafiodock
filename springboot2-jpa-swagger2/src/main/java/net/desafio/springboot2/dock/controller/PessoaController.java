package net.desafio.springboot2.dock.controller;

import io.swagger.annotations.*;
import net.desafio.springboot2.dock.exception.ResourceNotFoundException;
import net.desafio.springboot2.dock.interfaceService.IPessoaService;
import net.desafio.springboot2.dock.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/dock/pessoa")
@Api(value="Conta Dock  - Management System", description="Operaçoes do cliente")
public class PessoaController {

    @Autowired
    private IPessoaService pessoaService;

    @ApiOperation(value = "Cadastrar Cliente")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
            @ApiResponse(code = 400, message = "Formato incompatível."),
            @ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
            @ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
            @ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
            @ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
    @PostMapping("/criar")
    public Pessoa createConta(
            @ApiParam(value = "Armazenar uma nova pessoa", required = true)
            @Valid @RequestBody Pessoa pessoa) throws Exception {

        return pessoaService.save(pessoa);
    }


    @ApiOperation(value = "Obter pessoa por Id ")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
            @ApiResponse(code = 400, message = "Formato incompatível."),
            @ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
            @ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
            @ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
            @ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
    @GetMapping("/idPessoa/{idPesoa}")
    public ResponseEntity<Pessoa> getPessoaById(
            @ApiParam(value = "ID da pessoa da qual o objeto da pessoa será recuperado", required = true)
            @PathVariable(value = "idPesoa") Long idPesoa)
            throws ResourceNotFoundException {

        return ResponseEntity.ok().body(pessoaService.findByIdPessoa(idPesoa));
    }
}

