package com.example.sharedpreference;

import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity implements View

        .OnClickListener {
    TextView t1;
    EditText e1,e2;
    Button b1,b2;

    SharedPreferences sp;

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

        t1 = findViewById(R.id.textView);
        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);



         sp= getSharedPreferences("sharedpref", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.button){

            SharedPreferences.Editor myEditor = sp.edit();;
            String name = e1.getText().toString();
            String pass= e2.getText().toString();

            myEditor.putString("myusername",name);
            myEditor.putString("mypassword",pass);
            
            myEditor.apply();

        } else if (v.getId()==R.id.button2) {

            String username = sp.getString("myusername","");
            String password = sp.getString("mypassword", "");

            e1.setText(username);
            e2.setText(password);
            
        }


    }



}