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

* Fazendo o download dos 2 artefatos:
    * `git clone https://israeldias@bitbucket.org/israeldias/backendjavaplenoisraelbarreto.git`

* Acessando diretório:
    - `cd backendjavaplenoisraelbarreto`

A partir do diretório informado será possível acessar todo o código-fonte dos 2 artefatos mencionados.



### Swagger

Dentro do projeto da API `desafio-itau` foi criado o documento `swagger.yaml` que contém as informações de todos os principais endpoins da API, permitindo acessar de forma visual todas essas informações


### Postman

Dentro do projeto, há também o arquivo JSON `Mobicare.postman_collection.json` que possui também todas as informações de todos os endpoinst construidos nesta API.


### Endpoints

Para esta API foi construída alguns endpoints que vão permitir obter e cadastrar informações de Colaboradores em determinados Setores de uma empresa.

Para a ilustração dos endpoints a seguir vai ser utilizado o termo <BASE_URL> apenas para designar, de forma genérica, a URL do servidor onde está deployada a API.

* Busca de um colaborador pelo seu ID:
    * `<BASE_URL>/colaborador/buscarColaborador/{idColaborador}`

* Cadastrar um novo colaborador:
    * `<BASE_URL>/colaborador/inserir`

* Remover um colaborador pelo seu ID:
    * `<BASE_URL>/colaborador/remover/{idColaborador}`

* Buscar todos os colaboradores a partir de um ID setor:
    * `<BASE_URL>/setor/listarColaboradoresPorSetorId/{idSetor}`



### Heroku

Foi realizado um deploy desta API no ambiente de cloud do Heroku. O serviço em questão poderá ser acessado a partir da URL: `https://mobicare-colaboradores-api.herokuapp.com`.

Segue um exemplo de chamada a um endpoint para validar se a API está funcionando:  _https://mobicare-colaboradores-api.herokuapp.com/colaborador/buscarColaborador/1_



### Container

Para esta API foi construída um container Docker para que a mesma pudesse ser executada e assim testes pudessem ser realizados.

Para criação do container Docker e a devida execução, os seguintes passos podem ser executados:

- Acesse o diretório do projeto da API mobicare:
    - `cd mobicare`

- Para a criação do image docker:
    - `docker build -t img/mobicare .`

- Dando um start no container:
    - `docker run -p: 8080:8080 img/mobicare`

- Para checar se está funcionando o container:
    - _http://localhost:8080/colaborador/buscarColaborador/1_


### Sistema Web

Para uma simples exibição de forma mais ilustrativa da API, foi construída um pequeno e simples sistema Web desenvolvido em NextJs.

Para a execução desta aplicação Web, os seguintes passos podem ser seguidos:

- Acesse o diretorio do sistema Web:
    - `cd mobicare-web`

- Baixe as dependencias da aplicação:
    - `npm install`

- Rode a aplicação com o seguinte comando:
    - `npm run dev`

- A aplicação poderá ser acessada através da seguinte URL:
    - `http://localhost:3000`



### Autor

* Autor: Israel Dias Barreto
* Email: israeldb27@gmail.com