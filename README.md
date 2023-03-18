## Animals

Простой проект на java и с базой Postgres

### База данных

Инициализация БД

Использован инструмент миграции [https://flywaydb.org](https://flywaydb.org)

Если в application.yaml установлен 
````yaml
flyway:
    enabled: false
````
то для миграции выполнить
````shell
mvn flyway:migrate -Dflyway.user=postgres -Dflyway.password=postgres -Dflyway.url=jdbc:postgresql://localhost:5432/animal
````
И не надо ОТДЕЛЬНО выполнять миграцию (mvn flyway:migrate ...), если 
````yaml
flyway:
    enabled: true
````


