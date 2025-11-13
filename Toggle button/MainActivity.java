package com.example.togglebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ToggleButton btn ;
    ImageView  img ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = findViewById(R.id.toggleBtn);
        btn.setOnClickListener(this);
        img = findViewById(R.id.imageView);

    }

    @Override
    public void onClick(View v) {

        if (btn.isChecked()){
            img.setImageResource(R.drawable.onn);
        }else{
            img.setImageResource(R.drawable.off);
        }

    }
}