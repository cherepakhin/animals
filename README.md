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
Вспомнить java. Написать сервис:
- maven (+)
- с REST API (+)
- Swagger или OpenApi 
- с подключением БД Postges (+)
- кешем для REST
- Упаковать в Docker
- UUID
- Очереди
- REST клиент для внешнего сервиса
- Даты, Calendar 
- Behave тесты
- Liquibase
- gradle
- Kafka


