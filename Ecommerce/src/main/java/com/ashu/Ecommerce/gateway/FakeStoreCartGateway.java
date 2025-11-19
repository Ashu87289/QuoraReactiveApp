package com.ashu.Ecommerce.gateway;

import com.ashu.Ecommerce.dto.CartDTO;
import com.ashu.Ecommerce.gateway.api.FakeStoreCartAPI;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class FakeStoreCartGateway implements ICartGateway{

    private  final FakeStoreCartAPI fakeStoreCartAPI;

    public FakeStoreCartGateway(FakeStoreCartAPI fakeStoreCartAPI) {
        this.fakeStoreCartAPI = fakeStoreCartAPI;
    }

    @Override
    public List<CartDTO> getAllCarts() throws IOException {
        //1. Make an HTTP request to the FakeStore API to fetch all Catgeories.
        Response<List<CartDTO>> response = this.fakeStoreCartAPI.getAllCarts().execute();

        //2. Check if the response is null and throw an IOException if it is
        if(!response.isSuccessful()){
            throw  new RuntimeException("Failed to fetch carts: " + response.code());
        }

        return response.body();
        //return response.body();
    }

    @Override
    public CartDTO getCartById(int id) throws IOException {
        Response<CartDTO> resp = this.fakeStoreCartAPI.getCartById(id).execute();
        if(!resp.isSuccessful()){
            throw  new RuntimeException("No Data exist for this Id" + resp.code());
        }
        return resp.body();
    }
}
