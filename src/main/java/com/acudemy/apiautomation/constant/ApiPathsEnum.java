package com.acudemy.apiautomation.constant;

import lombok.Getter;


public enum ApiPathsEnum {

    GET_BOOKING("/booking/{bookingId}"),

    GET_BOOKING_IDS("/booking"),

    CREATE_BOOKING("/booking"),

    DELETE_BOOKING("/booking/{bookingId}"),

    UPDATE_BOOKING("/booking/{bookingId}");

    private String apiPath;

    ApiPathsEnum(String path){
        this.apiPath=path;
    }

    public String getApiPath(){
        return apiPath;
    }
}
