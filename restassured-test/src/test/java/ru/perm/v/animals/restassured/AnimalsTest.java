package ru.perm.v.animals.restassured;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static ru.perm.v.animals.restassured.VARS.HOST;

/**
 * Отчет о тестах в папке ./restassured-test/target/surefire-reports/index.html#
 */
@Epic("REST API Regression Testing using JUnit4")
@Feature("Verify CRUID Operations on Animal")
public class AnimalsTest {

    @Test
    @DisplayName("Animal GET ID Request")
    @Story("Animal GET ID Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the HTTP answer of animal id=1 is status=200")
    public void getId_1andStatusCode200() {
        given().when().get(HOST + "1").then().statusCode(200);
    }

    @Test
    @Story("Animal GET ID=1 Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of animal of id=1")
    public void getId_1() {
        AnimalDto example = new AnimalDto(1L, "Волк");
        AnimalDto receivedDto = given().when().get(HOST + "1").andReturn().as(AnimalDto.class);
        assert example.equals(receivedDto);
    }

    @Test
    @DisplayName("Show failed Animal GET ID Request")
    @Story("Animal GET ID Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Show failed test")
    public void getId_1andStatusCode400() {
        given().when().get(HOST + "1").then().statusCode(400);
    }
}
