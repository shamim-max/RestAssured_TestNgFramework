package com.acudemy.apiautomation.response;

import com.acudemy.apiautomation.pojoclasses.NewBooking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookingResponse {

    private int bookingid;
    private Booking booking;
}
