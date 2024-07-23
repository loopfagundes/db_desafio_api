## Desafio Tecnico DBServer - API

### [Via Cep](https://viacep.com.br/)
> *Webservice gratuito de alto desempenho para consulta de Código de Endereçamento Postal (CEP) do Brasil.*
---
#### O projeto é exclusivamente para [DBServer](https://db.tec.br/).

---
:clipboard: Cenarios: Cep Valido e Cep Invalido: `URL: https://viacep.com.br/ws/CEP/json`

:heavy_check_mark: Cenário 1 : Cep Válido

:heavy_check_mark: Cenário 2: Cep Inválido

---

### Ferramentas que foi utilizado?
#### Construido com a estrutura:
:pushpin: [MAVEN](https://maven.apache.org/download.cgi),

:pushpin: [JAVA 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

#### Dependências:
:pushpin: [TestNG](https://mvnrepository.com/artifact/org.testng/testng/7.10.2),

:pushpin: [Rest Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.4.0),

:pushpin: [Allure TestNG](https://mvnrepository.com/artifact/io.qameta.allure/allure-testng/2.27.0),

:pushpin: [Allure Maven](https://mvnrepository.com/artifact/io.qameta.allure/allure-maven/2.12.0),

:pushpin: [Json Schema validator](https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator/5.4.0),

:pushpin: [Java Faker](https://mvnrepository.com/artifact/com.github.javafaker/javafaker/1.0.2)

:pushpin: [Jackson](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations/2.17.2)

:pushpin: [Hamcrest](https://mvnrepository.com/artifact/org.hamcrest/hamcrest/2.2)

---
###  Pré-requisitos:
Antes de começar, é necessária a instalar em sua máquina as seguintes ferramentas:
- [Git bash](https://git-scm.com).

Como instalando Maven no Windows, fazer a seguinte:
- Primeiro tem que baixar o [Maven version](https://maven.apache.org/download.cgi) versão mais recente.
- Seguir o instrução [Maven install](http://charlesmms.azurewebsites.net/2017/09/04/instalando-maven-no-windows-10/#:~:text=Instalando%20o%20Maven,Program%20Files%5CApache%5Cmaven.)

Agora é Allure, como fazer instalar e segue passo a passo baixo:
```bash
- Abrir PowerShell do windows, segue o comando:
	`Set-ExecutionPolicy RemoteSigned -Scope CurrentUser`. 

- Vai aparecer alguns opções sim ou nao: 
        [S] 'SIM de portugues' ou [Y] 'YES de ingles'

- Seguida comando:
	iex (new-object net.webclient).downloadstring('https://get.scoop.sh') 
	e realizado instalação.

- Deve instalar os programas `OPENSSH e GIT`, segue PowerShell, o comando: 
	`scoop install openssh`
	depois comando: `scoop install git` 
	apos de instalado de 'scoop install git'  
	se for aparecer "WARN git (version) is already installed."
	segue o comando: 'scoop update git' para atualizar o `git`.

- E utlimo: 
	`scoop install allure`
	
- Quando após execução do projeto:
	abrir a pasta do projeto e botão direita abrir de "git bash".
	comando: `allure serve allure-results`
```
---
#### Baixando o projeto:

Para baixar o projeto, abrir o comando ou dentro IDE:
```bash
git clone https://github.com/loopfagundes/db_desafio_api.git
```
#### Como executar?
Para executar na sua máquina local, o comando ou através de sua IDE:
```bash
mvn test
```
---
*Funciona na minha máquina* :coffee: 
