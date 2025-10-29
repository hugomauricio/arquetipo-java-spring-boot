package com.microproducer.msa_producer.infrastucture.input.adapter.rest.impl;


import com.microproducer.msa_producer.infrastucture.ouput.adapter.CustomerAccountFeign;
import com.nttdata.services.server.CustomerApi;
import com.nttdata.services.server.models.PostCustomerRetrieveRequest;
import com.nttdata.services.server.models.PostCustomerRetrieveResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class PersonController implements CustomerApi {
    private final CustomerAccountFeign customerAccountFeign;

    public PersonController(CustomerAccountFeign customerAccountFeign) {
        this.customerAccountFeign = customerAccountFeign;
    }

    @Override
    public ResponseEntity<PostCustomerRetrieveResponse> getCustomerRetrieve(String xGuid, PostCustomerRetrieveRequest postCustomerRetrieveRequest) {
        customerAccountFeign.getCustomerAccountRetrieve("1","test");
        return CustomerApi.super.getCustomerRetrieve(xGuid, postCustomerRetrieveRequest);
    }
}
