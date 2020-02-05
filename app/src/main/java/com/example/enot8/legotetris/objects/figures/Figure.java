package com.example.enot8.legotetris.objects.figures;

import android.graphics.Point;

import com.example.enot8.legotetris.Game;
import com.example.enot8.legotetris.objects.FigureInterface;
import com.example.enot8.legotetris.objects.Pixel;
import com.example.enot8.legotetris.objects.Properties;

import java.util.ArrayList;
import java.util.List;

public abstract class Figure implements FigureInterface {

    private int step;
    private List<Pixel> figure;
    private Boolean isReady;
    private Boolean isLast;

    public Figure(){
        this.figure = new ArrayList<>();
        this.isReady = false;
        this.isLast = false;
        this.step = Properties.getPixelWidth();
    }

    public Boolean moveRight(){
        /*if (this.isReady()) {
            return false;
        }*/
        Boolean isPossible = true;
        for (Pixel item:this.figure){
            Integer x = item.getPosition().x+item.getWidth();
            if (x>=Properties.getGameDisplayWidth()){
                isPossible = false;
            }
            Pixel p = Game.getField().find(item.getPosition().x+this.step,item.getPosition().y);
            if (Game.getField().find(item.getPosition().x+this.step,item.getPosition().y)!=null){
                isPossible = false;
            }
        }
        if (isPossible) {
            for (Pixel item:this.figure){
                item.setPosition(new Point(item.getPosition().x+this.step,item.getPosition().y));
            }
        }else{return false;}
        return true;}
    public Boolean moveLeft(){
        /*if (this.isReady()) {
            return false;
        }*/
        Boolean isPossible = true;
        for (Pixel item:this.figure){
            Integer x = item.getPosition().x-item.getWidth();
            if (x<Properties.getStartPoint().x){
                isPossible = false;
            }
            if (Game.getField().find(item.getPosition().x-this.step,item.getPosition().y)!=null){
                isPossible = false;
            }
        }
        if (isPossible) {
            for (Pixel item:this.figure){
                item.setPosition(new Point(item.getPosition().x-this.step,item.getPosition().y));
            }
        }else{return false;}
        return true;
    }
    public Boolean moveDown() {
        if (!this.isReady()) {
            for (Pixel item:this.figure){
                item.setPosition(new Point(item.getPosition().x,item.getPosition().y+this.step));
            }
        }else{return false;}
        return true;
    }


    public Boolean isReady(){
        this.checkReady();
        return this.isReady;
    }
    public Boolean isLast(){
        this.checkLast();
        return this.isLast;
    }
    public List<Pixel> getPixels(){
        return this.figure;
    }
    public int getStep(){
        return this.step;
    }

    public int minX(){
        int min=10000;
        for (Pixel item:this.figure){
            if (min>item.getPosition().x){
                min = item.getPosition().x;
            }
        }
        return min;
    }

    public int maxX(){
        int max=0;
        for (Pixel item:this.figure){
            if (max<item.getPosition().x){
                max = item.getPosition().x;
            }
        }
        return max;
    }

    private Boolean checkReady(){
        for (Pixel item:this.figure){
            Integer y = item.getPosition().y+item.getHeight();
            Integer x = item.getPosition().x;
            Pixel p = Game.getField().find(x,y);
            if (p==null){
                if (y>=Properties.getGameDisplayHeight()){
                    this.isReady = true;
                    return true;
                }
            }else{
                this.isReady = true;
                return true;
            }
        }
        return false;
    }
    private Boolean checkLast(){
        for (Pixel item:this.figure){
            Pixel p = Game.getField().find(item);
            if (!(p==null)){
                this.isLast = true;
                return true;
            }
        }
        return false;
    }

    public abstract Boolean clockWiseRotation();
    public abstract Boolean antiClockWiseRotation();
}
