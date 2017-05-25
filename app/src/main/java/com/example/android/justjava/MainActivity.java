package com.example.android.justjava;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


public class MainActivity extends AppCompatActivity {

    int quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view)
    {
        int price = quantity * 5;
        StringBuilder priceMessage = new StringBuilder();
        priceMessage.append("Price: ");
        priceMessage.append(price);
        priceMessage.append(" naira");
        priceMessage.append("\nThankYou!");
        displayMsg(priceMessage.toString());
    }

    public void incrementQty(View view)
    {
        quantity++;
        display(quantity);
    }

    public void decrementQty(View view)
    {
       quantity--;
        if (quantity > 0) {
            display(quantity);
        }
        else
        {
            quantity = 1;
            display(quantity);
        }
    }

    private void display(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textView);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_textView);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void displayMsg(String msg)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_textView);
        priceTextView.setText(msg);
    }
}
