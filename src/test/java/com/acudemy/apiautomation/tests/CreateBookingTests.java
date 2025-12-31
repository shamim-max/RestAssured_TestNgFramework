package com.acudemy.apiautomation.tests;

import com.acudemy.apiautomation.api.CreateBookingApi;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateBookingTests {

    @Test
    public void createBooking(){
        CreateBookingApi createBookingApi=new CreateBookingApi();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstname","shamim");
        jsonObject.put("lastname","Messi");
        jsonObject.put("totalprice",123);
        jsonObject.put("depositpaid",true);
        jsonObject.put("additionalneeds","Horlicks");

        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2025-12-25");
        bookingDates.put("checkout","2025-12-26");
        jsonObject.put("bookingdates",bookingDates);



        Response response=createBookingApi.createNewBooking(jsonObject.toString());
        assertThat(response.statusCode())
                .isEqualTo(200);


    }



}
