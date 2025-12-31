package com.acudemy.apiautomation.apitests;

import com.acudemy.apiautomation.pojoclasses.BookingDates;
import com.acudemy.apiautomation.response.BookingResponse;
import com.acudemy.apiautomation.pojoclasses.NewBooking;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SimplePostApi {

    private final RequestSpecification request = RestAssured.given()
                                                            .filters(new RequestLoggingFilter(LogDetail.ALL), new ResponseLoggingFilter(LogDetail.BODY))
                                                            .baseUri("https://restful-booker.herokuapp.com");

    @Test
    public void createBooking(){

        Map<String,String> bookingDates=new HashMap<>();
        bookingDates.put("checkin","2025-01-01");
        bookingDates.put("checkout","2025-02-01");

        Map<String,Object> newBooking=new HashMap<>();
        newBooking.put("firstname","Jimmy");
        newBooking.put("lastname","Brown");
        newBooking.put("depositpaid",true);
        newBooking.put("totalprice",111);
        newBooking.put("bookingdates",bookingDates);
        newBooking.put("additionalneeds","Breakfast");


        request.contentType(ContentType.JSON)
                .header("Accept","application/json")
                .basePath("/booking")
                .body(newBooking)
                .when()
                .request(Method.POST)
                .then()
                .assertThat()
                .statusCode(200)
                .and().body("booking.firstname", Matchers.equalTo("Jimmy"));

    }

    @Test
    public void createBookinWithPojo(){

       /* BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckin("2025-12-17");
        bookingDates.setCheckout("2025-12-19");

        NewBooking newBooking=new NewBooking();
        newBooking.setBookingdates(bookingDates);
        newBooking.setAdditionalneeds("lunch");
        newBooking.setDepositpaid(true);
        newBooking.setLastname("Ahmed");
        newBooking.setFirstname("Shamim");
        newBooking.setTotalprice(123);*/

        BookingDates bookingDates = BookingDates.builder().setCheckin("2025-12-17").setCheckout("2025-12-19").build();
        NewBooking newBooking = NewBooking.builder().setBookingdates(bookingDates)
                                     .setAdditionalneeds("food")
                                     .setDepositpaid(false)
                                     .setFirstname("elon")
                                     .setLastname("musk")
                                     .setTotalprice(2000)
                                     .build();

        Response response = request.contentType(ContentType.JSON)
                                   .header("Accept", "application/json")
                                   .basePath("/booking")
                                   .body(newBooking)
                                   .when()
                                   .request(Method.POST)
                                   .then()
                                   .assertThat()
                                   .statusCode(200)
                                   .and().body("booking.firstname", Matchers.equalTo("elon"))
                                   .extract().response();

        BookingResponse newBookingDeserializeResponse = response.as(BookingResponse.class);

        System.out.println(newBookingDeserializeResponse.getBooking().getFirstname());

    }
}
