package com.example.quickconvert;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    private EditText amountInput;
    private Spinner fromCurrencySpinner, toCurrencySpinner;
    private Button convertButton;
    private TextView resultTextView;

    // Instanca konvertera
    private CurrencyConverter currencyConverter;
    // Instanca formatera
    private FormatCurrency formatCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        amountInput = findViewById(R.id.amountInput);
        fromCurrencySpinner = findViewById(R.id.fromCurrencySpinner);
        toCurrencySpinner = findViewById(R.id.toCurrencySpinner);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Inicijalizacija CurrencyConverter klase
        currencyConverter = new CurrencyConverter();
        formatCurrency = new FormatCurrency();

        // Postavljanje opcija u Spinner-e
        String[] currencies = {"EUR", "USD", "RSD"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currencies);
        fromCurrencySpinner.setAdapter(adapter);
        toCurrencySpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromCurrency = fromCurrencySpinner.getSelectedItem().toString();
                String toCurrency = toCurrencySpinner.getSelectedItem().toString();
                String amountText = amountInput.getText().toString();

                if (amountText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter amount", Toast.LENGTH_SHORT).show();
                    return;
                }

                double amount = Double.parseDouble(amountText);
                double result = currencyConverter.convert(amount, fromCurrency, toCurrency);
                resultTextView.setText("Result: " + formatCurrency.format(result, toCurrency));
            }
        });
    }
}