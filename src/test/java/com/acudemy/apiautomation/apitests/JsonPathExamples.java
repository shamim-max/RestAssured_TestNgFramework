package com.acudemy.apiautomation.apitests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ResponseBodyData;

public class JsonPathExamples {

    public static void main(String[] args) {

        RestAssured.given()
                                               .baseUri("https://bookcart.azurewebsites.net/api")
                                               .basePath("/book")
                                               .when()
                                               .request(Method.GET)
                .then()
                .log().all();






    }

}
