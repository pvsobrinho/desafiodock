# desafiodock
*Instruções para configuração do ambiente e manual do sistema consulte os arquivos pdf na raíz do diretório.*


INSTRUÇÕES:

Desafio Processo Seletivo Dock - Desenvolvedor 

Desafio Técnico
Nós trabalhamos com meios de pagamento e nada melhor do que um bom sistema para gestão de contas:


Pré-requisitos:

* Desenvolver os recursos em API Rest que realizam operações bancárias com a entidade conta a seguir:
Contas	Tipo
idConta	Numérico
idPessoa	Numérico
saldo	Monetário
limiteSaqueDiario	Monetário
flagAtivo	Condicional
tipoConta	Numérido
dataCriacao	Data
* Tabela de transações realizadas na conta
Transacoes	Tipo
idTransacao	Numérico
idConta	Numérico
valor	Monetário
dataTransacao	Data
* P.S.: Não é necessário realizar operações com a tabela pessoa, mas é necessária a criação da tabela para mapeamento da relação com a conta e enviar script de criação de pelo menos uma pessoa.
Pessoas	Tipo
idPessoa	Numérico
nome	Texto
cpf	Texto
dataNascimento	Data
O que esperamos como escopo mínimo:

* Implementar path que realiza a criação de uma conta;
* Implementar path que realiza operação de depósito em uma conta;
* Implementar path que realiza operação de consulta de saldo em determinada conta;
* Implementar path que realiza operação de saque em uma conta;
* Implementar path que realiza o bloqueio de uma conta;
* Implementar path que recupera o extrato de transações de uma conta;
O que será diferencial:

* Implementar extrato por período;
* Elaborar manual de execução;
* Elaborar documentação;
* Elaborar testes.
O que vamos avaliar:

* Seu código;   
* Script de banco;
* Organização;
* Boas práticas;
* Diferenciais;      
Instruções
  1. Faça o fork do desafio;
  2. Crie um repositório privado no seu github para o projeto e adicione como colaborador o usuário wesleyjoliveira;
  3. Desenvolva. Você terá 7 (sete) dias a partir da data do envio do desafio;   
  4. Após concluir seu trabalho faça um push;   
  5. Envie um e-mail à pessoa que está mantendo o contato com você durante o processo notificando a finalização do 
