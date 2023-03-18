## Animals

Простой проект на java и с базой Postgres

### База данных

Инициализация
````shell
mvn flyway:migrate -Dflyway.user=postgres -Dflyway.password=postgres -Dflyway.url=jdbc:postgresql://localhost:5432/animal
````

