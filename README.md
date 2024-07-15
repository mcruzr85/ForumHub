 Fórum Hub API Rest - Programa ONE - Parceria Oracle & Alura
------------------------------------------------------------
Terceiro challenge da formação ONE | Fase 3 - Especialização Back-End.




🎀 Resumo do projeto
------------------------------------------------------------
Projeto em andamento que tem como objetivo proporcionar uma API Rest desenvolvida com o Spring Boot que seria o backend de um fórum de discussão. O projeto gerencia tópicos permitindo a criação, listagem, atualização e exclusão de usuários, cursos e tópicos, seguindo as melhores práticas do modelo REST. Inclui um CRUD completo para tópicos e cursos, paginação, autenticação via JWT e validações de dados.
A persistencia dos dados na API é feita em um banco de dados MySQL por meio de Spring Data JPA.
Os processos de autenticação e autorização para garantir a segurança dos dados foram feitos com o Spring Security usando a libreria auth0 para o processo de geração de tokens com o padrão JWT.

⚜️ Funcionalidades do projeto
------------------------------------------------------------
- Fazer Login:  Permite fazer login na API e mostra o token gerado pelo sistema que é necesario para obter a authorização nas outras requisicões da API (exceto listar topicos). Dica: autenticarse usando o usuario: mcruz@gmail.com  e senha: 123456 pois o projeto está em andamento e a funcionalidade para criar novos usuarios ainda não está implementada.

Tópicos
- Criar um novo tópico: Permite o registro de novos tópicos.
- Listar todos os tópicos: Recupera e exibe todos os tópicos criados com paginação (10 registros por página), ordenados pelo titulo, incluindo informações sobre o autor e o curso. (Não precisa  token)
- Mostrar um tópico específico: Exibe os detalhes de um tópico específico.
- Atualizar um tópico: Permite atualizar as informações de um tópico.
- Eliminar um tópico: Inativa um tópico no banco de dados.

Cursos
- Registrar um novo curso: Permite o registro de novos cursos.
- Listar todos os cursos: Recupera e exibe todos os cursos cadastrados.
- Mostrar um curso específico: Exibe os detalhes de um curso específico.
- Atualizar um curso: Permite atualizar as informações de um curso.
- Eliminar um curso: Inativa um curso no banco de dados.


📌 Tecnologías
---------------------------------------------------------------------------
* Java JDK: versão: 17 em diante -Download the Latest Java LTS Free
* Maven: versão 4 em diante
* Spring Boot: versão 3 em diante - https://start.spring.io/
* MySQL: versão 8 em diante

📌 Ferramentas
---------------------------------------------------------------------------
* SpringBoot Initializr: Gerador de projetos de Spring. Permite selecionar as dependencias desejadas y gera automáticamente o scaffolding do projeto.
* Postman: Cliente de APIs que permite fazer requisições e receber as respostas da aplicação.
* IntelliJ IDEA: IDE recomendado.

📌 Dependências adicionadas com o Spring Initializr:
---------------------------------------------------------------------------
* Lombok
* Spring Web
* Spring Boot DevTools
* Spring Data JPA
* Flyway Migration
* MySQL Driver
* Validation
* Spring Security
* auth0

⚜️ Diagrama Proposto para o Banco de Dados
---------------------------------------------
![diagramabancodados.jpg](src%2Fmain%2Fresources%2Fdiagramabancodados.jpg)

Desenvolvido por
------------------
| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/110754595?v=4" width=115><br> <sub>Meybis Cruz Rodriguez</sub>](https://github.com/mcruzr85) |
| :---: |
<br>