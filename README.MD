# Interface Swing - CRUD de Usuários

Este é um projeto simples em Java que implementa um CRUD (Create, Read, Update, Delete) de usuários com interface gráfica utilizando **Swing**. O sistema permite cadastrar, exibir, atualizar e deletar usuários armazenados em um banco de dados MySQL.

## Funcionalidades

- **Cadastrar Usuário**: Insere nome e e-mail no banco de dados.
- **Exibir Usuário por ID**: Busca os dados de um usuário informando o ID.
- **Atualizar Usuário**: Atualiza nome e e-mail de um usuário pelo ID.
- **Deletar Usuário**: Exclui o usuário do banco informando seu ID.
- **Visualizar Todos os Usuários**: Exibe todos os usuários cadastrados em uma tabela `JTable`.

## Tecnologias Utilizadas

- **Java**
- **Swing (GUI)**
- **MySQL**
- **JDBC (Java Database Connectivity)**

## 🗂️ Estrutura do Projeto


```bash
br.com.cadastro
├── dao        # Classe CadastroDAO com métodos do CRUD
├── model      # Classe Cadastro (modelo com id, nome e email)
└── view       # Classe Interface com os componentes gráficos (Swing)

````

## Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/c0mcod/interface_Swing.git

2. Importe o projeto em uma IDE Java como Eclipse ou VS Code com suporte a Maven ou biblioteca JDBC configurada.
3. Configure o acesso ao banco de dados MySQL na classe `CadastroDAO.java`.
4. Execute a classe `Interface.java`.

> **⚠️ Atenção:** Crie o banco de dados e a tabela `usuarios` com os campos `id`, `nome`, e `email`. Exemplo:

```sql
CREATE TABLE usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  email VARCHAR(100)
);
```

## Capturas de Tela

*Adicione imagens da interface aqui futuramente para demonstrar o funcionamento.*

## Autor

Desenvolvido por [@c0mcod](https://github.com/c0mcod) — estudante de Análise e Desenvolvimento de Sistemas.

---


