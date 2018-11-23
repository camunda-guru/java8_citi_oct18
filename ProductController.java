package com.citi.banking.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.banking.models.Product;


@RestController
public class ProductController {
	private static Map<String, List<Product>> productDB = new HashMap<String, List<Product>>();
	 
    static {
        productDB = new HashMap<String, List<Product>>();
 
        List<Product> electronics = new ArrayList<Product>();
        Product product = new Product(1, "Mobile");
        electronics.add(product);
        product = new Product(2, "TV");
        electronics.add(product);
        productDB.put("Electronics", electronics);
 
        List<Product>  kitchenware = new ArrayList<Product>();
        product = new Product(12, "Hood");
        kitchenware.add(product);
        product = new Product(12, "Hood");
        kitchenware.add(product);
 
        productDB.put("Kitchenware", kitchenware);
 
    }
 
    @GetMapping(value = "/getProductsByCategory/{category}")
    public List<Product> getStudents(@PathVariable String category) {
        System.out.println("Getting product details for " + category);
 
        List<Product> productList = productDB.get(category);
        if (productList == null) {
        	productList = new ArrayList<Product>();
            Product prod = new Product(0, "N/A");
            productList.add(prod);
        }
        return productList;
    }
}
