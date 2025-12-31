package com.acudemy.apiautomation.tests;

import com.acudemy.apiautomation.api.GetBookingApi;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import org.assertj.core.api.Assertions;
import org.awaitility.Awaitility;
import org.awaitility.core.ThrowingRunnable;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class GetBookingApiTests {

    private int bookingId;


    @Parameters("testParam")
    @Test(description = "Get All Bookings")
    public void getAllBookings(@Optional String value){

        System.out.println(value);
        GetBookingApi getBookingApi=new GetBookingApi();
        Response response=getBookingApi.getAllBookingIds()
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        bookingId=JsonPath.read(response.asString(),"$.[0].bookingid");

    }

    @Test
    public void getBookingById(){
        GetBookingApi getBookingApi=new GetBookingApi();
        //Response response = getBookingApi.getBookingById(bookingId);

//        Awaitility.await()
//                          .and().with().alias("My Get Booking Message")
//                          .and().with().timeout(Duration.ofSeconds(5))
//                          .then().untilAsserted((ThrowingRunnable) assertThat(response.statusCode())
//                          .isEqualTo(201));

        Awaitility.await()
                  .and().with().alias("My Get Booking Message")
                  .and().with().timeout(Duration.ofSeconds(5))
                  .then().untilAsserted(()->assertThat(getBookingApi.getBookingById(bookingId)
                                                                    .statusCode())
                          .isEqualTo(200));


//        assertThat(response.statusCode())
//                .as("Status code does not match").isEqualTo(200);


    }

    @Test
    public void getBookingWaitUntil(){
        GetBookingApi getBookingApi=new GetBookingApi();
        //Response response = getBookingApi.getBookingById(bookingId);

//        Awaitility.await()
//                          .and().with().alias("My Get Booking Message")
//                          .and().with().timeout(Duration.ofSeconds(5))
//                          .then().untilAsserted((ThrowingRunnable) assertThat(response.statusCode())
//                          .isEqualTo(201));

        Awaitility.await()
                  .and().with().alias("My Get Booking Message")
                  .and().with().timeout(Duration.ofSeconds(5))
                  .then().until(()->{ getBookingApi.getBookingById(bookingId)
                          .then().statusCode(200);
                      return true;
                  });


//        assertThat(response.statusCode())
//                .as("Status code does not match").isEqualTo(200);


    }
}
