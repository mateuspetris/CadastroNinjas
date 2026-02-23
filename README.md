# 🥷 Sistema de Cadastro de Ninjas

Bem-vindo ao **Sistema de Cadastro de Ninjas**!

Este projeto é uma aplicação desenvolvida com **arquitetura em camadas** utilizando o Spring Boot, com foco em boas práticas de desenvolvimento, organização de código e persistência de dados.

A aplicação permite o cadastro de ninjas e o gerenciamento de suas respectivas missões, utilizando banco de dados em memória e controle de migrações.

---

## 📌 Visão Geral do Projeto

O sistema foi criado para gerenciar **Ninjas** e suas **Missões**.

### 🔥 Regras de Negócio

* Cada **Ninja** pode ser atribuído a **uma única Missão**.
* Uma **Missão** pode ter **vários Ninjas** associados.

### ✅ Funcionalidades

* Cadastro de ninjas com:

    * Nome
    * Idade
    * Email
    * Rank

* Atribuição de uma missão a um ninja

* Gerenciamento de missões

* Consulta de ninjas associados a cada missão

---

## 🛠️ Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias:

* ☕ **Java**
* 🚀 Spring Boot – Criação da aplicação e gerenciamento de dependências
* 🗄️ H2 Database – Banco de dados em memória
* 🔄 Flyway – Controle de migrações do banco
* 📦 Spring Data JPA – Integração com o banco de dados
* 🧩 **JPA (Java Persistence API)** – ORM para mapeamento objeto-relacional
* 🏗️ Apache Maven – Build e gerenciamento de dependências
* 🐳 Docker – Build externo do banco de dados
* 🗃️ **SQL** – Manipulação de dados
* 🌿 Git – Controle de versão
* 🐙 GitHub – Hospedagem do repositório

---

## 🗄️ Design do Banco de Dados

O modelo relacional segue a seguinte estrutura:

### 🥷 Ninja

| Campo     | Tipo      |
| --------- | --------- |
| id        | Long      |
| nome      | String    |
| idade     | Integer   |
| email     | String    |
| rank      | String    |
| missao_id | Long (FK) |

### 🎯 Missão

| Campo     | Tipo   |
| --------- | ------ |
| id        | Long   |
| titulo    | String |
| descricao | String |

### 🔗 Relacionamento

* **1 Missão → N Ninjas**
* **1 Ninja → 1 Missão**

Relacionamento **One-to-Many / Many-to-One**

---

## 🏛️ Arquitetura do Projeto

O projeto segue o padrão de **Arquitetura em Camadas**:

```
controller → service → repository → database
```

* **Controller**: Camada de entrada (REST APIs)
* **Service**: Regras de negócio
* **Repository**: Comunicação com o banco de dados
* **Database**: Persistência de dados

---

## ⚙️ Configuração e Execução

### 📥 1. Clone o repositório

```bash
git clone https://github.com/horaciomuller/CadastroDeNinjas.git
```

### 📂 2. Acesse o diretório

```bash
cd CadastroDeNinjas
```

### 🛠️ 3. Build do projeto

```bash
mvn clean install
```

### ▶️ 4. Execute a aplicação

```bash
mvn spring-boot:run
```

### 🌐 5. Acesse no navegador

```
http://localhost:8080
```

---

## 🧪 Banco H2 (Console)

Caso habilitado, o console do H2 pode ser acessado em:

```
http://localhost:8080/h2-console
```

---

## 📚 Conteúdo Extra

O projeto também conta com **aulas extras aprofundando conceitos de banco de dados**, abordando:

* Modelagem relacional
* Normalização
* Relacionamentos
* Escrita de queries SQL
* Versionamento de banco com Flyway

---

## 🎯 Objetivo do Projeto

Este projeto tem como objetivo:

* Praticar desenvolvimento com Spring Boot
* Aplicar boas práticas de arquitetura
* Trabalhar com versionamento de banco de dados
* Utilizar controle de versão profissional
* Consolidar conceitos de banco de dados

---

## 👨‍💻 Autor

Desenvolvido por **Horácio Muller**

Se este projeto foi útil para você, considere deixar uma ⭐ no repositório!

---

> “Um verdadeiro ninja domina não apenas suas técnicas… mas também seu código.” 🥷
