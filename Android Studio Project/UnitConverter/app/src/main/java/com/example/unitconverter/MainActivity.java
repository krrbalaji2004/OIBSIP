package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner categorySpinner, fromSpinner, toSpinner;
    EditText inputValue;
    Button convertButton;
    TextView resultText;

    String[] categories = {"Length", "Weight", "Temperature"};

    String[] lengthUnits = {"Centimeter", "Meter", "Kilometer"};
    String[] weightUnits = {"Gram", "Kilogram", "Pound"};
    String[] temperatureUnits = {"Celsius", "Fahrenheit", "Kelvin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        categorySpinner = findViewById(R.id.categorySpinner);
        fromSpinner = findViewById(R.id.fromSpinner);
        toSpinner = findViewById(R.id.toSpinner);
        inputValue = findViewById(R.id.inputValue);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<String> categoryAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        categories
                );

        categorySpinner.setAdapter(categoryAdapter);

        setUnits(lengthUnits);

        categorySpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        if (position == 0) {
                            setUnits(lengthUnits);
                        } else if (position == 1) {
                            setUnits(weightUnits);
                        } else {
                            setUnits(temperatureUnits);
                        }

                        inputValue.setText("");
                        resultText.setText("Result");
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        convertButton.setOnClickListener(v -> convert());
    }

    void setUnits(String[] units) {

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        units
                );

        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);
    }

    void convert() {

        String input = inputValue.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(
                    this,
                    "Please enter a value",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        double value = Double.parseDouble(input);

        int category = categorySpinner.getSelectedItemPosition();

        String from = fromSpinner.getSelectedItem().toString();
        String to = toSpinner.getSelectedItem().toString();

        double result = 0;

        if (category == 0) {
            result = convertLength(value, from, to);
        } else if (category == 1) {
            result = convertWeight(value, from, to);
        } else {
            result = convertTemperature(value, from, to);
        }

        resultText.setText(
                String.format("%.2f %s", result, to)
        );
    }

    double convertLength(double value, String from, String to) {

        double meter;

        if (from.equals("Centimeter")) {
            meter = value / 100;
        } else if (from.equals("Kilometer")) {
            meter = value * 1000;
        } else {
            meter = value;
        }

        if (to.equals("Centimeter")) {
            return meter * 100;
        } else if (to.equals("Kilometer")) {
            return meter / 1000;
        } else {
            return meter;
        }
    }

    double convertWeight(double value, String from, String to) {

        double kilogram;

        if (from.equals("Gram")) {
            kilogram = value / 1000;
        } else if (from.equals("Pound")) {
            kilogram = value * 0.453592;
        } else {
            kilogram = value;
        }

        if (to.equals("Gram")) {
            return kilogram * 1000;
        } else if (to.equals("Pound")) {
            return kilogram / 0.453592;
        } else {
            return kilogram;
        }
    }

    double convertTemperature(double value, String from, String to) {

        double celsius;

        if (from.equals("Fahrenheit")) {
            celsius = (value - 32) * 5 / 9;
        } else if (from.equals("Kelvin")) {
            celsius = value - 273.15;
        } else {
            celsius = value;
        }

        if (to.equals("Fahrenheit")) {
            return (celsius * 9 / 5) + 32;
        } else if (to.equals("Kelvin")) {
            return celsius + 273.15;
        } else {
            return celsius;
        }
    }
}