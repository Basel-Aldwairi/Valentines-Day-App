package com.example.valentines;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;

public class LikeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_like);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ((Button)findViewById(R.id.confirmButton)).setBackgroundColor(Color.parseColor("#5A0009"));
        ((Button)findViewById(R.id.confirmButton)).setTextColor(Color.WHITE);
    }

    public void confirmOption(View v){
        boolean clicked = false;
        Intent intent = null;

        if(((Chip)findViewById(R.id.yesChip)).isChecked()) {
            intent = new Intent(this,YesActivity.class);
            clicked = true;
        }
        if(((Chip)findViewById(R.id.definitelyChip)).isChecked()) {
            intent = new Intent(this,DefinitelyActivity.class);
            clicked = true;
        }
        if(((Chip)findViewById(R.id.absolutelyChip)).isChecked()) {
            intent = new Intent(this,AbsolutelyActivity.class);
            clicked = true;
        }

        if(!clicked){
            Toast.makeText(this,"Select a Chip",Toast.LENGTH_SHORT).show();
            return;
        }else {
            startActivity(intent);
        }
    }

}