# Aushop-saas
Plataforma que conecta tutores de pets com parceiros (pet shops, clínicas, adestradores, lojas de ração)

# 🐾 SaaS Pets – Gestão de Planos e Marketplace para Pets

> Plataforma SaaS que conecta tutores de pets a parceiros (pet shops, clínicas, adestradores e lojas de ração), permitindo a contratação de **planos de assinatura** ou **serviços avulsos**, com gestão completa de benefícios e pagamentos.

---

## 📖 Visão Geral

O **SaaS Pets** é uma aplicação **Java Spring Boot (Monólito Modular)** que centraliza o gerenciamento de usuários, pets, planos, pagamentos e notificações.  
O projeto foi desenhado para evoluir futuramente para **microserviços independentes**, mantendo modularidade desde o início.

---

## 🧱 Arquitetura

**Tipo:** Monólito modular  
**Padrão:** Camadas (Controller → Service → Repository → Domain)  
**Tecnologias principais:**

| Categoria | Tecnologia |
|------------|-------------|
| Backend | Java 17 + Spring Boot 3 |
| Banco de Dados | MySQL 8 |
| ORM | Spring Data JPA / Hibernate |
| Segurança | Spring Security + JWT *(em breve)* |
| Logs e Utils | LogUtil / CorrelationIdUtil / MascaramentoUtil |
| Build & CI | Maven + GitHub Actions *(em breve)* |
| Mensageria | RabbitMQ *(planejado)* |
| Deploy | Docker / Docker Compose *(local)* |

---

## 🧩 Estrutura de Pastas

```bash
src/main/java/com/saaspet/
├── config/            # Configurações globais (CORS, Security, WebConfig)
├── core/              # Classes utilitárias, exceções e logs
│   ├── exception/
│   └── util/
├── usuario/           # Módulo de usuários (Tutor, Parceiro, Admin)
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── dto/
│   └── model/
├── pet/               # Módulo de pets e seus relacionamentos
├── plano/             # Módulo de planos, benefícios e assinaturas
├── pagamento/         # Módulo de transações e assinaturas recorrentes
└── notificacao/       # Módulo de envio de e-mails e lembretes
