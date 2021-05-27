package com.example.chatme.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chatme.databinding.ActivityPhonenumberactivityBinding;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class Phonenumberactivity extends AppCompatActivity {

    ActivityPhonenumberactivityBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhonenumberactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

       if(auth.getCurrentUser() != null){
            Intent intent = new Intent(Phonenumberactivity.this, MainActivity.class);
            startActivity(intent);
           finish();
       }

        getSupportActionBar().hide();

        binding.phoneBox.requestFocus();

        binding.clickotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Phonenumberactivity.this, OTPActivity.class);
                intent.putExtra("Mobile Number", binding.phoneBox.getText().toString());
                startActivity(intent);
            }
        });
    }
}