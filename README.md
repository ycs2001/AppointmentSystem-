# Museum Appointment System

A Java backend for managing museum visits, activity reservations, venues, and
administrator operations. Built with Spring Boot and MyBatis, it exposes HTTP
APIs backed by MySQL.

This repository preserves an older project. The backend source is included, but
the frontend source and database setup scripts are missing. See
[Repository status](#repository-status) before trying to run the full application.

## Features

- Manage museum opening dates, time slots, locations, and visitor capacity.
- Create, search, update, and delete visitor and activity reservations.
- Manage activities, venue information, and venue images.
- Maintain museum information, announcements, and a visitor blacklist.
- Manage administrator accounts and sign in with a server-side session.
- Record selected administrator operations through Spring AOP.

## Technology

| Component | Version / implementation |
| --- | --- |
| Java | Java 8 source and target compatibility |
| Application framework | Spring Boot 2.6.2 |
| Persistence | MyBatis Spring Boot Starter 1.3.1 |
| Database driver | MySQL Connector/J 8.0.11 |
| API documentation | Springfox Swagger 2.9.2 |
| Build | Maven Wrapper 3.6.3 |

## Project layout

Backend paths below are relative to `Server/AppointmentSystem/`.

| Path | Purpose |
| --- | --- |
| `pom.xml` | Maven dependencies and build configuration |
| `src/main/java/com/example/AppointmentSystem/Controller/` | HTTP endpoints |
| `src/main/java/com/example/AppointmentSystem/Service/` | Application services |
| `src/main/java/com/example/AppointmentSystem/Dao/` | MyBatis mapper interfaces |
| `src/main/java/com/example/AppointmentSystem/Entity/` | Data models |
| `src/main/java/com/example/AppointmentSystem/Aop/` | Operation logging |
| `src/main/resources/mapper/` | SQL statements and mapper definitions |
| `src/main/resources/application.yml` | Application and database settings |
| `src/test/` | Original test scaffold |

## Repository status

- **Frontend:** `Client/front` and `Client/front_User` are stored as Git links to
  another commit, not as frontend source files. There is no `.gitmodules` file
  identifying their repositories, so cloning with submodules cannot restore them.
  Frontend installation and launch instructions cannot be provided from this
  checkout.
- **Database:** no schema, migrations, or seed data are included. You need the
  original database export or a compatible schema before using the data APIs.
  Creating an empty database alone is not enough; the SQL mappings are under
  `Server/AppointmentSystem/src/main/resources/mapper/`.
- **Legacy behavior:** endpoint names and many response messages retain their
  original naming and Chinese text. Login uses direct password comparisons, and
  the test directory contains only a scaffold. Authentication, dependency updates,
  and integration testing need further work before production use.

## Run the backend locally

### 1. Prerequisites

- A **JDK 8** installation, with `JAVA_HOME` pointing to the JDK directory.
- MySQL with the original or a compatible schema and any required account data.
- Network access to Maven Central for the wrapper and dependencies on the first
  build. A separate Maven installation is not required.

### 2. Clone the repository

```sh
git clone https://github.com/ycs2001/AppointmentSystem-.git
cd AppointmentSystem-/Server/AppointmentSystem
```

### 3. Configure the database

Restore your schema and data into the local `museumappointmentsystem` database,
or point `DB_URL` at an existing compatible database.

The backend reads these environment variables:

| Variable | Default | Purpose |
| --- | --- | --- |
| `DB_URL` | Local MySQL on port 3306, database `museumappointmentsystem` | Full JDBC connection URL |
| `DB_USERNAME` | `root` | MySQL username |
| `DB_PASSWORD` | Empty | MySQL password |
| `SERVER_PORT` | `8080` | HTTP port |

The default JDBC URL is defined in
[`application.yml`](Server/AppointmentSystem/src/main/resources/application.yml).
It disables TLS for local development and preserves the original GMT+8 timezone.
Set `DB_URL` to your database's full JDBC URL when using a different host, schema,
or TLS configuration.

For macOS or Linux, set the values in the same terminal used to start the server:

```sh
export DB_USERNAME='your_mysql_user'
export DB_PASSWORD='your_mysql_password'
export DB_URL='jdbc:mysql://localhost:3306/museumappointmentsystem?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true'
```

For Windows PowerShell:

```powershell
$env:DB_USERNAME = 'your_mysql_user'
$env:DB_PASSWORD = 'your_mysql_password'
$env:DB_URL = 'jdbc:mysql://localhost:3306/museumappointmentsystem?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true'
```

Replace the example credentials with your local values. Spring Boot does not
automatically load a `.env` file in this project.

### 4. Start the application

From `Server/AppointmentSystem/`:

```sh
./mvnw spring-boot:run
```

On Windows, use `./mvnw.cmd spring-boot:run` instead.

The default API base URL is `http://localhost:8080`. Open
[Swagger UI](http://localhost:8080/swagger-ui.html) to inspect the endpoints, or
fetch the Swagger JSON at `http://localhost:8080/v2/api-docs`.
Some endpoint descriptions remain in Chinese.

### 5. Build a JAR

```sh
./mvnw -DskipTests package
java -jar target/LoginModule-0.0.1-SNAPSHOT.jar
```

Use `./mvnw.cmd` in place of `./mvnw` on Windows. The historical Maven artifact ID
is still `LoginModule`, so the JAR keeps that name. This command skips test
execution; packaging alone does not validate database operations.

## API overview

Paths are case-sensitive and keep the original controller names.

| Base path | Function |
| --- | --- |
| `/user` | Administrator accounts and login |
| `/visit` | Available visit dates, time slots, and capacity |
| `/visitorAppointment` | Visitor reservations |
| `/activity` | Museum activities |
| `/activityAppointment` | Activity reservations |
| `/Venue` | Venue information and image uploads |
| `/MuseumManagement` | Museum information and announcement lists |
| `/BlackList` | Visitor blacklist records |
| `/Message` | Message records |
| `/log` | Administrator operation logs |

After the database is configured, these read-only requests list the first ten
visit configurations and count visitor reservations:

```sh
curl 'http://localhost:8080/visit/queryLimit?currentPage=0&pageSize=10'
curl 'http://localhost:8080/visitorAppointment/getTotalNumber'
```

Despite its name, `currentPage` is passed directly to MySQL as a **row offset**.
For ten results at a time, use `0`, `10`, `20`, and so on.

To sign in with an account already present in your database:

```sh
curl -c /tmp/museum-session.cookies \
  -H 'Content-Type: application/json' \
  -d '{"admin_user_name":"your_admin_name","admin_password":"your_admin_password"}' \
  'http://localhost:8080/user/login'
```

Use `-b /tmp/museum-session.cookies` on subsequent requests that need the session,
including administrator operations with audit logging. Delete the cookie file
when finished. The login response's `token` field is a boolean success flag, not
a bearer token. No default administrator account is supplied by this repository.

Many write endpoints return a JSON object containing `code` and `message`.
The `code` value is an application-level string and may differ from the HTTP
response status. Consult the controller and Swagger definitions for each
endpoint's request body and response format.
