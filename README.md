# Tourist Management - Spring Boot

A Spring Boot REST API to create, view and update tourist records. The PUT update endpoint validates a custom request token before it accesses or modifies the tourist record.

## Requirements
- Java 17
- Spring Tool Suite (STS) or Eclipse with Spring Tools
- Internet connection on first Maven build (to download dependencies)

## Import into STS
1. Extract `TouristManagement.zip`.
2. Open STS.
3. Select **File > Import > Maven > Existing Maven Projects**.
4. Browse to the extracted `TouristManagement` folder.
5. Select `pom.xml`, then click **Finish**.
6. Wait for Maven dependencies to finish downloading.
7. Right-click the project > **Maven > Update Project** if dependencies show errors.
8. Open `TouristManagementApplication.java`, right-click > **Run As > Spring Boot App**.

The default setup uses an embedded H2 file database. PostgreSQL is not required for the initial Swagger test. H2 data is stored under the project's `data` folder.

## Swagger UI
Open: http://localhost:8080/swagger-ui/index.html

## Test sequence

### 1. Create a tourist
POST `/api/tourists`

```json
{
  "name": "Venkatesh",
  "contactNumber": "9876543210",
  "visitedDestination": "Hyderabad"
}
```

Expected: `201 Created`. Note the returned `id` (usually 1 for a new database).

### 2. Read the tourist
GET `/api/tourists/1`

Expected: `200 OK`.

### 3. Update with a valid token
PUT `/api/tourists/1`

In Swagger, add request header:
`X-REQUEST-TOKEN: HOTEL123`

Request body:
```json
{
  "contactNumber": "9123456780",
  "visitedDestination": "Vijayawada"
}
```

Expected: `200 OK` and the updated record.

### 4. Update with an invalid token
Use the same PUT endpoint and body, but set:
`X-REQUEST-TOKEN: WRONG123`

Expected: `401 Unauthorized`.

### 5. Update without a token
Remove the `X-REQUEST-TOKEN` header and execute.

Expected: `401 Unauthorized`.

### 6. Verify no unauthorized update happened
Call GET `/api/tourists/1`. The record should still contain the values from the last successful update. Invalid and missing tokens do not change the database.

## Optional: use PostgreSQL instead of H2
1. Add the PostgreSQL driver dependency to `pom.xml`:
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```
2. Create a database named `tourist_db`.
3. Edit `application-postgres.properties` and set your PostgreSQL password.
4. Run the app with active profile `postgres` (STS: Run Configurations > Spring Boot > Arguments > VM arguments: `-Dspring.profiles.active=postgres`).

## Important
`HOTEL123` is a demo token for local testing only. Do not use a hard-coded token in production; use a secret manager/environment variable and a proper authentication mechanism.
"# 2400030693-SOAEndSemSkill" 
