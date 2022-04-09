# ITAU - DESAFIO TESTE API #


Este documento tem como objetivo exibir as informações da API de teste construída para o desafio proposto pelo Itaú para a vaga de Backend Java.

### Descrição do Projeto ###

O projeto trata-se de uma API Rest que possui o objetivo de validar um password, devendo obedecer algumas regras específicas, tais como:
* Nove ou mais caracteres.
* Ao menos 1 dígito.
* Ao menos 1 letra minúscula.
* Ao menos 1 letra maiúscula.
* Ao menos 1 caractere especial. 
  * Considere como especial os seguintes caracteres: !@#$%^&*()-+
* Não possuir caracteres repetidos dentro do conjunto

E esta API deverá emitir apenas uma resposta booleana 'true' ou 'false' considerando respectivamente se o password informado é válido ou não. 

### Glossário

* Artefatos Repositório
* Tecnologias
* Iniciando ...
* Endpoints
* Swagger
* Postman
* Heroku
* Container
* Autor

### Artefatos Repositorio

* desafio-itau (artefato da API)

### Tecnologias

* Spring Boot 2.6.6
* Java 11
* JUnit


### Iniciando ...

* Fazendo o download do artefato:
    * `git clone https://github.com/israelprojeto27/desafio-itau`

* Acessando diretório:
    - `cd desafio-itau`

A partir do diretório informado será possível acessar todo o código-fonte do referido artefato.


### Swagger

Dentro do projeto da API `desafio-itau` é possível acessar o documento Swagger da aplicação que contém as informações do endpoint implementado para esta API.

Este documento poderá ser acessado através de qualquer browser através da seguinte URL:
  * http://localhost:8080/swagger-ui/index.html


### Postman

Dentro do projeto, há também o arquivo JSON `DesafioItau.postman_collection.json` que possui também todas as informações de todos os endpoinst construidos nesta API.


### Endpoints

Para esta API foi construída apenas um endpoint que será responsável para referida validação sobre o password informado,

Para a ilustração dos endpoints a seguir vai ser utilizado o termo <BASE_URL> apenas para designar, de forma genérica, a URL do servidor onde está deployada a API.

* Enviar um input de password para validação:
    * `<BASE_URL>/password/validate`
      * Vale ressaltar que para o funcionamento deste endpoint é necessário um Body na requisição no formato JSON.
      * Exemplo do body:
        * _{"input": "Aabv#12P3Oa"}_


### Heroku

Foi realizado um deploy desta API no ambiente de cloud do Heroku. O serviço em questão poderá ser acessado a partir da URL: `https://desafio-itau-api.herokuapp.com`.

Segue um exemplo de chamada a um endpoint para validar se a API está funcionando:  _https://desafio-itau-api.herokuapp.com/password/validate_


### Container

Para esta API foi construída um container Docker para que a mesma pudesse ser executada e assim testes pudessem ser realizados.

Para criação do container Docker e a devida execução, os seguintes passos podem ser executados:

- Acesse o diretório do projeto da API Desafio Itaú:
    - `cd desafio-itau`

- Para a criação do image docker:
    - `docker build -t img/desafio-itau .`

- Dando um start no container:
    - `docker run -p 8080:8080 img/desafio-itau`

- Para checar se está funcionando o container:
    - http://localhost:8080/password/validate





### Autor

* Autor: Israel Dias Barreto
* Email: israeldb27@gmail.com