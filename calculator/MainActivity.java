package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et1,et2;
    TextView tv;
    Button b1,b2,b3,b4;


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

        et1=findViewById(R.id.editTextText);
        et2=findViewById(R.id.editTextText2);
        tv=findViewById(R.id.textView);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // It's good practice to check if the input fields are empty
        if (et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty()) {
            tv.setText("Please enter both numbers");
            return;
        }

        int a=Integer.parseInt(et1.getText().toString());
        int b=Integer.parseInt(et2.getText().toString());
        int result;

        if(v.getId()==R.id.button){
            result = a+b;
            tv.setText(String.valueOf(result)); // FIX: Convert integer to String
        } else if (v.getId()==R.id.button2) {
            result = a-b;
            tv.setText(String.valueOf(result)); // FIX: Convert integer to String
        } else if (v.getId()==R.id.button3) {
            // Add a check for division by zero
            if (b == 0) {
                tv.setText("Cannot divide by zero");
            } else {
                result = a/b;
                tv.setText(String.valueOf(result)); // FIX: Convert integer to String
            }
        } else if (v.getId()==R.id.button4) {
            result = a*b;
            tv.setText(String.valueOf(result)); // FIX: Convert integer to String
        }else{
            tv.setText("Invalid");
        }
    }
}
