# Pratica Spring Boot + JSF

Sistema de Funcionarios. Utilizo uma API Rest em Java que permite fazer o CRUD de funcionarios utilizando Spring Boot. Com tela para manutenção dos dados feita em Java Server Faces.

## Passo a passo instalação
Como executar essa aplicação Java com Spring Boot, utilizando Java 11, PostgreSQL e JSF:

### Pré-requisitos:

Certifique-se de ter o Java Development Kit (JDK) 11 instalado em seu sistema.

Verifique se o PostgreSQL está instalado e configurado corretamente.

Você precisará de um IDE como o IntelliJ ou Eclipse para importar e executar o projeto.

Certifique-se de ter uma IDE instalada.

### Faça o download do código-fonte desse projeto:

Importe o projeto na sua IDE:

Abra sua IDE e importe o projeto Java como um projeto Maven.

Selecione a pasta raiz do projeto e deixe a IDE resolver as dependências.

### Configure o banco de dados:

Crie um banco de dados no PostgreSQL.

Abra o arquivo de configuração application.properties no projeto e verifique se as configurações do banco de dados estão corretas (URL, nome do banco de dados, nome de usuário e senha).

### Restaure o banco de dados:

(Backup do banco de testes no diretorio *Backup*)

Compile e execute o projeto:

No seu IDE, encontre o arquivo principal PraticaApplication.java e execute-o como um aplicativo Java.

Aguarde até que o servidor embarcado do Spring Boot seja iniciado.


### Acesse a aplicação:

Abra um navegador e acesse http://localhost:8080/Home.xhtml ou http://localhost:8080/Home.com para acessar a página inicial do projeto.

Com essas etapas, você deve conseguir executar a aplicação.

Certifique-se de que todas as configurações estejam corretas e que o banco de dados esteja devidamente restaurado para garantir o funcionamento adequado da aplicação.

## Uso

A aplicação permite aos usuários gerenciar funcionarios:

- Visualizar pessoas cadastradas.
- Salvar novas pessoas.
- Deletar pessoas.
- Visualizar cargos.
- Salvar novos cargos.
- Deletar cargos.

## Tecnologias utilizadas

- Spring Boot
- Java 11
- JSF
- PostgreSQL

## Licença

Este projeto está licenciado sob a licença Apache 2.0. Veja o arquivo LICENSE para mais informações.