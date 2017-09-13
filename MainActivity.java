package com.bharathsurampudi.connect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    //0 is black and 1 is red
    int player = 0;
    // 2 means unplayed
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winpos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{1,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dropIn(View view){
        ImageView counter  = (ImageView) view;
        int taped = Integer.parseInt(counter.getTag().toString());
        if(gameState[taped] == 2) {
            gameState[taped] = player;
            counter.setTranslationY(-1000f);
            if (player == 0) {
                counter.setImageResource(R.drawable.black);
                player = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                player = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(300);
            //caluculate win here
            for(int[]win : winpos){
                if(gameState[win[0]] == gameState[win[1]] && gameState[win[1]] == gameState[win[2]] && gameState[win[0]] != 2){
                    System.out.println(player+" won");

                }
            }
        }
    }

}
