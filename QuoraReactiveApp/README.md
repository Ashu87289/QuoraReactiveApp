# QuoraReactiveApp

Reactive Quora-style backend built with Spring WebFlux, MongoDB, Kafka, and Elasticsearch. The app currently focuses on question workflows with event-driven view count tracking and search capabilities.

## Tech Stack

- Java 21
- Spring Boot 4
- Spring WebFlux (Reactive)
- Reactive MongoDB
- Apache Kafka
- Elasticsearch
- Gradle
- Lombok

## Current Status

### Implemented

- Question creation
- Get question by ID
- Get all questions
- Delete question
- Text search in title/content (MongoDB regex)
- Tag-based filtering with page/size
- Cursor-based tag feed fetching
- Elasticsearch indexing for newly created questions
- Elasticsearch search endpoint
- Kafka-based view count event publishing and consuming

### In Progress / Scaffolded

- Answer APIs (controller/service placeholders exist)
- Like APIs (interface exists, implementation pending)

## API Endpoints

Base path: `/api/questions`

- `POST /api/questions` : Create a question
- `GET /api/questions/{id}` : Get question by ID (also publishes view event)
- `GET /api/questions` : Get all questions
- `DELETE /api/questions/{id}` : Delete question by ID
- `GET /api/questions/search?query=...&page=0&size=10` : Search by title/content
- `GET /api/questions/tag/{tag}?page=0&size=10` : Get questions by tag (paged)
- `GET /api/questions/fetch/{tag}?cursor=...&size=10` : Cursor-based feed by tag
- `GET /api/questions/elasticSearch?query=...` : Search via Elasticsearch

## Data Stores and Messaging

### MongoDB

Default URI in `application.yml`:

- `mongodb://localhost:27017/quora_db`

### Elasticsearch

Default URI:

- `http://localhost:9200`

### Kafka

- Topic: `view-count-topic`
- Default bootstrap server: `localhost:9092`
- Consumer group: `view-count-consumer`

## Local Run

## 1. Prerequisites

- JDK 21
- MongoDB running locally
- Elasticsearch running on port `9200`
- Kafka running on port `9092`

## 2. Start the app

```bash
./gradlew bootRun
```

On Windows:

```powershell
.\gradlew.bat bootRun
```

## 3. Build

```bash
./gradlew clean build
```

## Project Structure

- `controllers/` : Reactive REST controllers
- `service/` : Business logic
- `repositories/` : Reactive Mongo + Elasticsearch repositories
- `consumer/` and `producers/` : Kafka integration
- `models/` and `dto/` : Domain models and API contracts

## Notes

- This repository currently represents a backend service layer.
- If you plan to add a frontend, this service is ready to be consumed as an API.
- Consider removing either `README.md` or `readme.md` to avoid duplicate readme files on case-insensitive systems.
