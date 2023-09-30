
# Desafio da Cielo - Pré-cadastro de Clientes

## Descrição

Este projeto foi criado como parte de um desafio da Cielo. Ele fornece uma API REST para o pré-cadastro de clientes (prospects), permitindo a criação, alteração, exclusão e consulta desses registros.

## Tecnologias Usadas

- Java
- Spring Boot

## User Story

Como área de Comercialização da Cielo, o objetivo é manter um pré-cadastro de clientes para futuras ofertas de produtos e serviços.

## Regras

### Informações do Cadastro

- **Pessoa Jurídica**
    - CNPJ (14 dígitos)
    - Razão Social (max 50 caracteres)
    - MCC (max 4 caracteres)
    - CPF do contato (11 dígitos)
    - Nome do contato (max 50 caracteres)
    - Email do contato (validação por regex)

- **Pessoa Física**
    - CPF (11 dígitos)
    - MCC (max 4 caracteres)
    - Nome (max 50 caracteres)
    - Email (validação por regex)

Ambas as informações de Pessoa Física e Jurídica são definidas na mesma URL. Para definir como Pessoa Jurídica, é obrigatório incluir `companyName` e `companyCnpj`.

### Consistências

- Verifica se o cadastro existe antes de criar ou alterar.
- Todos os campos são obrigatórios e devem ser validados.

## Rotas

O arquivo `Customer.java` define as seguintes rotas:

- `POST /customers`: Cria um novo cliente.
- `PUT /customers/{id}`: Atualiza um cliente existente.
- `DELETE /customers/{id}`: Exclui um cliente.
- `GET /customers/{id}`: Consulta um cliente.

## Documentação API

A documentação da API é fornecida através do Swagger e pode ser acessada na rota `/swagger-ui/`.

## Testes

O projeto visa ter uma cobertura de testes unitários de 70% para a camada de domínio.

## Como Testar

1. Execute o projeto seguindo as instruções na seção 'Execução do Projeto'.
2. Abra o Swagger na URL: `http://localhost:8080/swagger-ui/index.html`.
3. Use as rotas disponíveis para criar, atualizar, excluir e consultar clientes.

## Execução do Projeto

Para executar o projeto, siga os passos abaixo:

1. Clone o repositório.
2. Vá para a pasta do projeto.
3. Execute `mvn spring-boot:run`.

