package com.vdfbdp.soapexample.controller;

import com.vdfbdp.soapexample.GetProductRequest;
import com.vdfbdp.soapexample.GetProductResponse;
import com.vdfbdp.soapexample.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PayloadRoot(
        namespace = "http://vdfbdp.com/soap-example", 
        localPart = "getProductRequest"
    )
    @ResponsePayload
    public GetProductResponse getProductRequest(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        response.setProduct(productService.getProducts(request.getName()));

        return response;
    }
}
