package com.foodwaste.app;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.foodwaste.app.model.FoodDonation;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReceiverActivity extends AppCompatActivity {

    Button btnFetch;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        btnFetch = findViewById(R.id.btnFetchDonations);
        tvResult = findViewById(R.id.tvDonationResult);

        btnFetch.setOnClickListener(v -> fetchDonations());
    }

    private void fetchDonations() {
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        apiService.getAllDonations().enqueue(new Callback<List<FoodDonation>>() {
            @Override
            public void onResponse(Call<List<FoodDonation>> call, Response<List<FoodDonation>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    StringBuilder builder = new StringBuilder();

                    for (FoodDonation food : response.body()) {
                        builder.append("Donor: ").append(food.getDonorName()).append("\n")
                                .append("Food: ").append(food.getFoodType()).append("\n")
                                .append("Quantity: ").append(food.getQuantity()).append("\n")
                                .append("Location: ").append(food.getLocation()).append("\n")
                                .append("Expiry: ").append(food.getExpiryTime()).append("\n")
                                .append("Status: ").append(food.getStatus()).append("\n\n");
                    }

                    tvResult.setText(builder.toString());
                } else {
                    tvResult.setText("No donations available");
                }
            }

            @Override
            public void onFailure(Call<List<FoodDonation>> call, Throwable t) {
                Toast.makeText(ReceiverActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
