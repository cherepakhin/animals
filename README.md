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

### Работа с psql 

Из linux! Выполнять из консоли компа с postgres
````shell
sudo -u postgres psql
psql>\c animal
animal>\dt
                 List of relations
 Schema |         Name          | Type  |  Owner   
--------+-----------------------+-------+----------
 public | animal                | table | postgres
 public | country               | table | postgres
 public | flyway_schema_history | table | postgres
 public | statistic             | table | postgres
(4 rows)
````

С удаленного компьютера
````shell
psql -U postgres -p 5432 -h 192.168.1.20
# Подключение к базе animal
psql>\c animal
// Список таблиц
animal>\dt
                 List of relations
 Schema |         Name          | Type  |  Owner   
--------+-----------------------+-------+----------
....
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
- Behave тесты (jbehave, RestAssured)
- Flyway (+)
- gradle
- Kafka


