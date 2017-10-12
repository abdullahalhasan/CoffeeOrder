package me.hasan.coffeeorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView quantityTextView;
    private TextView finalQuantityTextView;
    private TextView unitPriceTextView;
    private TextView totalPriceTextView;
    private TextView greetingsTextView;

    private Button plusButton;
    private Button minusButton;

    private int quantity;
    private int finalQuantity;
    private int totalPrice;

    private final int unitPrice = 50;
    private final String greeting = "Thank You for Purchasing";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        quantityTextView = (TextView) findViewById(R.id.quantityTextView);
        finalQuantityTextView = (TextView) findViewById(R.id.finalQuantityTextView);
        unitPriceTextView = (TextView) findViewById(R.id.unitPriceTextView);
        totalPriceTextView = (TextView) findViewById(R.id.totalPriceTextView);
        greetingsTextView = (TextView) findViewById(R.id.greetingsTextView);

        plusButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);

        quantity = 0;
        finalQuantity = 0;
        totalPrice = 0;

        minusButton.setEnabled(false);
    }

    public void minus(View view) {
        if (quantity < 1) {
            minusButton.setEnabled(false);
        }
        else {
            quantity--;
            quantityTextView.setText(String.valueOf(quantity));
        }
    }

    public void plus(View view) {
        if (minusButton.isEnabled() == false)
            minusButton.setEnabled(true);
        quantity++;
        quantityTextView.setText(String.valueOf(quantity));
    }

    public void order(View view) {
        minusButton.setEnabled(false);
        plusButton.setEnabled(false);
        totalPrice = quantity * unitPrice;
        finalQuantityTextView.setText("Quantity : "+quantity);
        unitPriceTextView.setText("Unit Price : "+unitPrice);
        totalPriceTextView.setText("Total Price : "+totalPrice);
        greetingsTextView.setText(greeting);
    }
}
