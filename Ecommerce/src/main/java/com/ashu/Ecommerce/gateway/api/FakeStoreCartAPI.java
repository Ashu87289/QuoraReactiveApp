package com.ashu.Ecommerce.gateway.api;

import com.ashu.Ecommerce.dto.CartDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;

@Component
public interface FakeStoreCartAPI {
    @GET("carts")
    Call<List<CartDTO>> getAllCarts();

    @GET("carts/{id}")
    Call<CartDTO> getCartById(@Path("id") int id);
}
