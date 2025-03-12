package com.example.quickcv;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreenApp extends AppCompatActivity {

//    hooks
    ImageView ivLogo;
    TextView tvAppName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

//        logo animation applying
        Animation left_to_right = AnimationUtils.loadAnimation(this, R.anim.left_to_right_animation);
        ivLogo.startAnimation(left_to_right);

//        App name animation applying
        Animation fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in_animation);
        tvAppName.startAnimation(fade_in);

//        hold for 4 seconds then redirect to main screen
        new Handler().postDelayed(()->{
            Intent i=new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        },4000);

    }

    private void init(){
//        connection
        ivLogo=findViewById(R.id.ivLogo);
        tvAppName=findViewById(R.id.tvAppName);
    }
}