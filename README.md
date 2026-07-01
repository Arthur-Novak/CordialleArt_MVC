# 🌿 Cordialle Art - E-commerce & Painel Administrativo

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

> Sistema web full-stack desenvolvido para a **Cordialle Art**, um ateliê fictício de papelaria artesanal. O projeto evoluiu de uma arquitetura legada baseada em Servlets para o padrão moderno **Spring MVC (Spring Boot)**, garantindo maior segurança, injeção de dependências e facilidade de manutenção.

## 📌 Sumário
- [Funcionalidades](#-funcionalidades)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Como Instalar e Executar](#-como-instalar-e-executar)
- [Acesso Administrativo](#-acesso-administrativo)
- [Dicas de Solução de Problemas](#️-dicas-de-solução-de-problemas)

---

## 🚀 Funcionalidades

### 🛍️ Área Pública (Vitrine)
* **Home & Quem Somos:** Apresentação da marca, conceitos de design autoral e sustentabilidade.
* **Galeria Dinâmica:** Catálogo de produtos consultado em tempo real no banco de dados via `ProdutoService`.
* **Carrinho de Compras:** Interface para simulação de checkout e gestão de itens escolhidos.

### 🔒 Área Administrativa (Dashboard)
* **CRUD de Produtos:** Gestão completa do catálogo (Cadastro, Edição e Exclusão) protegida contra SQL Injection através de `PreparedStatement` e Spring JDBC.
* **Gestão de Usuários:** Controle de administradores do sistema.
* **📊 Relatórios:** Dashboard gerencial com métricas calculadas em tempo real.

---

## 🛠️ Tecnologias Utilizadas

* **Back-end:** Java 17+, Spring Boot, Spring MVC.
* **Front-end:** JSP (Jakarta Server Pages), HTML5, CSS3, Bootstrap 5.
* **Persistência de Dados:** PostgreSQL 12+, JDBC via `DataSource` do Spring.
* **Gerenciamento e Build:** Maven.

---

## 🏃 Como Instalar e Executar

Para rodar o projeto em sua máquina local, siga os passos abaixo:

### 1. Pré-requisitos
Certifique-se de ter as seguintes ferramentas instaladas:
* **JDK 17 ou superior** (Java Development Kit).
* **Apache Maven** (para gestão de dependências).
* **PostgreSQL** (versão 12 ou superior).
* **IDE recomendada:** IntelliJ IDEA, Eclipse ou VS Code.

### 2. Clonando o Projeto
Abra o seu terminal na pasta onde deseja salvar o projeto e execute:

```bash
git clone [https://github.com/Arthur-Novak/CordialleArt_MVC.git](https://github.com/Arthur-Novak/CordialleArt_MVC.git)
cd CordialleArt_MVC
```
## 3. Configurando o Banco de Dados
Crie um banco de dados vazio no seu PostgreSQL com o nome: CordialleArt.

Importe o arquivo de script que está na pasta do projeto:

Localize o arquivo CordialleArtDB.sql dentro de src/main/resources/database/.

Restaure este arquivo no seu PostgreSQL (via pgAdmin ou linha de comando).

## 4. Ajustes de Conexão
Abra o arquivo src/main/resources/application.properties e verifique se as credenciais do banco estão alinhadas com o seu ambiente local:

Properties
spring.datasource.url=jdbc:postgresql://localhost:5432/CordialleArt
spring.datasource.username=postgres
spring.datasource.password=1124

# Configuração do View Resolver para renderização das páginas JSP
spring.mvc.view.prefix=/WEB-INF/pages/
spring.mvc.view.suffix=.jsp
(Altere username e password se as suas credenciais no PostgreSQL forem diferentes).

## 5. Executando a Aplicação
Você pode iniciar o projeto de duas formas:

Via Terminal (Maven):

Bash
mvn clean install
mvn spring-boot:run
Via IDE (IntelliJ):

Aguarde o Maven sincronizar as dependências.

Localize a classe CordialleArtApplication.java no pacote raiz.

Clique com o botão direito e selecione Run 'CordialleArtApplication'.

---
#  🔑 Acesso Administrativo
Após o console indicar que a aplicação iniciou (geralmente na porta 8080), abra o navegador e acesse:
# 👉 http://localhost:8080/home

Para acessar o painel administrativo (Dashboard e CRUDs), utilize as credenciais de teste já cadastradas no banco de dados:

# Email: admin@cordialle.com

---
# Senha: 123456