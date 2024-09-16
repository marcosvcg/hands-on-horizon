# Hands On! - Horizon
Implementação do desafio do processo seletivo para estágio em desenvolvimento na Horizon

## Pré-requisitos:
Para executar o sistema, você irá precisar de:
1. Java SDK 17 ou superior [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
2. PostgreSQL 15 [PostgreSQL 15](https://www.postgresql.org/download/)
3. IDE da sua escolha, como por exemplo o IntteliJ [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Configuração do Banco de Dados:
1. Vá para o arquivo "applicaion.properties" em src/main/resources
2. Altere as credenciais para os dados da sua máquina, como por exemplo:
```properties
spring.datasource.username=${DATABASE_USER} = postgres
spring.datasource.password=${DATABASE_PASSWORD} = postgres
spring.datasource.url=${DATABASE_URL} = jdbc:postgresql://localhost:5432/{nomeDoDatabase}
```

## Como executar o projeto:
1. Acesse a URL do servidor: https://localhost:8080
2. Em seguida, acesse o Swagger para testar as requisições: https://localhost:8080/swagger-ui.html
3. Execute as requisições conforme os request bodies!

## Executando a aplicação:
Segundo o diagrama do banco de dados, é preciso criar uma pessoa para poder testar as outras funcionalidades.
![Schema de PessoaDTO](https://github.com/marcosvcg/marcosvcg/blob/main/images/handsonhorizon/schemas/pessoaDTO_schema.png "Schema de PessoaDTO")

Após criar a pessoa, é possível criar uma conta bancária (que pode ser do tipo "CORRENTE" ou "POUPANCA") passando "pessoaId" como chave estrangeira.
![Schema de ContaDTO](https://github.com/marcosvcg/marcosvcg/blob/main/images/handsonhorizon/schemas/contaDTO_schema.png "Schema de ContaDTO")

Por fim, para realizar uma transferência é necessário passar "contaOrigemId" e "contaDestinoId" como chaves estrangeiras para efetuar a operação (transferência para a mesma conta não é permitida!).
![Schema de TransferenciaDTO](https://github.com/marcosvcg/marcosvcg/blob/main/images/handsonhorizon/schemas/transferenciaDTO_schema.png "Schema de TransferenciaDTO")

## Funcionalidades principais:
### Criar Pessoa
![Criar Pessoa](https://github.com/marcosvcg/marcosvcg/blob/main/images/handsonhorizon/funcionalidades/criar_pessoa.png "Criar Pessoa")

### Criar Conta
![Criar Conta](https://github.com/marcosvcg/marcosvcg/blob/main/images/handsonhorizon/funcionalidades/criar_conta.png "Criar Conta")

### Realizar Transferência
![Realizar Transferencia](https://github.com/marcosvcg/marcosvcg/blob/main/images/handsonhorizon/funcionalidades/realizar_transferencia.png "Realizar Transferencia")

### Consultar Saldo
![Consultar Saldo](https://github.com/marcosvcg/marcosvcg/blob/main/images/handsonhorizon/funcionalidades/consultar_saldo.png "Consultar Saldo")
