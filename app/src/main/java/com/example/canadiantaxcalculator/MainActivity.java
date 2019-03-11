package com.example.canadiantaxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText edtPurchaseAmount;
    Button btnCalculate, btnClear;
    Spinner spnProvinces;
    TextView txtPurchaseAmount, txtProvince, txtTaxPercentage, txtTaxAmount, txtTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateLogic();
        clearLogic();
    }

    private void calculateLogic(){
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSalesTax();
            }
        });

    }
    private void clearLogic(){
        btnClear = findViewById(R.id.btnClear);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClearLogic();
            }
        });
    }

    private void calculateSalesTax(){
        edtPurchaseAmount = findViewById(R.id.edtPurchaseAmount);

        txtProvince= findViewById(R.id.txtProvince);
        txtPurchaseAmount= findViewById(R.id.txtPurchaseAmount);
        txtTaxAmount= findViewById(R.id.txtTaxAmount);
        txtTaxPercentage= findViewById(R.id.txtTaxPercentage);
        txtTotalPrice= findViewById(R.id.txtTotalPrice);

        spnProvinces= findViewById(R.id.spnProvinces);

        double amount = Double.parseDouble(edtPurchaseAmount.getText().toString());
        String selectedProvince = spnProvinces.getSelectedItem().toString();
        double taxAmount = 0d;
        double totalTax= 0d;
        double totalPrice= 0d;

        if(selectedProvince.equals("Alberta")){
            taxAmount = 0.05;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("British Columbia")){
            taxAmount = 0.12;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("Manitoba")){
            taxAmount = 0.13;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("New Brunswick")){
            taxAmount = 0.13;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("Newfoundland and labrador")){
            taxAmount = 0.13;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("Northwest Territories")){
            taxAmount = 0.05;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("Nova Scotia")){
            taxAmount = 0.15;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("Nunavut")){
            taxAmount = 0.05;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("Ontario")){
            taxAmount = 0.13;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("Prince Edward Island")){
            taxAmount = 0.14;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + 14.00 + "%");
        }
        if(selectedProvince.equals("Quebec")){
            taxAmount = 0.14975;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("Saskatchewan")){
            taxAmount = 0.1;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }
        if(selectedProvince.equals("Yukon")){
            taxAmount = 0.05;
            txtProvince.setText(selectedProvince);
            txtTaxPercentage.setText("Tax: " + taxAmount * 100 + "%");
        }

        totalTax = amount * taxAmount;
        totalPrice = totalTax + amount;

        String formatTotalTax = String.format("%1.2f", totalTax);
        String formatTotalPrice = String.format("%1.2f", totalPrice);
        txtTaxAmount.setText("Tax Amount: " + formatTotalTax);
        txtTotalPrice.setText("Total Price: " + formatTotalPrice);

    }

    private void buttonClearLogic(){
        edtPurchaseAmount = findViewById(R.id.edtPurchaseAmount);

        txtProvince= findViewById(R.id.txtProvince);
        txtPurchaseAmount= findViewById(R.id.txtPurchaseAmount);
        txtTaxAmount= findViewById(R.id.txtTaxAmount);
        txtTaxPercentage= findViewById(R.id.txtTaxPercentage);
        txtTotalPrice= findViewById(R.id.txtTotalPrice);

        txtProvince.setText("Province");
        edtPurchaseAmount.setText("");

        txtTaxAmount.setText("Tax: ");
        txtTaxPercentage.setText("Tax: 0%");
        txtTotalPrice.setText("Total Price: ");
    }
}
