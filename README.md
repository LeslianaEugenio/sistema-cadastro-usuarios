Projeto em Spring Boot criado para treinar a construção de uma API REST com autenticação baseada em JWT.

Tecnologias Utilizadas:

Java 17+

Spring Boot

Spring Security

JWT (JSON Web Token)

Maven

H2 Database (ou substituível por outro banco)

Funcionalidades Implementadas:

Cadastro de Usuário

Login com geração de Token JWT

Listagem de Usuários (rota protegida com token)


 Autenticação:

O login gera um token JWT.

Para acessar as rotas protegidas, o token deve ser enviado no header da requisição.

Exemplo de header:
Key: Acessoautorizado

Value: Bearer {seu_token_aqui}


 Como Executar

Clone o repositório

git clone https://github.com/teu-usuario/teu-repo.git


Abra no IntelliJ ou Eclipse.

Execute a aplicação com Spring Boot (mvn spring-boot:run ou direto pela IDE).

Acesse em:

http://localhost:8080

📖 Exemplos de Endpoints
🔹 Cadastro de Usuário

POST [/usuarios/cadastrar](http://localhost:8080/usuarios)
Body (JSON):

{
  "nome": "Maria",
  "email": "maria@email.com",
  "senha": "123456"
}

🔹 Login

POST [/auth/login](http://localhost:8080/geral/login)
Body (JSON):

{
  "email": "maria@email.com",
  "senha": "123456"
}


Resposta:

{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}

🔹 Listagem de Usuários (Protegido)

GET /[usuarios](http://localhost:8080/usuarios)
Headers:

Authorization: Bearer {token}
Acessoautorizado: true
