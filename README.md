# 🛒 Ecommerce Microservices Platform

A modern, scalable e-commerce backend built with a microservices architecture using Java and Spring Boot. This repository demonstrates distributed system patterns including service discovery, API gateway routing, fault tolerance (circuit breaker), caching, and observability (metrics and centralized logging).

---

## 📌 Plain English: How Does This App Work?

If you are not a developer, think of this platform like a digital shopping mall:

* **Eureka Server (The Information Desk):** When each shop opens, it registers here so other services know where to find it.
* **API Gateway (The Mall Entrance & Security):** All visitor requests enter through here. It directs traffic to the correct shop, blocks unauthorized access, and protects the mall from overcrowding.
* **User Service (Customer Service):** Handles customer profiles, accounts, and details.
* **Product Service (Store Catalog):** Manages the list of items for sale, stock availability, descriptions, and prices.
* **Order Service (Checkout & Billing Counter):** Creates, tracks, and processes purchases.
* **Redis (Fast-Access Memory):** A super-fast notepad storing frequently needed information so services don't have to look it up in the database every time.
* **Prometheus & Grafana (Mall CCTV & Dashboard):** Monitors system health, traffic volume, and performance indicators in real time.
* **Loki (Security Logbook):** Collects log messages and error reports from all services in one place for quick troubleshooting.

---

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/f5a707bb-94a5-4756-a38d-142b929bf299" />


### Module Overview

| Module | Purpose | Key Technologies |
| :--- | :--- | :--- |
| **`gateway`** | Central reverse proxy and API routing entrypoint | Spring Cloud Gateway, Resilience4j, Redis |
| **`EurekaServer`** | Dynamic service registry and discovery | Spring Cloud Netflix Eureka |
| **`User`** | User profile, authentication, and identity data | Spring Boot, REST APIs |
| **`Product`** | Catalog, product listings, and inventory tracking | Spring Boot, Actuator, Prometheus |
| **`Order`** | Order processing, billing, and order history | Spring Boot, Resilience4j, Redis |
| **`prometheus`** | Metrics collection and performance scraping | Prometheus scrapers, Micrometer |
| **`loki`** | Centralized log aggregation and streaming | Grafana Loki |

---

## 🚀 Getting Started

### Prerequisites

* **Java JDK**: Version 17 or higher
* **Apache Maven**: Version 3.8+
* **Docker & Docker Compose**: For running Redis, Prometheus, and Loki
* **Git**

### Installation & Local Setup

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/JontySaha/Ecommerce.git](https://github.com/JontySaha/Ecommerce.git)
   cd Ecommerce

Start supporting infrastructure:

1. Start a local Redis container
docker run -d --name redis-cache -p 6379:6379 redis:alpine

2. Start the microservices (in order):
       Step 1: Service Discovery
   
        cd EurekaServer
        mvn spring-boot:run

     Step 2: Business Microservices
       Open separate terminal windows and run:

         # User Service
        cd User && mvn spring-boot:run
      
        # Product Service
        cd Product && mvn spring-boot:run
      
        # Order Service
        cd Order && mvn spring-boot:run
   
     Step 3: API Gateway

       cd gateway
       mvn spring-boot:run


🛡️ Reliability & Observability Patterns   
    
    Circuit Breaking: Resilience4j safeguards isolate failing services, stopping cascading failures across downstream dependencies.
    
    Distributed Caching: Redis caches high-frequency queries to reduce database strain and deliver sub-millisecond response times.
    
    Metrics Monitoring: System health and request metrics are exported via Spring Boot Actuator and scraped by Prometheus.
    
    Centralized Logging: Microservice log streams are shipped to Loki for consolidated search and correlation.

🗺️ Roadmap & Upcoming Features

    [ ] Event-Driven Architecture (Apache Kafka): Asynchronous messaging for order placement, inventory sync, and email notifications.
    
    [ ] Centralized Security (OAuth 2.0 & OIDC): Token-based authentication using Spring Security and JWT verification at the API Gateway.
    
    [ ] Distributed Tracing: Distributed request tracing using Micrometer Tracing and Grafana Tempo.
    
    [ ] Container Orchestration: Complete Docker Compose deployment file and Kubernetes (K8s) manifests.

🤝 Contributing

    Contributions, issues, and feature requests are welcome! Feel free to check the issues page if you want to contribute.

Fork the Project

    Create your Feature Branch (git checkout -b feature/AmazingFeature)

    Commit your Changes (git commit -m 'Add some AmazingFeature')

    Push to the Branch (git push origin feature/AmazingFeature)

    Open a Pull Request
