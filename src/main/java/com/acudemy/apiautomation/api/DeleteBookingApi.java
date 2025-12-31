package com.acudemy.apiautomation.api;

import com.acudemy.apiautomation.constant.ApiPathsEnum;
import com.acudemy.apiautomation.http.BaseApi;
import com.jayway.jsonpath.JsonPath;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONObject;

public class DeleteBookingApi extends BaseApi {

    public DeleteBookingApi() {
        super();
        super.logAllResponseData(LogDetail.ALL)
                .logAllRequestData(LogDetail.ALL);
        super.setContentType(ContentType.JSON);
    }



    public Response deleteBooking(int id){
        String token=createToken();
        super.setBasePath(ApiPathsEnum.DELETE_BOOKING.getApiPath());
        super.setPathParam("bookingId",id);
        super.setHeader("cookie","token="+token);
        return super.sendRequest(Method.DELETE);


    }

    private String createToken(){
        super.setBasePath("/auth ");

        JSONObject body=new JSONObject();
        body.put("username","admin");
        body.put("password","password123");
        super.setRequestBody(body.toString());
        Response response=super.sendRequest(Method.POST);

        return JsonPath.read(response.asString(),"$.token");


    }
}
