package com.example.chatme.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.chatme.R;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    EditText suggest;
    Button submit, logout, request;
    FirebaseAuth auth;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        suggest = findViewById(R.id.suggestions);
        submit = findViewById(R.id.submit);
        auth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);
        request = findViewById(R.id.request);
        imageView = findViewById(R.id.back);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String suggestion = suggest.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                String[] to = {"manavverma51@gmail.com"};
                email.putExtra(Intent.EXTRA_EMAIL, to);
                email.putExtra(Intent.EXTRA_SUBJECT, "CHATME SUGGESTIONS");
                email.putExtra(Intent.EXTRA_TEXT, suggestion);

                email.setType("message/rfc822");

                startActivity(email);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                signOutUser();
            }

        });

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                String[] to = {"manavverma51@gmail.com"};
                email.putExtra(Intent.EXTRA_EMAIL, to);
                email.putExtra(Intent.EXTRA_SUBJECT, "Requesting Account Deletion");


                email.setType("message/rfc822");

                startActivity(email);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void signOutUser() {
        Intent intent = new Intent(SettingsActivity.this, Phonenumberactivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}