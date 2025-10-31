# 💼 Desafio Backend - PicPay Simplificado

Este documento descreve o desafio técnico proposto pelo **PicPay** para o cargo de **Engenheiro de Software Back-end**.

---

## 🎯 Objetivo

Criar uma **plataforma de pagamentos simplificada** (PicPay Simplificado), onde seja possível **depositar e realizar transferências** de dinheiro entre usuários.

Existem dois tipos de usuários:
- 👤 **Usuário Comum** — pode enviar e receber dinheiro.
- 🏪 **Lojista (Merchant)** — pode **apenas receber** transferências.

---

## 🧾 Regras de Negócio

1. Cada usuário possui:
   - **Nome Completo**
   - **CPF/CNPJ**
   - **E-mail**
   - **Senha**  
   ⚠️ CPF/CNPJ e e-mail devem ser **únicos**.

2. Transferências:
   - Devem ser **validadas pelo saldo disponível**.  
   - **Lojistas não podem enviar dinheiro**.
   - Antes de confirmar a transferência, deve-se consultar o serviço externo de **autorização**:  
     [`https://util.devi.tools/api/v2/authorize`](https://util.devi.tools/api/v2/authorize)
   - Após sucesso, deve-se enviar **notificação externa** (simulada via API):  
     [`https://util.devi.tools/api/v1/notify`](https://util.devi.tools/api/v1/notify)

3. A operação de transferência deve ser **transacional** — ou seja, caso alguma etapa falhe, o saldo deve ser revertido.

---

## 🔁 Exemplo de Endpoint

### `POST /transfer`

**Request Body**
```json
{
  "value": 100.0,
  "payer": 4,
  "payee": 15
}
```

**Possíveis Responses**
- ✅ Sucesso:
  ```json
  { "status": "APPROVED", "message": "Transferência realizada com sucesso" }
  ```
- ❌ Autorização negada:
  ```json
  { "status": "DENIED", "message": "Transação não autorizada" }
  ```
- ⚠️ Falha de notificação:
  ```json
  { "status": "SUCCESS_WITH_WARNING", "message": "Notificação não enviada" }
  ```

---

## 🧰 Tecnologias recomendadas

- Linguagem: Java, NodeJS, .NET, etc.  
- Banco de dados: PostgreSQL, MySQL, MongoDB.  
- Mensageria ou Feign Client para chamadas externas.  
- Docker para ambiente local.  

---

## 📋 Avaliação

Serão avaliados os seguintes pontos:
- Clareza e legibilidade do código.  
- Estrutura do projeto e organização.  
- Tratamento de erros e transações.  
- Uso adequado de testes automatizados.  
- Boas práticas de API REST.  
- Documentação do projeto.

---

## 🏁 Diferenciais

- Uso de Docker.  
- Testes unitários e de integração.  
- Uso de Design Patterns.  
- Aplicação de princípios SOLID.  
- Documentação clara e consistente.  

---

<p align="center">
  <em>“A simplicidade é a sofisticação máxima.” — Leonardo da Vinci</em>
</p>
