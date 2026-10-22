package com.ecommerce.gateway;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FallBackController {

    @GetMapping("/fallback/products")
    public ResponseEntity<String> productsFallback(){
        return ResponseEntity.status(HttpStatus.SC_SERVICE_UNAVAILABLE)
                .body("Product Service is unavailable");
    }
}
