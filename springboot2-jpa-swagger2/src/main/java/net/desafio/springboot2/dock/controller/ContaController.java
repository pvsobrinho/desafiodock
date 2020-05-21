package net.desafio.springboot2.dock.controller;

import io.swagger.annotations.*;
import net.desafio.springboot2.dock.exception.ResourceNotFoundException;
import net.desafio.springboot2.dock.interfaceService.IContaService;
import net.desafio.springboot2.dock.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/dock/conta")
@Api(value="Conta Dock  - Management System", description="Operaçoes de conta bancária")
public class ContaController {

	@Autowired
	private IContaService contaService;

	@ApiOperation(value = "Visualizar a lista de contas", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
			@ApiResponse(code = 400, message = "Formato incompatível."),
			@ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
			@ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
			@ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
			@ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
	@GetMapping("/listar")
	public List<Conta> getAllContas() {
		return contaService.findAll();
	}

	@ApiOperation(value = "Obter conta por Id - consulta limite de saque e Saldo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
			@ApiResponse(code = 400, message = "Formato incompatível."),
			@ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
			@ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
			@ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
			@ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
	@GetMapping("/numeroConta/{idConta}")
	public ResponseEntity<Conta> getContaById(
			@ApiParam(value = "ID da conta da qual o objeto da conta será recuperado", required = true)
			@PathVariable(value = "idConta") Long idConta)
			throws ResourceNotFoundException {

		return ResponseEntity.ok().body(contaService.findByIdConta(idConta));
	}

	@ApiOperation(value = "Obter saldo da conta por Id - consulta limite de saque e Saldo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
			@ApiResponse(code = 400, message = "Formato incompatível."),
			@ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
			@ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
			@ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
			@ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
	@GetMapping("/saldo/numeroConta/{idConta}")
	public String getSaldoContaById(
			@ApiParam(value = "ID da conta da qual o objeto da conta será recuperado", required = true)
			@PathVariable(value = "idConta") Long idConta)
			throws ResourceNotFoundException {

		return contaService.findSaldoByIdConta(idConta);
	}

	@ApiOperation(value = "Realiza o saque da conta por IdConta")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
			@ApiResponse(code = 400, message = "Formato incompatível."),
			@ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
			@ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
			@ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
			@ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
	@PutMapping("/saqueValor/{valorDebitar}/numeroConta/{idConta}")
	public String saqueContaById(
			@ApiParam(value = "Valor de Depósito e Numero da conta que será efetuado o Saque", required = true)
			@PathVariable(value = "idConta") Long idConta,
			@PathVariable(value = "valorDebitar") BigDecimal valorDebitar)
			throws Exception {

		return contaService.saqueByIdConta(idConta, valorDebitar);
	}

	@ApiOperation(value = "Realiza o deposito em uma conta por IdConta")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
			@ApiResponse(code = 400, message = "Formato incompatível."),
			@ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
			@ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
			@ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
			@ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
	@PutMapping("/depositoValor/{valorCreditar}/numeroConta/{idConta}")
	public String depositoContaById(
			@ApiParam(value = "Valor de Depósito e Numero da conta que será efetuado o Deposito", required = true)
			@PathVariable(value = "idConta") Long idConta,
			@PathVariable(value = "valorCreditar") BigDecimal valorCreditar)
			throws Exception {

		return contaService.depositoByIdConta(idConta, valorCreditar);
	}

	@ApiOperation(value = "Criar conta")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
			@ApiResponse(code = 400, message = "Formato incompatível."),
			@ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
			@ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
			@ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
			@ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
	@PostMapping("/criar")
	public Conta createConta(
			@ApiParam(value = "Armazenar uma nova conta", required = true)
			@Valid @RequestBody Conta conta) throws ResourceNotFoundException {

		return contaService.save(conta);
	}

	@ApiOperation(value = "Atualizar conta")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operação Realizada com Sucesso."),
			@ApiResponse(code = 400, message = "Formato incompatível."),
			@ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
			@ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
			@ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
			@ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
	@PutMapping("/atualizar/{idConta}")
	public ResponseEntity<Conta> updateConta(
			@ApiParam(value = "Conta Id para atualizar a partir do modelo fornecido", required = true)
			@PathVariable(value = "idConta") Long idConta,
			@ApiParam(value = "Atualizar objeto conta", required = true)
			@Valid @RequestBody Conta contaDetails) throws ResourceNotFoundException {

		return ResponseEntity.ok(contaService.updateConta(idConta, contaDetails));
	}


	@ApiOperation(value = "Desativar uma conta por idConta")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Desativado. Operação Realizada com Sucesso."),
			@ApiResponse(code = 400, message = "Formato incompatível."),
			@ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
			@ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
			@ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
			@ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
	@PutMapping("/desativar/numeroConta/{idConta}")
	public Conta desativarContaByIdConta(
			@ApiParam(value = "ID da conta da qual o objeto da conta será recuperado", required = true)
			@PathVariable(value = "idConta") Long idConta)
			throws ResourceNotFoundException {

		return contaService.desativarContaByIdConta(idConta);
	}

	@ApiOperation(value = "Ativar uma conta por idConta")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ativado. Operação Realizada com Sucesso."),
			@ApiResponse(code = 400, message = "Formato incompatível."),
			@ApiResponse(code = 401, message = "Você não possui autorização para acessar este recurso."),
			@ApiResponse(code = 403, message = "Acesso bloqueado ao recurso solicitado."),
			@ApiResponse(code = 404, message = "O recurso que esta tentando acessar não está disponível."),
			@ApiResponse(code = 500, message = "Ocorreu um erro em sua solicitação. Tente mais tarde.")})
	@PutMapping("/ativar/numeroConta/{idConta}")
	public Conta ativarrContaByIdConta(
			@ApiParam(value = "ID da conta da qual o objeto da conta será recuperado", required = true)
			@PathVariable(value = "idConta") Long idConta)
			throws ResourceNotFoundException {

		return contaService.ativarContaByIdConta(idConta);
	}
}
