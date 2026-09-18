# Biblio

API de gestion de bibliotheque (Spring Boot + PostgreSQL) : adherents, cartes, livres, auteurs, artistes, CD.

## Membres du groupe

- Diangou CAMARA (diangou.cmr09@gmail.com)
- Laura KOKONYANGE-NKASEI (l.kokonyange@gmail.com)

## Prerequis

- Java 21
- Docker + Docker Compose
- (optionnel, pour lancer sans Docker) PostgreSQL 13+

## Lancer le projet avec Docker (recommande)

Depuis la racine du projet :

```powershell
# 1. Builder le jar
.\mvnw.cmd clean package -DskipTests

# 2. Copier le jar dans le dossier docker (utilise par le Dockerfile)
Copy-Item -Force target\biblio-0.0.1-SNAPSHOT.jar src\main\docker\biblio-0.0.1-SNAPSHOT.jar

# 3. Builder l'image et lancer l'app + la base de donnees
cd src\main\docker
docker compose up -d --build
```

L'API est alors disponible sur `http://localhost:8080`.

> A refaire (rebuild du jar + copie + `docker compose up -d --build`) a chaque fois que le code change : le Dockerfile embarque un jar deja construit, il ne compile pas les sources lui-meme.

Pour arreter :

```powershell
cd src\main\docker
docker compose down
```

## Lancer le projet sans Docker

1. Demarrer une instance PostgreSQL locale avec une base `compose-postgres` (voir `src/main/resources/application.properties` pour les identifiants).
2. Lancer l'application :

```powershell
.\mvnw.cmd spring-boot:run
```

## Documentation de l'API (Swagger)

Une fois l'application lancee :

- Swagger UI : `http://localhost:8080/swagger-ui.html`
- OpenAPI (JSON) : `http://localhost:8080/v3/api-docs`

## Routes principales

| Ressource | Base URL |
|---|---|
| Adherents | `/api/adherent` |
| Livres | `/api/livre` |
| Auteurs | `/api/auteur` |
| Artistes | `/api/artiste` |
| CD | `/api/cd` |

Chaque ressource expose les operations CRUD classiques : `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}`.

## Stack technique

- Java 21 / Spring Boot 4.1.1
- Spring Data JPA + Hibernate
- PostgreSQL
- springdoc-openapi (Swagger)
