package com.example.kanatbek.demo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void changeActivity(View view) {
        EditText phNumber = findViewById(R.id.phNumber);
            if (phNumber == null || phNumber.length() < 5) {
                Toast.makeText(getApplicationContext(), "Укажите номер телефона", Toast.LENGTH_LONG).show();

            } else {
                Intent i = new Intent(this, BidActivity.class);
                startActivity(i);
            }
        }
}
