# Desafio OOP - Pessoa 👤

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Status](https://img.shields.io/badge/status-concluído-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/license-MIT-blue?style=for-the-badge)

Projeto desenvolvido como parte do curso Full Stack Java da [EBAC](https://ebaconline.com.br/), com foco em aplicar os conceitos de **Orientação a Objetos** com Java.

---

## 💡 Objetivo

Modelar um sistema básico que armazena dados de pessoas físicas e jurídicas, praticando:

- ✅ Herança  
- ✅ Encapsulamento  
- ✅ Interfaces  
- ✅ Polimorfismo  

---

## 🧱 Estrutura do Projeto

desafio_oop_pessoa/
├── Main.java
├── model/
│ ├── Pessoa.java
│ ├── PessoaFisica.java
│ └── PessoaJuridica.java
└── interfaces/
└── Identificacao.java

## 🛠️ Funcionalidades

- Cadastro de pessoas físicas e jurídicas
- Armazenamento em uma lista polimórfica
- Impressão de dados via sobrescrita de métodos
- Identificação única via interface comum

---

## 🧪 Tecnologias Utilizadas

- Java 17
- IntelliJ IDEA (ou sua IDE preferida)
- Terminal / Console

---

## 📦 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/CBritoDev/ebac-fullstack-java.git
2 .Navegue até o diretório do projeto:
 
--> cd 10.1-tarefas/back-end/desafio_oop_pessoa

3.Compile e execute o Main.java na sua IDE ou via terminal.

---

## 📚 Conceitos em Prática

- Interface Identificacao
Abstrai o comportamento de obter a identificação (CPF ou CNPJ).

 - Classe Pessoa (superclasse)
Contém atributos comuns entre pessoas físicas e jurídicas.

 - Subclasses PessoaFisica e PessoaJuridica
Herdam de Pessoa e implementam a interface Identificacao.

---

Feito com 💻 por CBritoDev
