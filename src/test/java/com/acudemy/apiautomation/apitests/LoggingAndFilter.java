package com.acudemy.apiautomation.apitests;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class LoggingAndFilter {
    @Test
    public void simpleProductList() {

        RequestSpecification requestSpecification = given();

        Header header = new Header("test", "value");
        Header header2 = new Header("test2", "value");
        Headers headers = new Headers(header, header2);

        RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter(LogDetail.ALL);
        ResponseLoggingFilter responseLoggingFilter = new ResponseLoggingFilter(LogDetail.BODY);


        Response response = requestSpecification.baseUri("https://automationexercise.com")
                                                .basePath("/api/productsList")
                                                .contentType(ContentType.JSON)
                                                .filters(List.of(requestLoggingFilter, responseLoggingFilter))
                                                .request(Method.GET);

        System.out.println("response = " + response.asString());
    }
}
