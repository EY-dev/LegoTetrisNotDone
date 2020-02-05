package com.example.enot8.legotetris;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.example.enot8.legotetris.objects.Properties;

public class MainMenu extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Properties.setPhoneDisplayHeight(metrics.heightPixels);
        Properties.setPhoneDisplayWidth(metrics.widthPixels);
        Properties.setGameDisplayWidth((metrics.widthPixels*3)/4);
        Properties.setGameDisplayHeight((Properties.getGameDisplayWidth()/12)*20);
        Properties.setPixelHeight(Properties.getGameDisplayWidth()/12);
        Properties.setPixelWidth(Properties.getGameDisplayWidth()/12);
        Properties.setStartPoint(new Point(20,20));

        this.intent = new Intent(MainMenu.this, DisplayOfGame.class);
        setContentView(R.layout.main_menu);
    }

    public void onClick(View view) {
        final Button gameButton = (Button)findViewById(R.id.newGame);
        final Button continueButton = (Button)findViewById(R.id.continueGame);
        final Button scoreButton = (Button)findViewById(R.id.score);
        final Button quitButton = (Button)findViewById(R.id.quit);

        if (view.getId()==gameButton.getId()){

            continueButton.setEnabled(true);
            Game g1 = new Game();
            startActivity(this.intent);
        }
        else if (view.getId()==continueButton.getId()){
            Intent intent = new Intent(MainMenu.this, DisplayOfGame.class);
            startActivity(this.intent);
            Game.setContinue(true);
        }
        else if (view.getId()==scoreButton.getId()){

        }
        else if (view.getId()==quitButton.getId()){
            finish();
        }

    }

}
