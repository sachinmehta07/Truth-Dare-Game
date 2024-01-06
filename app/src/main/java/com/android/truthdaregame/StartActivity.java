package com.android.truthdaregame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    private Button start, truth, dare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_start);

        start = findViewById(R.id.start);
        truth = findViewById(R.id.truth);
        dare = findViewById(R.id.dare);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        truth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNxt = new Intent(new Intent(StartActivity.this, CategoryActivity.class));
                iNxt.putExtra("isFromTruth", "true");
                startActivity(iNxt);
            }
        });

        dare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNxt = new Intent(new Intent(StartActivity.this, CategoryActivity.class));
                iNxt.putExtra("isFromDare", "true");
                startActivity(iNxt);
            }
        });


    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
