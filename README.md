# 🤖 AI-Powered Helpdesk System

An intelligent Helpdesk Assistant built using **Spring Boot** and **Spring AI** that leverages **Large Language Models (LLMs)** to automate customer support, resolve user queries, and seamlessly interact with backend services through **Function Calling**. The application maintains **persistent, context-aware conversations** while ensuring complete isolation between multiple user sessions.

---

## ✨ Features

- 🤖 AI-powered helpdesk assistant using **Spring AI** and **LLMs**
- 💬 Intelligent natural language query resolution
- 🔧 Function Calling to execute backend operations directly from user prompts
- 🎫 Retrieve ticket status through conversational queries
- 📜 Access previous chat history using conversation IDs
- 🧠 Persistent chat memory for context-aware interactions
- 👥 Independent multi-user conversation management
- ⚡ RESTful APIs built with Spring Boot
- 🔒 Scalable and modular backend architecture

---

## 🏗️ System Architecture

```
                        +----------------------+
                        |    Client / UI       |
                        +----------+-----------+
                                   |
                                   v
                        +----------------------+
                        | Spring Boot REST API |
                        +----------+-----------+
                                   |
                                   v
                        +----------------------+
                        |      Spring AI       |
                        +----------+-----------+
                                   |
                     +-------------+--------------+
                     |                            |
                     v                            v
              Large Language Model        Function Calling
                     |                            |
                     |                    +-------+-------+
                     |                    |               |
                     |                    v               v
                     |             Ticket Service   Chat History Service
                     |                    |
                     +--------------------+
                                   |
                                   v
                              AI Response
```

---

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot 3.x
- Spring AI
- Spring Web
- Maven

### AI & LLM
- OpenAI GPT Models
- Spring AI Chat Client
- Function Calling
- Persistent Chat Memory

### Database
- PostgreSQL / MySQL (Configurable)

### Tools
- IntelliJ IDEA
- Postman
- Git
- Maven

---

## 🚀 Core Functionality

### AI-Powered Query Resolution

Users can interact with the assistant using natural language.

Example:

> **User:** What is the status of ticket 10245?

The assistant understands the request, invokes the appropriate backend function, and returns a conversational response.

---

### Function Calling

Instead of relying solely on LLM-generated responses, the assistant dynamically executes backend services when required.

Supported operations include:

- Get Ticket Status
- Retrieve Chat History
- Fetch Conversation Details
- User Information Lookup
- Easily extensible for additional business services

Example Flow:

```
User
   │
   ▼
"What is my ticket status?"
   │
   ▼
LLM identifies required function
   │
   ▼
getTicketStatus(ticketId)
   │
   ▼
Backend Service
   │
   ▼
LLM generates natural language response
```

---

### Persistent Chat Memory

The application maintains conversation history for every user independently, enabling context-aware responses.

Features include:

- Persistent conversation history
- Independent user sessions
- Context-aware follow-up questions
- No cross-user memory leakage

Example:

**User**

```
What's the status of ticket 1045?
```

**Assistant**

```
Ticket #1045 is currently assigned to the Support Team.
```

Later...

**User**

```
When was it created?
```

The assistant understands that "it" refers to **ticket #1045** without requiring the user to repeat the ticket number.

---

## 📂 Project Structure

```
src
├── controller
├── service
├── config
├── model
├── repository
├── dto
├── memory
├── tools
└── resources
```

---

## ▶️ Getting Started

### Clone the Repository

```bash
git clone https://github.com/<your-username>/ai-powered-helpdesk-system.git
```

### Navigate to the Project

```bash
cd ai-powered-helpdesk-system
```

### Configure API Key

```properties
spring.ai.openai.api-key=YOUR_OPENAI_API_KEY
```

### Run the Application

```bash
mvn spring-boot:run
```

---

## 💡 Future Enhancements

- Retrieval-Augmented Generation (RAG)
- Vector Database Integration
- Knowledge Base Search
- Authentication & Authorization
- AI-based Ticket Classification
- Sentiment Analysis
- Human Agent Escalation
- Dashboard & Analytics
- Multi-model LLM Support

---

## 👨‍💻 Author

**Deepansu Gupta**

Java Backend Developer | Spring Boot | Spring AI | Microservices | Kafka | Docker | Kubernetes | Azure

- GitHub: https://github.com/deejnv007
- LinkedIn: https://www.linkedin.com/in/deepansu-gupta/

---

## ⭐ Highlights

- Built an AI-powered Helpdesk Assistant using **Spring Boot** and **Spring AI**
- Integrated **LLM-based query resolution** to automate first-line customer support
- Implemented **Function Calling** for dynamic backend service invocation
- Engineered **persistent, multi-user chat memory** for context-aware conversations
- Designed a **modular and scalable architecture** for future AI capabilities

---

If you found this project useful, consider giving it a ⭐ on GitHub!
