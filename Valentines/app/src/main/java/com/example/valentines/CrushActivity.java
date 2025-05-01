package com.example.valentines;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class CrushActivity extends AppCompatActivity {

    int height = 0;
    int width = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crush);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ((Button)findViewById(R.id.yesButton)).setBackgroundColor(Color.parseColor("#F72C5B"));
        ((Button)findViewById(R.id.yesButton)).setTextColor(Color.WHITE);
        ((Button)findViewById(R.id.noButton)).setBackgroundColor(Color.parseColor("#5A0009"));
        ((Button)findViewById(R.id.noButton)).setTextColor(Color.WHITE);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
    }

    public void yesButtonClicked(View v){
        startActivity(new Intent(this, BeValentineActivity.class));
    }

    public void noButtonClicked(View v){
        Random random = new Random();
        float x = width*random.nextFloat();
        float y = height*random.nextFloat();
        int buttonWidth = v.getWidth();
        int buttonHeight = v.getHeight();

        if(x > width - buttonWidth) x-=buttonWidth;
        if(x < 2*buttonWidth) x+=buttonWidth;
        if(y > height - buttonHeight) y-=buttonHeight;
        if(y < buttonHeight) y+=buttonHeight;

        v.setX(x);
        v.setY(y);
    }
}