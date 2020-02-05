package com.example.enot8.legotetris.objects;

import com.example.enot8.legotetris.objects.figures.Figure;
import com.example.enot8.legotetris.objects.figures.FigureTypeG;
import com.example.enot8.legotetris.objects.figures.FigureTypeI;
import com.example.enot8.legotetris.objects.figures.FigureTypeL;
import com.example.enot8.legotetris.objects.figures.FigureTypeO;
import com.example.enot8.legotetris.objects.figures.FigureTypeT;

import java.util.Random;

public class NewFigure {
    private Figure figure;

    public NewFigure(){

    }

    public Figure get(){
        Random rand = new Random();
        // Generate random integers in range 0 to 6
        int type = rand.nextInt(7);
        if (type == 0){
            this.figure = new FigureTypeI();
        }else if (type == 1){
            this.figure = new FigureTypeO();
        }else if (type == 2){
            this.figure = new FigureTypeT();
        }else if (type == 3){
            this.figure = new FigureTypeL();
        }else if (type == 4){
            this.figure = new FigureTypeG();
        }else if (type == 5){
            this.figure = new FigureTypeI();
        }else if (type == 6){
            this.figure = new FigureTypeI();
        }else{this.figure = new FigureTypeI();}
        this.figure = new FigureTypeG();
        return this.figure;
    }

}
