package com.acudemy.apiautomation.api;

import com.acudemy.apiautomation.constant.ApiPathsEnum;
import com.acudemy.apiautomation.http.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateBookingApi extends BaseApi {

    public CreateBookingApi() {
        super();
        super.logAllResponseData(LogDetail.ALL)
             .logAllRequestData(LogDetail.BODY);
        super.setContentType(ContentType.JSON);
    }

    @Test
    public Response createNewBooking(Object body){
        super.setBasePath(ApiPathsEnum.CREATE_BOOKING.getApiPath());
        super.setRequestBody(body);
        return super.sendRequest(Method.POST);

    }

}
