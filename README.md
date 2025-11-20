# 🌍 Global Solution 2025 – Plataforma de Upskilling/Reskilling  
**O Futuro do Trabalho • FIAP – Domain Driven Design (Java)**

## 📘 1. Descrição do Projeto

Este projeto implementa uma **API RESTful** em **Java + Spring Boot** para apoiar uma plataforma de **Upskilling e Reskilling**, alinhada às demandas do **Futuro do Trabalho 2030+**.

A solução permite:

- Cadastro e gerenciamento de **Competências do Futuro**  
- Cadastro e gerenciamento de **Trilhas de Aprendizagem**  
- Associação **N:N** entre trilhas e competências  
- Validações robustas  
- Tratamento padronizado de exceções  
- Banco H2 em memória com seeds automáticos  

A plataforma é voltada para apoiar profissionais em transição de carreira, desenvolvimento contínuo e preparação para novas profissões impulsionadas por **IA, automação, dados, colaboração e habilidades humanas**.

---

# 🚀 2. Tecnologias Utilizadas

| Tecnologia | Versão |
|-----------|--------|
| **Java** | 17 |
| **Spring Boot** | 3.3.0 |
| **Maven** | 4+ |
| **H2 Database (in-memory)** | 2.x |
| **Spring Web** | Starter |
| **Spring Data JPA** | Starter |
| **Jakarta Validation** | Starter |

---

# 🧠 3. Conexão com o Tema “O Futuro do Trabalho” + ODS

A API foi projetada visando preparar profissionais para a economia de 2030+, marcada por:

- Automação e IA em crescimento  
- Demandas por novas habilidades digitais  
- Ambientes híbridos/remotos  
- Reskilling acelerado  
- Criatividade, empatia e colaboração  

### 🎯 Conexões explícitas com as ODS:

### **ODS 4 — Educação de Qualidade**  
Plataforma estruturada com trilhas focadas em IA, dados e soft skills essenciais para o profissional do futuro.

### **ODS 8 — Trabalho Decente e Crescimento Econômico**  
Apoia empregabilidade e desenvolvimento profissional por meio de trilhas de qualificação.

### **ODS 9 — Indústria, Inovação e Infraestrutura**  
Promove inovação educacional baseada em tecnologias modernas (IA, APIs, automação).

### **ODS 10 — Redução das Desigualdades**  
Permite que qualquer pessoa acesse trilhas de capacitação e desenvolvimento.

---

# 🏛️ 4. Arquitetura do Projeto

O projeto segue **arquitetura em camadas**, garantindo organização e manutenibilidade:

```
controller/        → Endpoints HTTP
service/           → Regras de negócio
service/impl/      → Implementações de service
repository/        → Interface com o banco (JPA)
model/             → Entidades JPA
dto/               → Dados de entrada e saída
exception/         → Tratamento de erros
enums/             → Constantes e tipos
```

---

# 🗂️ 5. Modelagem das Entidades

### ✔ Competência
- id  
- nome  
- categoria  
- descricao  
- relacionamento N:N com trilha  

### ✔ Trilha
- id  
- nome  
- descricao  
- nivel (INICIANTE, INTERMEDIARIO, AVANCADO)  
- cargaHoraria  
- focoPrincipal  
- competências associadas  

---

# 🗄️ 6. Configuração do Banco de Dados

Banco utilizado: **H2 (in-memory)**

### 🔗 Console do H2:
```
http://localhost:8080/h2-console
```

### Configurações:
```
JDBC URL: jdbc:h2:mem:globalsolutiondb
User: sa
Password:
```

### 📁 Scripts automáticos:

- **schema.sql** → Criação das tabelas  
- **data.sql** → Seeds (competências, trilhas e vínculos)  

A tabela de vínculo `trilha_competencia` usa **ON DELETE CASCADE**.

---

# ▶️ 7. Como Executar o Projeto Localmente

## **Pré-requisitos:**
- JDK 17  
- Maven  
- IDE (Eclipse, IntelliJ, VSCode)

## **Passo 1 — Clonar:**
```bash
git clone https://github.com/SEU-USUARIO/global-solution-2025.git
```

## **Passo 2 — Instalar dependências:**
```bash
mvn clean install
```

## **Passo 3 — Executar:**
```bash
mvn spring-boot:run
```

Ou via IDE:  
Right Click → Run As → Spring Boot App

Aplicação sobe em:
```
http://localhost:8080
```

---

# 🌐 8. Endpoints da API

## 📘 Competências (`/competencias`)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/competencias` | Lista todas |
| GET | `/competencias/{id}` | Busca por ID |
| POST | `/competencias` | Cria nova |
| PUT | `/competencias/{id}` | Atualiza |
| DELETE | `/competencias/{id}` | Remove |

### Exemplo POST:
```json
{
  "nome": "Pensamento Crítico",
  "categoria": "Habilidades Humanas",
  "descricao": "Tomada de decisão baseada em lógica"
}
```

---

## 📗 Trilhas (`/trilhas`)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/trilhas` | Lista todas |
| GET | `/trilhas/{id}` | Busca por ID |
| POST | `/trilhas` | Cria nova |
| PUT | `/trilhas/{id}` | Atualiza |
| DELETE | `/trilhas/{id}` | Remove |

### Exemplo POST:
```json
{
  "nome": "Trilha - IA aplicada a negócios",
  "descricao": "Fundamentos de IA e automação corporativa",
  "nivel": "INTERMEDIARIO",
  "cargaHoraria": 40,
  "focoPrincipal": "Data & IA",
  "competenciasIds": [1, 2]
}
```

---

# ❗ 9. Validações

Implementadas com Jakarta Validation:

- `@NotBlank`  
- `@NotNull`  
- `@Size`  
- `@Min`  

Erros retornam:
```json
{
  "status": 400,
  "erro": "VALIDATION_ERROR",
  "mensagem": "nome: não pode estar em branco"
}
```

---

# ❌ 10. Tratamento Global de Exceções

Suporte para:

- 404 (não encontrado)  
- 400 (validação)  
- 500 (erros inesperados)  
- violação de integridade (corrigida com cascade)  

---

# 🧪 11. Como Testar

### ✔ Basta importar a collection Postman incluída no repositório:
`GlobalSolution-2025.postman_collection.json`

Fluxo recomendado:

1. GET `/competencias`  
2. POST `/competencias`  
3. GET `/trilhas`  
4. POST `/trilhas`  
5. PUT e DELETE para ambos  

