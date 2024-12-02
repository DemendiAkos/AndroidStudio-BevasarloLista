package com.example.bevasarlolistaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {
    private TextView productTextView;
    private TextView quantityTextView;
    private Button backButton;

    private String productName;
    private int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


       init();


       backButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
               startActivity(intent);
               finish();

           }
       });


    }
    

    public void init() {
         productTextView = findViewById(R.id.productTextView);
         quantityTextView = findViewById(R.id.quantityTextView);
         backButton = findViewById(R.id.backButton);

        Intent intent = getIntent();
        productName = intent.getStringExtra("productName");
        quantity = intent.getIntExtra("quantity", 0);

        productTextView.setText(productName);
        quantityTextView.setText(String.valueOf(quantity));
    }
}