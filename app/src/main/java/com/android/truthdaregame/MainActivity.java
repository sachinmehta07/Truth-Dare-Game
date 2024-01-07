package com.android.truthdaregame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.truthdaregame.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int lastDirection;
    private MediaPlayer mp;
    private ActivityMainBinding binding;
    private boolean isBottleSpin = false;
    private boolean isAnyOptionSelected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.truthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNxt = new Intent(new Intent(getApplicationContext(), CategoryActivity.class));
                iNxt.putExtra("isFromTruth", "true");
                isAnyOptionSelected = true;
                startActivity(iNxt);
            }
        });

        binding.dareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAnyOptionSelected = true;
                Intent iNxt = new Intent(new Intent(getApplicationContext(), CategoryActivity.class));
                iNxt.putExtra("isFromDare", "true");
                startActivity(iNxt);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isBottleSpin = getIntent().hasExtra("isFromCat");
        binding.editStartEnd.setText(R.string.spin_bottle_now);
        isAnyOptionSelected = true;
    }

    public void spin(View view) {
        if (isAnyOptionSelected) {
            int newDirection = new Random().nextInt(5400);
            float pivotX = (float) binding.ivBottle.getWidth() / 2;
            float pivotY = (float) binding.ivBottle.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDirection, newDirection, pivotX, pivotY);
            rotate.setDuration(2000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.audio);
                    mp.start();
                    binding.truthBtn.setEnabled(false);
                    binding.dareBtn.setEnabled(false);
                    binding.editStartEnd.setText("Game Begins");
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mp.stop();
                    mp.release();
                    binding.truthBtn.setEnabled(true);
                    binding.dareBtn.setEnabled(true);
                    mp = null;
                    isBottleSpin = true;
                    isAnyOptionSelected = false;
                    binding.editStartEnd.setText("Choose now...Truth or Dare");
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            lastDirection = newDirection;
            binding.ivBottle.startAnimation(rotate);
        } else {
            Toast.makeText(this, "Please select truth or dare first", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, StartActivity.class));
    }
}
