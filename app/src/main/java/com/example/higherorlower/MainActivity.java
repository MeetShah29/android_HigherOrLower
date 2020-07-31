package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int randomNumber, editTextNumber;
    private EditText editText;
    private Random num = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.guessEditText);
        randomNumber = num.nextInt(20) + 1;
        System.out.println("random" + randomNumber);
    }


    public void makeToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }

    private void hideKeybaord(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
    }


    public void onGuessClick(View view) {

        if (editText.getText().toString().equals("") || editText.getText().toString().isEmpty()) {
            System.out.println("wrong");
            makeToast("Please enter some value!");

        } else {
            editTextNumber = Integer.parseInt(editText.getText().toString());
        }
        if (editText.getText().toString().isEmpty()==false ) {
            if (editTextNumber > randomNumber) {
                makeToast("Higher ! Wrong guess");

            } else if (editTextNumber < randomNumber) {
                makeToast("Lower ! Wrong guess");

            } else {
                makeToast("Perfect guess! Try your luck again....");
                hideKeybaord(view);
                randomNumber = num.nextInt(20) + 1;
                editText.getText().clear();
                System.out.println("random is"+randomNumber);
            }
        }
    }
}