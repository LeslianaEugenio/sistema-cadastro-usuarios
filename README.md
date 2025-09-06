Sobre
Esse projeto é meu treino de back-end com Spring Boot.  
Ele faz cadastro, login com JWT e listagem de usuários protegida.  

Banco usado: H2 (temporário, em memória).  
O código é simples, com variáveis curtas e comentários “à mão”.

---

 Endpoints:

- POST /users → cadastrar usuário  
- POST /auth/login → login, retorna token  
- GET /users → lista todos usuários (precisa do token no header)

 Uso:

1. Rodar aplicação no IntelliJ ou VS Code  
2. Testar endpoints com Postman/Insomnia  
3. Sempre cadastrar antes de logar  


 Observações:

- Senhas em texto plano só pra treino  
- Token expira em 1 hora  
- Código simples 
- Banco H2 reinicia a cada start da aplicação
Os testes unitários estavam previstos, mas tive alguns problemas de configuração no ambiente (JUnit/Spring Test).
Como o foco principal do projeto era a API em si, deixei registrado aqui que a aplicação funciona normalmente
com cadastro, login com JWT e listagem de usuários.
