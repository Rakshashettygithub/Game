package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GuessTheNumber extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_number);

        editText = findViewById(R.id.edit_text_no);
        textViewResult = findViewById(R.id.text_view_result);
        button = findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int guesser = Integer.parseInt(editText.getText().toString());
                if (guesser == 50) {
                    textViewResult.setText(R.string.correct);
                    editText.setText("");
                } else {
                    textViewResult.setText(R.string.wrong);
                    editText.setText("");
                }

            }
        });
    }
}