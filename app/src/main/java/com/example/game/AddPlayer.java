package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        EditText PlayerOne=findViewById(R.id.PlayerOneName);
        EditText PlayerTwo=findViewById(R.id.PlayerTwoName);
        Button startGameButton=findViewById(R.id.StartGameButton);


        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String getPlayerOneName= PlayerOne.getText().toString();
                final String getPlayerTwoName=PlayerTwo.getText().toString();
                if(getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){
                    Toast.makeText(AddPlayer.this, "Please Enter Player Name", Toast.LENGTH_SHORT).show();
                }

                else{
                    Intent intent=new Intent(AddPlayer.this,TicTacToe.class);
                    intent.putExtra("KeyOne",getPlayerOneName);
                    intent.putExtra("KeyTwo",getPlayerTwoName);
                    startActivity(intent);
                }
            }
        });
    }
}