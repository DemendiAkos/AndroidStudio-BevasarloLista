package com.example.bevasarlolistaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private List<Product> products;
    private Context context;

    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.product_list_items, viewGroup, false);
        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView quantityTextView = view.findViewById(R.id.quantityTextView);
        products.get(i);

        nameTextView.setText(products.get(i).getName());
        quantityTextView.setText("(" + products.get(i).getQuantity() + ")");


        return view;
    }
}
