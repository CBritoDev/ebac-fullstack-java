# 📂 **Sistema de Cadastro de Clientes**  

<div align="center">  

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk)  
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)  
 

</div>  

## 🚀 **Descrição**  
Sistema de gerenciamento de clientes com:  
✔ Cadastro, consulta, exclusão e edição  
✔ Validação básica de dados  
✔ Persistência em memória (via `Map`)  
✔ Interface simples com `JOptionPane`  

---

## 📦 **Tecnologias**  
| **Tecnologia** | **Uso** |  
|----------------|---------|  
| ☕ **Java 17** | Linguagem principal |  
| 🗃️ **DAO Pattern** | Armazenamento em `HashMap` |  
| 📋 **JOptionPane** | Interface do usuário |  

---

## 🛠️ **Como Executar**  
1. **Pré-requisitos**:  
   - JDK 17+ instalado  
   - IDE (IntelliJ, Eclipse) ou terminal  

2. **Passos**:  
```bash
git clone https://github.com/seu-usuario/sistema-clientes.git
cd sistema-clientes
# Execute App.java na sua IDE
```

---

## 🎯 **Funcionalidades**  
| **Opção** | **Ação** |  
|-----------|----------|  
| 1️⃣ | Cadastrar novo cliente |  
| 2️⃣ | Consultar cliente por CPF |  
| 3️⃣ | Excluir cliente |  
| 4️⃣ | Alterar dados do cliente |  
| 5️⃣ | Sair do sistema |  

---

## 📝 **Estrutura do Projeto**  
```
src/
├── br.com.cbritodev/
│   ├── domain/
│   │   ├── Cliente.java       # Entidade cliente
│   │   └── Endereco.java      # Entidade endereço
│   ├── dao/
│   │   ├── IClienteDAO.java   # Interface DAO
│   │   └── ClienteMapDAO.java # Implementação com Map
│   └── App.java               # Classe principal
```


---

## ✨ **Créditos**  
Desenvolvido por [Carlos Brito](https://github.com/seu-usuario)  

---

<div align="center">  

🔹 **Dúvidas?** Abra uma **issue** no GitHub!  

</div>  
