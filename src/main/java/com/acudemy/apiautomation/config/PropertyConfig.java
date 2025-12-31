package com.acudemy.apiautomation.config;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:config.properties")
public interface PropertyConfig extends Config {
    @Key("baseuri")
    String baseUri();

}
