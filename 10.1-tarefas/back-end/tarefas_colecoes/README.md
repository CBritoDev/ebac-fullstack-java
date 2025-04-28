# 📚 Gerenciador de Nomes e Gêneros - Atividades de Coleções (Curso Full Stack Java EBAC)

![Java](https://img.shields.io/badge/Java-8%2B-blue.svg) ![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow) ![License](https://img.shields.io/badge/licen%C3%A7a-Nenhuma-red)

---

## 📑 Índice

- [Descrição](#descrição)
- [Atividades](#atividades)
- [Funcionalidades](#funcionalidades)
- [Como Usar](#como-usar)
- [Exemplos](#exemplos)
- [Estrutura do Código](#estrutura-do-código)
- [Tecnologias](#tecnologias)

---

## 📝 Descrição

Este repositório contém duas atividades desenvolvidas como parte do curso de **Full Stack Java** da **EBAC**.  
Ambas as atividades lidam com manipulação de coleções no Java, utilizando classes como `Map`, `List`, e outras estruturas de dados.

---

## 📋 Atividades

1. **Gerenciador de Gêneros**: Sistema que recebe nomes e gêneros, separando-os em dois grupos: **mulheres** e **homens**.
2. **Gerenciador de Nomes**: Sistema que recebe uma lista de nomes, ordena-os alfabeticamente e exibe a lista ordenada.

---

## ⚙️ Funcionalidades

- Separar nomes por gênero (Masculino/Feminino).
- Ordenar lista de nomes em ordem alfabética.
- Entrada de dados via terminal.

---

## 🚀 Como Usar

### 📌 Pré-requisitos

- **Java 8+** instalado na sua máquina.

### 🖥️ Rodando o Projeto

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Navegue até o diretório do projeto
cd seu-repositorio

# Compile e execute os arquivos Java
javac GerenciadorGenero.java
javac GerenciadorDeNomes.java
java GerenciadorGenero
java GerenciadorDeNomes
```

---

## 📈 Exemplos

### 👩‍🦰👨‍🦰 Gerenciador de Gêneros

**Entrada:**

```
Ana - Feminino, Carlos - Masculino, Beatriz - Feminino, João - Masculino
```

**Saída:**

```
Grupo de mulheres:
Ana
Beatriz

Grupo de homens:
Carlos
João
```

---

### 📑 Gerenciador de Nomes

**Entrada:**

```
João, Maria, Ana, Pedro, Beatriz
```

**Saída:**

```
Ana
Beatriz
João
Maria
Pedro
```

---

## 🧩 Estrutura do Código

### 📂 Gerenciador de Gêneros

- **`separarNomes(String entrada)`**:  
  Separa a entrada em nomes e gêneros.

- **`separaGenero(String[] pessoas)`**:  
  Agrupa nomes em dois grupos usando `Map<String, List<String>>`.

---

### 📂 Gerenciador de Nomes

- **`separaNomes(String entrada)`**:  
  Divide os nomes a partir da vírgula.

- **Ordenação com `Arrays.sort`**:  
  Ordena alfabeticamente a lista de nomes.

---

## 💻 Tecnologias

- Java 8+
- Collections API (`List`, `Map`, `ArrayList`, `HashMap`, `Arrays`)
- `Scanner` para entrada de dados pelo usuário

---

## 😄 Autor

Feito com dedicação para prática de manipulação de coleções no Java!

---
