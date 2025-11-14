package com.example.imagecycle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnNext, btnPrev;
    // An array to hold the resource IDs of your images
    // Make sure the names (e.g., img1) match the files you added to res/drawable
    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    // The 'index' variable keeps track of the current image
    int index = 0;

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

        // Link the variables to the views in the layout file
        imageView = findViewById(R.id.imageView);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);

        // Set the first image when the app starts
        imageView.setImageResource(images[index]);

        // Set a click listener for the "Next" button
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment the index to get the next image
                index++;
                // If the index goes past the end of the array, loop back to the start
                if (index == images.length) {
                    index = 0;
                }
                // Set the ImageView to the new image
                imageView.setImageResource(images[index]);
            }
        });

        // Set a click listener for the "Previous" button
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Decrement the index to get the previous image
                index--;
                // If the index goes below the start of the array, loop to the end
                if (index < 0) {
                    index = images.length - 1;
                }
                // Set the ImageView to the new image
                imageView.setImageResource(images[index]);
            }
        });
    }
}
