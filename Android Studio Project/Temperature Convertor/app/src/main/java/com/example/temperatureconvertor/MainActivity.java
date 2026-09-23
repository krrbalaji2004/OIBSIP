package com.example.temperatureconverter;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText temperature;
    Spinner fromUnit;
    Spinner toUnit;
    Button convertButton;
    Button clearButton;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Find views
        temperature = findViewById(R.id.temperature);
        fromUnit = findViewById(R.id.fromUnit);
        toUnit = findViewById(R.id.toUnit);
        convertButton = findViewById(R.id.convertButton);
        clearButton = findViewById(R.id.clearButton);
        result = findViewById(R.id.result);

        // Temperature units
        String[] units = {
                "Celsius",
                "Fahrenheit"
        };

        // Create Spinner adapter
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        units
                );

        // Set adapter
        fromUnit.setAdapter(adapter);
        toUnit.setAdapter(adapter);

        // Convert button
        convertButton.setOnClickListener(v -> {

            String input =
                    temperature.getText()
                            .toString()
                            .trim();

            // Check empty input
            if (input.isEmpty()) {

                Toast.makeText(
                        this,
                        "Enter temperature",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Convert input to double
            double value =
                    Double.parseDouble(input);

            double converted;

            // Celsius to Fahrenheit
            if (fromUnit.getSelectedItem()
                    .toString()
                    .equals("Celsius")
                    &&
                    toUnit.getSelectedItem()
                            .toString()
                            .equals("Fahrenheit")) {

                converted =
                        (value * 9 / 5) + 32;

            }

            // Fahrenheit to Celsius
            else if (
                    fromUnit.getSelectedItem()
                            .toString()
                            .equals("Fahrenheit")
                            &&
                            toUnit.getSelectedItem()
                                    .toString()
                                    .equals("Celsius")
            ) {

                converted =
                        (value - 32) * 5 / 9;

            }

            // Same unit
            else {

                converted = value;
            }

            // Display result
            result.setText(
                    "Result: " +
                            String.format(
                                    "%.2f",
                                    converted
                            )
            );
        });

        // Clear button
        clearButton.setOnClickListener(v -> {

            temperature.setText("");

            result.setText("Result:");

            fromUnit.setSelection(0);

            toUnit.setSelection(0);
        });
    }
}