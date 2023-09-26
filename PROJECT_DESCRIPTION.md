# Desafios do Bootcamp Ada Tech e Cielo

## Desafio 1: Pré-cadastro de clientes

### User Story
Como área de Comercialização da Cielo, desejo manter um pré-cadastro de clientes (prospect) para possibilitar uma futura oferta de produtos e serviços.

### Regras
1. **Informações do cadastro:**
    - **Pessoa Jurídica:**
        - CNPJ: número de 14 dígitos formatado com zeros à esquerda
        - Razão Social: máximo de 50 caracteres
        - MCC: número com no máximo 4 caracteres
        - CPF do contato: número de 11 dígitos formatado com zeros à esquerda
        - Nome do contato: máximo de 50 caracteres
        - Email do contato: Validado via expressão regular
    - **Pessoa Física:**
        - CPF: número de 11 dígitos formatado com zeros à esquerda
        - MCC: número com no máximo 4 caracteres
        - Nome: máximo de 50 caracteres
        - Email: Validado via expressão regular

    _Todas as informações são obrigatórias._

2. **Consistências:**
    a) A operação de cadastrar cliente deverá validar se o cadastro não existe.
    b) A operação de alterar cliente deverá validar se o cadastro já existe.
    c) Ambas as operações de cadastrar ou alterar cliente deverão validar se todos os dados foram informados, se estão consistentes conforme tamanhos, tipos de dados e formatações disponibilizadas na regra "1".
    d) A operação de consultar um cliente deverá validar se o cadastro já existe.

### Desafio
a) Modelar uma API REST com operações que possibilitem a criação, alteração, exclusão e consulta de pré-cadastros de clientes. O entregável deverá ser um documento swagger.
b) Implementar em Java com Spring Boot.
c) Cobertura de 70% de testes unitários.

---

## Desafio 2: Fila de atendimento

### User Story
Como área de Comercialização da Cielo, desejo ter uma fila de atendimento aos prospect, para que cada cliente possa ser analisado de forma sequencial pelos gestores comerciais.

### Regras
1. Toda vez que um novo cadastro ou uma alteração de cadastro for realizada, o cliente deverá entrar na última posição da fila de atendimento.
2. Possibilitar a retirada do cliente na primeira posição da fila de atendimento, apresentando seus dados para o tratamento.
3. Caso não haja nenhum cliente na fila, deverá retornar um status coerente.

### Desafio
a) Incluir na API do desafio "1" uma nova operação que possibilite a retirada do próximo cliente da fila de atendimento.
b) Implementar em Java uma estrutura de dados para uma fila utilizando apenas tipos de dados primitivos (sem usar java.util.*).
c) Implementar as regras na operação da API.
d) Cobertura de 70% de testes unitários.

---

## Desafio 3: Escalabilidade da Fila de Atendimento

### Technical Debt
Durante um teste de carga, identificou-se um problema de escalabilidade na fila de atendimento.

### Desafio
Desenhe e implemente uma nova solução para a fila de atendimento, utilizando a solução de mensageria SQS da AWS.

---

## Desafio 4: Segurança da Informação

### Desafio
a) Identificar um débito técnico de Segurança da Informação.
b) Detalhar o débito técnico, informando a criticidade e possíveis consequências.
c) Planejar as atividades técnicas para o desenvolvimento da solução.
d) Implementar a solução.
