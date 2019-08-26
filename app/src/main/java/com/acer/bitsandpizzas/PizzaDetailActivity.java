package com.acer.bitsandpizzas;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaDetailActivity extends AppCompatActivity {
    public static final String EXTRA_PIZZA_ID = "pizzaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int pizzaId = (Integer) getIntent().getExtras().get(EXTRA_PIZZA_ID);

        String pizzaName = Pizza.pizzas[pizzaId].getName();

        TextView textView = findViewById(R.id.pizza_text);
        textView.setText(pizzaName);

        ImageView imageView = findViewById(R.id.pizza_image);
        Drawable drawable = getDrawable(Pizza.pizzas[pizzaId].getImageResourceId());
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(pizzaName);
    }
}
