package com.acudemy.apiautomation.response;

import com.acudemy.apiautomation.pojoclasses.BookingDates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Booking {

        private String firstname;
        private String lastname;
        private int totalprice;
        private boolean depositpaid;
        private String additionalneeds;
        private BookingDates bookingdates;

    }

