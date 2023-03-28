package ru.perm.v.animals.restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AnimalsTest {

    @Test
    public void getId_1() {
        given().when().get("http://127.0.0.1:8780/api/animal/1").then().log().all();
    }

}
