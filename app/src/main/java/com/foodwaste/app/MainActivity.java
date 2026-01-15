package com.foodwaste.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.foodwaste.app.model.FoodDonation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText etDonor, etFood, etQty, etLocation, etExpiry;
    Button btnDonate, btnReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDonor = findViewById(R.id.etDonorName);
        etFood = findViewById(R.id.etFoodType);
        etQty = findViewById(R.id.etQuantity);
        etLocation = findViewById(R.id.etLocation);
        etExpiry = findViewById(R.id.etExpiry);
        btnDonate = findViewById(R.id.btnDonate);
        btnReceiver = findViewById(R.id.btnReceiver);

        // Donor submits food
        btnDonate.setOnClickListener(v -> {

            FoodDonation food = new FoodDonation(
                    etDonor.getText().toString(),
                    etFood.getText().toString(),
                    Integer.parseInt(etQty.getText().toString()),
                    etLocation.getText().toString(),
                    etExpiry.getText().toString()
            );

            ApiService apiService =
                    RetrofitClient.getClient().create(ApiService.class);

            apiService.donateFood(food).enqueue(new Callback<FoodDonation>() {
                @Override
                public void onResponse(Call<FoodDonation> call,
                                       Response<FoodDonation> response) {
                    Toast.makeText(MainActivity.this,
                            "Donation Successful",
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<FoodDonation> call, Throwable t) {
                    Toast.makeText(MainActivity.this,
                            "Failed: " + t.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            });
        });

        // Navigate to Receiver / NGO page
        btnReceiver.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ReceiverActivity.class));
        });
    }
}
