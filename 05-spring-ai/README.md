# 💰 Budgeting API com Spring AI

## 🎯 O que o projeto faz
Este projeto é uma API de orçamento financeiro inteligente. Ele processa comandos de voz de usuários (arquivos de áudio), transcreve o conteúdo para texto e utiliza Inteligência Artificial para interpretar a intenção. A IA escolhe a ferramenta apropriada (Tool Calling) para registrar transações financeiras ou consultar o saldo, retornando uma resposta gerada ao usuário.

Tudo isso foi construído respeitando os princípios de **Clean Architecture** e **Domain-Driven Design (DDD)**.

## 🚀 Melhoria Implementada (Evolução)
Para agregar valor real e segurança ao sistema financeiro, implementei uma **Validação de Invariantes na Camada de Domínio**.
* **A Regra:** A classe `Transaction` agora possui uma barreira de segurança em seu construtor que impede a criação de transações com valores zerados ou negativos.
* **O Impacto:** Se a IA interpretar incorretamente um áudio ou receber um comando inválido (ex: *"Gastei menos 50 reais"*), o sistema aborta a operação com uma `IllegalArgumentException`, garantindo a integridade absoluta do banco de dados antes mesmo da persistência.

## 🛠️ Tecnologias Utilizadas
* **Java 25 & Spring Boot 4**
* **Spring AI** (Integração com LLM e Tool Calling)
* **Groq API** (Modelos Llama-3.1 e Whisper-large-v3)
* **MySQL & Spring Data JPA** (Persistência de dados)
* **Docker & Docker Compose** (Infraestrutura)
* **Lombok** (Boilerplate)

## ⚙️ Como Executar e Testar
1. Configure sua chave da API Groq nas variáveis de ambiente: `export GROQ_API_KEY="sua_chave"`.
2. Suba a infraestrutura de banco de dados rodando o projeto (o Spring Boot Docker Compose subirá o MySQL automaticamente).
3. Execute a aplicação e os testes com `./gradlew test`.
4. **Para testar a nova funcionalidade:** Envie um áudio tentando registrar uma transação negativa. O terminal exibirá o bloqueio de segurança implementado no Domínio.

## 📚 O que aprendi
Durante este desafio, consolidei meus conhecimentos em integração de IA com sistemas Java convencionais. Aprendi na prática como utilizar o `ChatClient`, expor regras de negócio via `@Tool` e estruturar uma aplicação para que a Inteligência Artificial sirva à regra de negócio, e não o contrário.

---

## 👤 Autor

Desenvolvido por **Pedro Henrique Santos Ribeiro**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/pedro-henrique-santos-ribeiro/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/PedroHenrique158/)