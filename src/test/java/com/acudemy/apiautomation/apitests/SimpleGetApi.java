package com.acudemy.apiautomation.apitests;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SimpleGetApi {

    @Test
    public void simpleProductList(){

        RequestSpecification requestSpecification= given();

        Header header=new Header("test","value");
        Header header2=new Header("test2","value");
        Headers headers=new Headers(header,header2);

        Response response = requestSpecification.baseUri("https://automationexercise.com")
                                                .basePath("/api/productsList")
                                                .contentType(ContentType.JSON)
                                                .request(Method.GET);

        System.out.println("response = " + response.asString());
    }


    @Test
    public void getApiWithUrlParams(){

        Response response = given().baseUri("https://restful-booker.herokuapp.com")
                                   .basePath("/booking/{bookingId}")
                                   .pathParam("bookingId", 1)
                                   .header("Accept", "application/json")
                                   .request(Method.GET);

        System.out.println("response = " + response.asString());

    }

}
