
# Core Cadastro Quarto


Essa API Rest tem como objetivo o cadastro de moradores para quartos 
disponíveis, tem integração com a API ViaCep e API interna de disparo de email <a href= "https://github.com/Stephanie-Ingrid/Email-Service">Email-Service</a>

## Ferramentas necessárias

- Java 17
- Docker
- Lombok
- Maven

### Para rodar o projeto core-cadastro-quarto

<p>Antes de tudo suba o banco, o arquivo na raiz do projeto docker-compose.yaml
com o comando:</p>

    $ docker compose up

<p>Quando a imagem do docker estiver rodando só fazer o build da aplicação que vai rodar corretamente.

Lembrando que para utilizar o serviço de email, você deve rodar a aplicação  <a href= "https://github.com/Stephanie-Ingrid/Email-Service">Email-Service</a>, essa aplicação integra na mesma conexão do banco core-cadastro-quarto. As aplicações devem estar rodando em portas diferentes, nas variáveis de ambientes aplication.properties coloque a config baixo para definir a porta:</p>

     server.port = 8082