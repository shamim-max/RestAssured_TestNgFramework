package com.acudemy.apiautomation.api;

import com.acudemy.apiautomation.constant.ApiPathsEnum;
import com.acudemy.apiautomation.http.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class GetBookingApi extends BaseApi {

    public GetBookingApi(){
        super();
        logAllRequestData(LogDetail.ALL).logAllResponseData(LogDetail.BODY);

    }

    public Response getAllBookingIds(){
        super.setBasePath(ApiPathsEnum.GET_BOOKING_IDS.getApiPath());
        return super.sendRequest(Method.GET);
    }

    public Response getBookingById(int id){
        super.setBasePath(ApiPathsEnum.GET_BOOKING.getApiPath());
        super.setPathParam("bookingId",id);
        return super.sendRequest(Method.GET);
    }


}
