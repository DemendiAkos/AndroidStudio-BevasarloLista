package com.example.bevasarlolistaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText productEditText;
    private EditText quantityEditText;
    private Button addButton;

    private ListView productListView;
    private List<Product> products;
    private ProductAdapter adapter;

    private String productName;
    private int quantity;


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

        init();



        productListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("productName", products.get(position).getName());
            intent.putExtra("quantity", products.get(position).getQuantity());
            startActivity(intent);
        });


        productListView.setOnItemLongClickListener((parent, view, position, id) -> {
            products.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productName = productEditText.getText().toString().trim();
                if (productName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Product name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    quantity = Integer.parseInt(quantityEditText.getText().toString().trim());
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Quantity must be a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                Product product = new Product(productName, quantity);
                products.add(product);
                productListView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

        });
    }

    public void init() {
        productEditText = findViewById(R.id.productEditText);
        quantityEditText = findViewById(R.id.quantityEditText);
        addButton = findViewById(R.id.addButton);


        products = new ArrayList<>();
        productListView = findViewById(R.id.productListView);
        adapter = new ProductAdapter(products, this);


    }
}