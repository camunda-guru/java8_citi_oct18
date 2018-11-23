package com.opentext.ecommerce.delegates;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductDelegate {
	@Autowired
    RestTemplate restTemplate;
     
    @HystrixCommand(fallbackMethod = "callProductServiceAndGetData_Fallback")
    public String callProductServiceAndGetData(String category) {
 
        System.out.println("Getting product details for " + category);
 
        String response = restTemplate
                .exchange("http://localhost:9098/getProductsByCategory/{category}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
            }, category).getBody();
 
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return "NORMAL FLOW !!! - Product Name -  " + category + " :::  " +
                    " Product Details " + response + " -  " + new Date();
    }
     
    @SuppressWarnings("unused")
    private String callProductServiceAndGetData_Fallback(String awscategory) {
 
        System.out.println("Student Service is down!!! fallback route enabled...");
 
        return "CIRCUIT BREAKER ENABLED!!! No Response From Product Service at this moment. " +
                    " Service will be back shortly - " + new Date();
    }
 
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
