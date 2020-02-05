package com.example.enot8.legotetris;

import android.support.constraint.solver.GoalRow;
import android.view.View;

import com.example.enot8.legotetris.objects.FieldOfFigures;
import com.example.enot8.legotetris.objects.NewFigure;
import com.example.enot8.legotetris.objects.figures.Figure;

import java.util.Random;

public final class Game {

    private static FieldOfFigures field;
    private static Figure currentFigure;
    private static Figure nextFigure;
    private static NewFigure factoryF;
    private static Boolean isAlive;
    private static Integer score;

    public Game(){
        if (Game.getFigure()==null){
            Game.field = new FieldOfFigures();
            Game.factoryF = new NewFigure();
            Game.nextFigure = factoryF.get();
            Game.currentFigure = factoryF.get();
        }
        Game.isAlive = true;
    }

    public static void play(View vr){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!Game.currentFigure.isLast()){
            Random rand = new Random();
            int type = rand.nextInt(4);
            int position = rand.nextInt(10)+1;
            for (int i = 0;i<position;i++){
                Game.currentFigure.moveRight();
            }
            for (int i = 0;i<type;i++){
                //Game.currentFigure.clockWiseRotation();
            }
            vr.invalidate();

            while (!Game.currentFigure.isReady()) {
                Game.currentFigure.moveDown();
                try {
                    //перерисовка
                    vr.invalidate();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            Game.field.addFigure(Game.currentFigure);
            if (Game.removeLines()){
                vr.invalidate();
            }
            Game.currentFigure = Game.nextFigure;
            Game.nextFigure = factoryF.get();
        }

    }

    public static synchronized Figure getFigure(){
        return Game.currentFigure;
    }
    public static synchronized FieldOfFigures getField(){
        return Game.field;
    }
    public static synchronized Figure getNextFigure(){
        return Game.nextFigure;
    }
    public static synchronized Boolean getContinue(){
        return Game.isAlive;
    }
    public static synchronized void setContinue(Boolean b){
        Game.isAlive = b;
    }
    private static synchronized Boolean removeLines(){

        return false;
    }

}
