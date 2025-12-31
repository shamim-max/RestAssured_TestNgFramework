package com.acudemy.apiautomation.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

   int count=0;
   static int maxRetry=3;
    @Override
    public boolean retry(ITestResult iTestResult) {

        if(count<maxRetry){
            count++;
            return true;
        }
        return false;
    }
}
