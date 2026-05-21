# Library Loans API

API REST para controle de livros, leitores e empréstimos. O projeto foi criado para demonstrar regras de negócio além de CRUD simples.

## Funcionalidades

- Cadastro e listagem de livros.
- Cadastro e listagem de leitores.
- Registro de empréstimos.
- Devolução de livros.
- Bloqueio de empréstimo para livro indisponível.
- Listagem de empréstimos ativos, devolvidos e atrasados.
- Documentação via Swagger UI.

## Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 Database
- PostgreSQL
- Maven
- Swagger/OpenAPI

## Como Executar

```bash
mvn spring-boot:run
```

Swagger:

```text
http://localhost:8080/docs
```

## Perfil PostgreSQL

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=postgres
```

Variáveis:

```text
DB_URL=jdbc:postgresql://localhost:5432/library_loans
DB_USER=postgres
DB_PASSWORD=sua_senha
```

## Endpoints Principais

```http
POST /api/books
GET /api/books
POST /api/readers
GET /api/readers
POST /api/loans
GET /api/loans
GET /api/loans/overdue
PATCH /api/loans/{id}/return
```

## Exemplos

Criar livro:

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884"
}
```

Criar leitor:

```json
{
  "name": "Ana Silva",
  "email": "ana@email.com"
}
```

Registrar empréstimo:

```json
{
  "bookId": 1,
  "readerId": 1,
  "dueDate": "2026-06-10"
}
```
