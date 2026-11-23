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
- Execução com H2 local ou PostgreSQL via Docker.

## Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 Database
- PostgreSQL
- Docker e Docker Compose
- Maven
- Swagger/OpenAPI

## Como Executar Localmente

```bash
mvn clean package
java -jar target/library-loans-api-0.0.1-SNAPSHOT.jar
```

Swagger:

```text
http://localhost:8080/docs
```

## Como Executar com Docker

```bash
cp .env.example .env
docker compose up --build
```

API:

```text
http://localhost:8080
```

## Perfil PostgreSQL sem Docker

```bash
mvn clean package
java -jar target/library-loans-api-0.0.1-SNAPSHOT.jar --spring.profiles.active=postgres
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
