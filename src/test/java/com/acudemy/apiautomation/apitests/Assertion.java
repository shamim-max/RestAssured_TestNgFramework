package com.acudemy.apiautomation.apitests;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Assertion {

    @Test
    public void assertionExample(){
        RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter(LogDetail.ALL);
        ResponseLoggingFilter responseLoggingFilter = new ResponseLoggingFilter(LogDetail.BODY);

        Response response = given().baseUri("https://restful-booker.herokuapp.com")
                          .basePath("/booking/{bookingId}")
                          .pathParam("bookingId", 1)
                          .header("Accept", "application/json")
                          .filters(requestLoggingFilter,responseLoggingFilter)
                          .request(Method.GET)
                          .then().assertThat().statusCode(200)
                          .and().assertThat().body("bookingdates.checkin", (Matchers.equalTo("2017-06-19")))
                          .and().extract().response();

        System.out.println(response.jsonPath().getString("firstname"));

        JsonPath jsonPath=new JsonPath(response.asString());
        System.out.println(jsonPath.getInt("totalprice"));


    }

    @Test
    public void schemaValidationExample(){
        RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter(LogDetail.ALL);
        ResponseLoggingFilter responseLoggingFilter = new ResponseLoggingFilter(LogDetail.BODY);

        Response response = given().baseUri("https://restful-booker.herokuapp.com")
                                   .basePath("/booking/{bookingId}")
                                   .pathParam("bookingId", 1)
                                   .header("Accept", "application/json")
                                   .filters(requestLoggingFilter,responseLoggingFilter)
                                   .request(Method.GET);

        //Schema validation

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir")+"/src/test/resources/schemas/bookingScehma.json")));





    }


}
