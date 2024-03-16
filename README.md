# PetCareHub

PetCareHub is a Spring Boot application designed to manage pet care information, focusing on the relationships between pet owners and their pets. It provides a RESTful API to perform CRUD operations on owners and pets.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 11 or newer
- Maven 3.6 or newer
- PostgreSQL installed and running on the default port (5432)

### Installing

1. Clone the repository to your local machine

2. Navigate to the project directory

3. Use Maven to compile and run the project

The application should now be running and accessible at `http://localhost:8080`.

## Using the API

The application provides the following RESTful endpoints:

### Owners

- **List all owners**: `GET /owners`
- **Get an owner by ID**: `GET /owners/{id}`
- **Create a new owner**: `POST /owners`
- **Update an existing owner**: `PUT /owners/{id}`
- **Delete an owner**: `DELETE /owners/{id}`

### Pets

- **List all pets**: `GET /pets`
- **Get a pet by ID**: `GET /pets/{id}`
- **Create a new pet**: `POST /pets`
- **Update an existing pet**: `PUT /pets/{id}`
- **Delete a pet**: `DELETE /pets/{id}`

## Running the Tests

Explain how to run the automated tests for this system (if applicable).

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Maven](https://maven.apache.org/) - Dependency Management
- [PostgreSQL](https://www.postgresql.org/) - The database used

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.