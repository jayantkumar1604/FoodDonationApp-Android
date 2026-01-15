package com.foodwaste.app;

import com.foodwaste.app.model.FoodDonation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("api/food/donate")
    Call<FoodDonation> donateFood(@Body FoodDonation foodDonation);

    @GET("api/food/list")
    Call<List<FoodDonation>> getAllDonations();

}
