package com.opentext.ecommerce.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.ecommerce.delegates.ProductDelegate;
import com.opentext.ecommerce.models.AWSProduct;


@RestController
public class ProductController {
	
	@Autowired
    ProductDelegate productDelegate;
 
    @RequestMapping(value = "/getAWSProductDetails/{category}", method = RequestMethod.GET)
    public String getProducts(@PathVariable String category) {
        System.out.println("Going to call product service to get data!");
        return productDelegate.callProductServiceAndGetData(category);
    }
	
	
	private static Map<String, List<AWSProduct>> productDB = new HashMap<String, List<AWSProduct>>();
	 
    static {
        productDB = new HashMap<String, List<AWSProduct>>();
 
        List<AWSProduct> software = new ArrayList<AWSProduct>();
        AWSProduct product = new AWSProduct(1, "Openshift");
        software.add(product);
        product = new AWSProduct(2, "Mongodb");
        software.add(product);
        productDB.put("Software", software);
 
        List<AWSProduct>  os = new ArrayList<AWSProduct>();
        product = new AWSProduct(12, "Linux");
        os.add(product);
        product = new AWSProduct(14, "Mac");
        os.add(product);
 
        productDB.put("OS", os);
 
    }
 
    @GetMapping(value = "/getAWSProductsByCategory/{category}")
    public List<AWSProduct> getStudents(@PathVariable String category) {
        System.out.println("Getting product details for " + category);
 
        List<AWSProduct> productList = productDB.get(category);
        if (productList == null) {
        	productList = new ArrayList<AWSProduct>();
        	AWSProduct prod = new AWSProduct(0, "N/A");
            productList.add(prod);
        }
        return productList;
    }
}
