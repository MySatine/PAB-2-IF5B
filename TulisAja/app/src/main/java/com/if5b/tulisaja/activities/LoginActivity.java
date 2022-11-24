package com.if5b.tulisaja.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.if5b.tulisaja.databinding.ActivityLoginBinding;
import com.if5b.tulisaja.models.ValueNoData;
import com.if5b.tulisaja.services.APIService;
import com.if5b.tulisaja.services.Utilities;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etUsername.getText().toString();
                String password = binding.etPassword.getText().toString();

                boolean bolehLogin = true;

                if(TextUtils.isEmpty(username))
                {
                    bolehLogin = false;
                    binding.etUsername.setError("Username tidak boleh kosong!");
                }

                if(TextUtils.isEmpty(username))
                {
                    bolehLogin = false;
                    binding.etPassword.setError("Password tidak boleh kosong!");
                }
                if(bolehLogin)
                {
                    login(username,password);
                }
            }

        });
    }

    private void login(String username, String password) {
        showProgressBar();
        APIService api = Utilities.getRetrofit().create(APIService.class);
        api.login(Utilities.TULIS_AJA_API_KEY, username,password).enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {

            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {

            }
        });

    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }
}