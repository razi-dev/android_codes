package com.example.form;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  {
    Button btn;

    EditText et , et2;

    @SuppressLint("MissingInflatedId")
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

        et=findViewById(R.id.editTextText);
//        btn1=findViewById(R.id.btn1);

        et2 =findViewById(R.id.editTextText3);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                startActivity(intent);
                String uname, pass;
                 uname =et.getText().toString();
                 pass = et2.getText().toString();
                 if(uname.equals("razi@gmail.com")&&pass.equals("123")){
                     Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();

                     Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                     String n=et.getText().toString();
                     String p=et2.getText().toString();
                     intent.putExtra("pass",p);
                     intent.putExtra("data",n);
                     startActivity(intent);
                 }else {
                     Toast.makeText(MainActivity.this, "login invalid", Toast.LENGTH_SHORT).show();
                 }
                 if(uname.contains("@gmail.com")){
                     Toast.makeText(MainActivity.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                 }else {
                     Toast.makeText(MainActivity.this, "login invalid", Toast.LENGTH_SHORT).show();
                 }



            }
        });
    }
}