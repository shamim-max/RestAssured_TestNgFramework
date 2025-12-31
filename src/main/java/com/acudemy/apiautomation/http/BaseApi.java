package com.acudemy.apiautomation.http;

import com.acudemy.apiautomation.config.PropertyConfig;
import com.acudemy.apiautomation.config.PropertyUtil;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public abstract class BaseApi {



    private final RequestSpecification requestSpecification;

    public BaseApi(){
        this.requestSpecification=RestAssured.given()
                .baseUri(PropertyUtil.getConfig().baseUri())
                .filter(new AllureRestAssured());
    }

    protected BaseApi setRequestBody(Object body){
        this.requestSpecification.body(body);
        return this;

    }

    protected void setBasePath(String path){
        this.requestSpecification.basePath(path);
    }
    protected void setPathParam(String paramName, Object paramValue){
        this.requestSpecification.pathParam(paramName,paramValue);
    }

    protected void setHeader(String headerName, Object headerValue){
        this.requestSpecification.header(headerName,headerValue);
    }

    protected BaseApi setBasicAuth(String username, String password){
        this.requestSpecification.auth().preemptive().basic(username,password);
        return this;
    }

    protected BaseApi setContentType(ContentType contentType){
        this.requestSpecification.contentType(contentType);
        return this;
    }

    public BaseApi logAllRequestData(LogDetail logDetail){
        this.requestSpecification.filters(new RequestLoggingFilter(logDetail));
        return this;
    }
    public BaseApi logAllResponseData(LogDetail logDetail){
        this.requestSpecification.filters(new ResponseLoggingFilter(logDetail));
        return this;
    }

    public Response sendRequest(Method method) {
       /* return switch (method) {
            case GET -> this.requestSpecification.when().request(Method.GET);
            case POST -> this.requestSpecification.when().request(Method.POST);
            case DELETE -> this.requestSpecification.when().request(Method.DELETE);
            case PUT -> this.requestSpecification.when().request(Method.PUT);
            default -> throw new IllegalArgumentException("Invalid Method Passed");
        };*/

        switch (method) {
            case GET:
                return this.requestSpecification.request(Method.GET);

            case POST:
          return this.requestSpecification.request(Method.POST);

            case DELETE:
                return this.requestSpecification.request(Method.DELETE);

            case PUT:
                return this.requestSpecification.request(Method.PUT);

            default:
                throw new RuntimeException("Invalid Method Passed");

        }
    }

}
