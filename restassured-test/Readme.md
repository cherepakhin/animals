### Behave тестирование

Использован RestAssured [https://github.com/rest-assured/rest-assured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)

Выполнять из папки проекта с тестами Rest Assured

```shell
# Проведение теста
restassured-test$ mvn clean test
# Просмотр отчета в браузере
restassured-test$ ./allure serve target/surefire-reports/
```
