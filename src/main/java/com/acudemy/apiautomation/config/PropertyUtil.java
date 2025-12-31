package com.acudemy.apiautomation.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;

public class PropertyUtil {

    public static PropertyConfig getConfig(){

        PropertyConfig propertyConfig = ConfigCache.getOrCreate(PropertyConfig.class);
        return propertyConfig;


    }
}
