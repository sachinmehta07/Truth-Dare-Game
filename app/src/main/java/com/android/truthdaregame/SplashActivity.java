package com.android.truthdaregame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.truthdaregame.databinding.ActivitySplashBinding;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Load the animation
        Animation zoomAnimation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.zoom_animation);

        // Set AnimationListener to listen for animation end
        zoomAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Animation start event
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Animation end event
                startNextActivity(); // Call the method to start the new activity
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Animation repeat event
            }
        });

        // Apply the animation to the ImageView
        binding.ivLogo.startAnimation(zoomAnimation);

    }

    private void startNextActivity() {
        startActivity(new Intent(SplashActivity.this, StartActivity.class));
        // Finish the current activity to prevent user from coming back to the splash screen
        finish();
    }
}