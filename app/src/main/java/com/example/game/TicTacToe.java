package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TicTacToe extends AppCompatActivity {
    boolean gameActive=true;
    //player represtation
    //0-x
    //1-o
    int activerPlayer=0;

    int[] gameState={2,2,2,2,2,2,2,2,2};     //state meaning 0-x  1-o  2-Null

    int[][] winPosition={{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};
    public TextView POne;
    public TextView PTwo;

    public void PlayerTap(View view){
        POne=findViewById(R.id.textView3);
        PTwo=findViewById(R.id.textView4);

        String PlayerOne=getIntent().getStringExtra("KeyOne");
        String PlayerTwo=getIntent().getStringExtra("KeyTwo");
        POne.setText(PlayerOne+" is X");
        PTwo.setText(PlayerTwo+" is O");

        ImageView img=(ImageView) view; //ImageView ->data type , img->name that you give for your img
        //(ImageView)view ->in this conversion of view to Image will take place with data loss explicit type casting
        int tappedImage=Integer.parseInt(img.getTag().toString()); //used to convert value of tag associated with img into a interger

        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2 && gameActive){
            gameState[tappedImage]=activerPlayer;
            img.setTranslationY(-1000f);
            if(activerPlayer ==0){
                img.setImageResource(R.drawable.x);
                activerPlayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("O turn tap to play");
            }else{
                img.setImageResource(R.drawable.o);
                activerPlayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("X turn tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //check if any player has won
        for(int[] winPositions: winPosition){
           if( gameState[winPositions[0]]==gameState[winPositions[1]] &&
                   gameState[winPositions[1]]==gameState[winPositions[2]] &&
                        gameState[winPositions[0]]!=2){
               //somebody has won so find out
               String winnerstr;
               gameActive=false;
               if(gameState[winPositions[0]]==0){
                   winnerstr="X has won";
               }
               else{
                   winnerstr="O has won";
               }

               //update the status bar for winner announcment
               TextView status=findViewById(R.id.status);
               status.setText(winnerstr);

           }
        }
    }
    public void gameReset(View view){
        gameActive=true;
        activerPlayer=0;
        for( int i=0;i<gameState.length; i++){
            gameState[1]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status=findViewById(R.id.status);
        status.setText("X turn tap to play");

    }






        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
    }
}