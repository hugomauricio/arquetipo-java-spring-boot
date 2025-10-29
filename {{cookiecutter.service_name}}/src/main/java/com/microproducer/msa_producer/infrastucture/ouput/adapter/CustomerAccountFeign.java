package com.microproducer.msa_producer.infrastucture.ouput.adapter;

import com.nttdata.services.rest.client.CustomerAccountApi;
import com.nttdata.services.rest.client.models.Account;
import com.nttdata.services.rest.client.models.PostAccountRetrieveResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import java.util.List;

@FeignClient(
        name = "customerAccountClient",
        url = "${clients.customerAccount.url}"
)
public interface CustomerAccountFeign extends CustomerAccountApi {
    @Override
    default PostAccountRetrieveResponse getCustomerAccountRetrieve(String idCustomer, String xGuid) {
        PostAccountRetrieveResponse postAccountRetrieveResponse=new PostAccountRetrieveResponse();
        Account account=new Account();
        account.setTypeAccount("AHORROS");
        account.setAmount(200);
        account.setNumber("100");
        postAccountRetrieveResponse.setAccounts(List.of(account));
        return postAccountRetrieveResponse;
    }
}
