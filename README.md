# Cadios
CADastro de usuárIOS feito com Jakarta EE

## Melhorias

* Aumentar a cobertura de testes unitários
* Implementar validação dos campos de email, senha e telefone.
* Tornar a adição de números de telefones uma ação dinâmica, sendo possível adicionar uma quantidade qualquer de números.
* Implementar a edição de usuários.
* Implementar a autenticação de usuários.

## Intruções usando Docker

### Requisitos

1. Java 8
2. Maven
3. Docker

### Etapas

1. Gere o .war executando ```mvn clean package```
2. No diretório raiz do projeto, Execute ```docker build --tag=cadios-app .```
3. Execute o conteiner com ```docker run -p 80:8080 -it cadios-app /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0```
4. Acesse a aplicação em ```http://localhost/cadios```


## Intruções usando servidor Wildfly local

### Requisitos

1. Maven
2. Java
3. Wildfly

### Etapas

1. Certifique-se que o servidor wildfly esteja ativo
2. Gere o .war da aplicação executando ```mvn clean package```
3. Faça o deploy: 
    1. Executando ```mvn wildfly:deploy```
    2. OU fazendo o upload do .war através do painel de administração do Wildfly.
4. Acesse a aplicação em ```<url-servidor>/cadios```.

Obs.: Não é necessário nenhuma configuração adicional no servidor Wildfly.