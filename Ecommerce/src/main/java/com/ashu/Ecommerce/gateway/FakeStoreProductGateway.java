package com.ashu.Ecommerce.gateway;

import com.ashu.Ecommerce.dto.ProductDTO;
import com.ashu.Ecommerce.gateway.api.FakeStoreProductAPI;
import lombok.AllArgsConstructor;
import retrofit2.Response;

@AllArgsConstructor
public class FakeStoreProductGateway implements IProductGateway{

    private final FakeStoreProductAPI fakeStoreProductAPI;

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        Response<ProductDTO> response = this.fakeStoreProductAPI.getFakeProduct(Math.toIntExact(id)).execute();
        if(response == null){
            throw new RuntimeException("Response is blank of product for this ID");
        }
        return response.body();
    }
}
