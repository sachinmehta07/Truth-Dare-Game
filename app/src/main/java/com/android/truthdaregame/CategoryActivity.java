package com.android.truthdaregame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        findViewById(R.id.cardFunny).setOnClickListener(this);
        findViewById(R.id.cardEmbarrassing).setOnClickListener(this);
        findViewById(R.id.cardChallenging).setOnClickListener(this);
        findViewById(R.id.cardRandom).setOnClickListener(this);
        TextView pageTitle = findViewById(R.id.pageTitle);

        if (getIntent().hasExtra("isFromTruth")) {
            pageTitle.setText(R.string.select_truth);
        } else if (getIntent().hasExtra("isFromDare")) {
            pageTitle.setText(R.string.select_dare);
        }

        findViewById(R.id.ivBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View v) {
        String selectedCategory = "";
        int viewId = v.getId();
        if (viewId == R.id.cardFunny) {
            selectedCategory = "funny";
        } else if (viewId == R.id.cardEmbarrassing) {
            selectedCategory = "embarrassing";
        } else if (viewId == R.id.cardChallenging) {
            selectedCategory = "challenging";
        } else if (viewId == R.id.cardRandom) {
            selectedCategory = "random";
        }
        if (getIntent().hasExtra("isFromTruth")) {
            Intent intent = new Intent(CategoryActivity.this, TruthActivity.class);
            intent.putExtra("selectedCategory", selectedCategory);
            startActivity(intent);
        } else if (getIntent().hasExtra("isFromDare")) {
            Intent intent = new Intent(CategoryActivity.this, DareActivity.class);
            intent.putExtra("selectedCategory", selectedCategory);
            startActivity(intent);
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        if (getIntent().hasExtra("isFromMain")) {
            startActivity(new Intent(CategoryActivity.this, StartActivity.class));
        } else {
            finish();
        }
    }
}
