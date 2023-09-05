# ecommerce_api
# API de Gerenciamento de Endereços

Este é um projeto de API REST desenvolvido em Java com o framework Spring Boot e utiliza o MySQL como banco de dados para gerenciar endereços de clientes. 
Ele fornece quatro principais funcionalidades:

1. Consulta de Endereço por CEP.
2. Adição de Endereço e Cliente.
3. Consulta de Endereços de um Cliente por Email.
4. Adicionar os Endereços
5.  Listaagem de todos os Clientes e seus respectivos endereços

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter as seguintes ferramentas e recursos instalados:

- Java Development Kit (JDK)
- Maven
- MySQL
- Uma IDE Java (recomendado: IntelliJ IDEA ou Eclipse)

## Configuração

1. Clone este repositório:
comando: git clone https://github.com/seu-usuario/ecommerce_api.git


2. Configure as propriedades do banco de dados no arquivo `application.properties` localizado em `src/main/resources`. Você deve especificar a URL, nome de usuário e senha do banco de dados MySQL.

spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update


## Executando o Projeto

Você pode executar o projeto de duas maneiras: através da sua IDE de desenvolvimento ou usando o Maven na linha de comando.

### Usando a IDE (IntelliJ IDEA ou Eclipse)

1. Abra o projeto na sua IDE.

2. Execute a classe principal `ApiEcommerceApplication` para iniciar o servidor Spring Boot.

### Usando o Maven

1. Na raiz do projeto, execute o seguinte comando:
mvn spring-boot:run


O servidor Spring Boot será iniciado.

## Como Chamar as APIs

### 1. Consulta de Endereço por CEP

Para consultar um endereço por CEP, faça uma solicitação GET para a seguinte URL:
http://localhost:8080/api/v1/address/{cep}


Substitua `{cep}` pelo CEP que deseja consultar.

### 2. Adição de um Cliente

Para adicionar um  um cliente, faça uma solicitação POST para a seguinte URL:
http://localhost:8080/api/v1/address

envie os dados do Json no Body 
exemplo de json
{
    "cep": "84900000",
    "logradouro": "Rua Paulo Cruz Pimentel",
    "numero": 12,
    "complemento": "Loja",
    "bairro": "Centro",
    "localidade": "Ibaiti",
    "uf": "PR",
    "clientId": 7
}

Oservação:no campo clientId informe o ID do cliente cadastrado no passo anterior

### 4.  Adicionando Endereços
Para adicionar um  um cliente, faça uma solicitação POST para a seguinte URL:
http://localhost:8080/api/v1/clients

envie os dados do Json no Body 
exemplo de json


### 5.  Consulta de um Cliente por Email
Para consultar os  cliente por email, faça uma solicitação GET para a seguinte URL:
http://localhost:8080/api/v1/clients/{email}

Substitua `{email}` pelo e-mail que deseja consultar.


### 4.  Listagem de todos os Clientes
Para consultar todos os  clientes, faça uma solicitação GET para a seguinte URL:
http://localhost:8080/api/v1/clients







