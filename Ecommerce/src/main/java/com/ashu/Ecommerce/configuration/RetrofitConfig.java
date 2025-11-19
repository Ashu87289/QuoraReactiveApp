package com.ashu.Ecommerce.configuration;

import com.ashu.Ecommerce.gateway.api.FakeStoreCartAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${FAKESTORE_BASE_URL}")
    private String baseUrl;

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCartAPI fakeStoreCartAPI(Retrofit retrofit){
        return retrofit.create(FakeStoreCartAPI.class);
    }
}
