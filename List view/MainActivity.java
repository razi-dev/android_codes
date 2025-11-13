package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list;
    TextView t1, t2;

    String[] countries = {"India", "China", "Australia", "America"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.simplelistview);
        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);

        ArrayAdapter<String> myarrayadapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

        list.setAdapter(myarrayadapter);

        // Register the listener
        list.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String selected = parent.getItemAtPosition(position).toString();

        t2.setText(selected);
    }
}
