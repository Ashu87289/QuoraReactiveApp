package com.ashu.Ecommerce.gateway.api;

import com.ashu.Ecommerce.dto.CartDTO;
import com.ashu.Ecommerce.dto.ProductDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface FakeStoreProductAPI {
    @GET("products/{id}")
    Call<ProductDTO> getFakeProduct(@Path("id") int id) throws IOException;
}
