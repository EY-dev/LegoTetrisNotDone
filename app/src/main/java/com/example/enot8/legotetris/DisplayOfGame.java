package com.example.enot8.legotetris;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.enot8.legotetris.objects.Properties;


public class DisplayOfGame extends AppCompatActivity {

    private Button moveRight;
    private Button moveLeft;
    private Button clockWiseRotation;
    private Button antiClockWiseRotation;
    private View view;
    private TextView textNext;
    private TextView textScore;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        this.moveRight = (Button)findViewById(R.id.buttonRight);
        this.moveLeft = (Button)findViewById(R.id.buttonLeft);
        this.clockWiseRotation = (Button)findViewById(R.id.buttonRotateClock);
        this.antiClockWiseRotation = (Button)findViewById(R.id.buttonRotateAntiClock);
        this.view = (View) findViewById (R.id.game);
        this.textNext = (TextView) findViewById(R.id.textNext);
        this.textNext.setWidth(Properties.getPhoneDisplayWidth()-Properties.getGameDisplayWidth());
        this.textScore = (TextView) findViewById(R.id.textScore);
        this.textScore.setWidth(Properties.getPhoneDisplayWidth()-Properties.getGameDisplayWidth());
        Runnable runnable = new Runnable() {
            public void run() {
                Game.play(view);
            }
        };
        this.thread = new Thread(runnable);
        this.thread.start();

    }

    public void onClick(View view){
        synchronized (Game.class){
            if (view.getId()==this.moveRight.getId()){
                if (Game.getFigure().moveRight()){this.view.invalidate();}
            }else if(view.getId()==this.moveLeft.getId()){
                Game.getFigure().moveLeft();
                this.view.invalidate();
            }else if(view.getId()==this.clockWiseRotation.getId()){
                Game.getFigure().clockWiseRotation();
                this.view.invalidate();
            }else if(view.getId()==this.antiClockWiseRotation.getId()){
                Game.getFigure().antiClockWiseRotation();
                this.view.invalidate();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Game.setContinue(false);
        finish();
    }
}
