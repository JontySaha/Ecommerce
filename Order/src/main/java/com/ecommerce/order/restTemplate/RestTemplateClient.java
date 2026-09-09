package com.ecommerce.order.restTemplate;

import com.ecommerce.order.dto.ProductResponse;
import com.ecommerce.order.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestTemplateClient {
    private final RestTemplate restTemplate;

    private static final String product_url="http://product-service";

    private static final String user_service_url="http://user-service";

    public ProductResponse getProductById(String id){
        try{
            return restTemplate.getForObject(product_url+"/api/products/"+id,ProductResponse.class);
        } catch (HttpClientErrorException e) {
            return null;
        }
    }

    public UserResponse getUserById(String userId){
        try{
            return restTemplate.getForObject(user_service_url+"/api/users/"+userId, UserResponse.class);
        }catch (HttpClientErrorException e){
            return null;
        }
    }
}
