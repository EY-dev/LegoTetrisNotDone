package com.example.enot8.legotetris.objects;

import android.graphics.Color;
import android.graphics.Point;

import com.example.enot8.legotetris.Game;
import com.example.enot8.legotetris.objects.figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class FieldOfFigures {
    private List<Pixel> pixels;

    public FieldOfFigures(){
        this.pixels = new ArrayList<>();
    }

    public void add(Pixel p){
        this.pixels.add(p);
    }

    public void addFigure(Figure f){
        List<Pixel> figure = f.getPixels();
        for (Pixel item:figure){
            this.pixels.add(item);
        }

    }

    public Pixel find(Integer x, Integer y){
        Pixel p = new Pixel(new Point(x,y),Color.BLACK);
        for (Pixel item: this.pixels){
            if (item.equals(p)){
                return item;
            }
        }
        return null;
    }

    public Pixel find(Pixel p){
        for (Pixel item:this.pixels){
            if (item.equals(p)){
                return item;
            }
        }
        return null;
    }

    public void remove(Pixel p){
        this.pixels.remove(Game.getField().find(p));
    }

    public List<Pixel> getPixels(){
        return this.pixels;
    }
}
