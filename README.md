# 📚 LiterAlura – Catálogo de Livros com Java e Spring Boot

Projeto desenvolvido como parte do **desafio LiterAlura**, cujo objetivo é praticar o consumo de APIs REST, persistência de dados em banco relacional e uso do Spring Boot com Java.

O sistema funciona via **terminal (console)** e permite buscar livros na API Gutendex, salvar os dados no banco de dados PostgreSQL e realizar diversas consultas.

---

## 🚀 Tecnologias Utilizadas

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL**
* **API Gutendex**
* **Maven**
* **Hibernate**

---

## 🎯 Objetivo do Projeto

Construir um **catálogo de livros**, permitindo:

* Consumo de uma API externa (Gutendex)
* Persistência de dados em banco de dados relacional
* Consultas utilizando JPA e JPQL
* Interação com o usuário via terminal

---

## 🌐 API Utilizada

**Gutendex API**
API gratuita com dados de mais de 70 mil livros do Projeto Gutenberg.

🔗 Endpoint base:

```
https://gutendex.com/books/
```

---

## 🗄️ Estrutura do Banco de Dados

O banco de dados possui duas tabelas principais:

### ✍️ Autor

* id
* nome
* ano_nascimento
* ano_falecimento

### 📘 Livro

* id
* titulo
* idioma
* downloads
* autor_id (chave estrangeira)

📌 Relacionamento:
Um autor pode ter vários livros, e um livro possui apenas um autor.

---

## 🧩 Funcionalidades do Sistema

O sistema apresenta um **menu interativo no terminal** com as seguintes opções:

1. **Buscar livro pelo título**

   * Busca o livro na API Gutendex
   * Salva o autor e o livro no banco de dados

2. **Listar livros registrados**

   * Exibe todos os livros salvos no banco

3. **Listar autores**

   * Mostra todos os autores cadastrados

4. **Listar autores vivos em determinado ano**

   * Consulta autores que estavam vivos em um ano informado

5. **Listar livros por idioma**

   * Filtra livros por idioma (pt, en, es, fr)

6. **Sair do sistema**

---

## ⚙️ Configuração do Projeto

### 🔧 Pré-requisitos

* Java 17 ou superior
* PostgreSQL instalado
* Maven
* IDE (IntelliJ, Eclipse ou VS Code)

---

### 🛠️ Configuração do Banco de Dados

1. Crie o banco no PostgreSQL:

```sql
CREATE DATABASE literalura;
```

2. Configure o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=seuuser
spring.datasource.password=suasenhar

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> ⚠️ Ajuste usuário e senha conforme sua configuração local.

---

## ▶️ Como Executar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/livraria.git
```

2. Acesse a pasta do projeto:

```bash
cd literalura
```

3. Execute a aplicação:

```bash
mvn spring-boot:run
```

4. O menu será exibido no terminal.

---

## 📌 Observações Importantes

* O banco de dados é criado automaticamente pelo JPA
* Autores duplicados devem ser evitados por validação no código
* O projeto não possui interface gráfica, apenas interação via terminal

---

## ⭐ Funcionalidades Extras (Sugestões)

* Ranking dos livros mais baixados
* Estatísticas gerais do catálogo
* Busca de autores pelo nome
* Consultas avançadas com JPQL

---

## 👩‍💻 Autora

Projeto desenvolvido por **Thayza Silva**
Desafio LiterAlura – Java & Spring Boot

---

## 📄 Licença

Este projeto foi desenvolvido apenas para fins educacionais.
