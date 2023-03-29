### Проведение тестирования RestAssured

Проект состоит из двух частей:
- сам сервис REST [/proj/](proj/)
- проект для Behave тестирования [/restassured-test](restassured-test/) 

Для проведения тестов и получения отчета в формате Allure из каталога проекта(там где файл pom.xml) выполнить   

```shell
restassured-test>mvn clean test
restassured-test>allure serve target/surefire-reports/
```
В браузере откроется страничка с результатами тестов ![результаты](restassured-test/doc/result_test.png "Result tests")