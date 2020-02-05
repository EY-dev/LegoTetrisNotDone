package com.example.enot8.legotetris.objects.figures;

import android.graphics.Color;

import com.example.enot8.legotetris.objects.Pixel;
import com.example.enot8.legotetris.objects.Properties;


public class FigureTypeO extends Figure {

    private final Integer color = Color.GREEN;

    public FigureTypeO(){
        super();
        super.getPixels().add(new Pixel(Properties.getStartPoint().x,Properties.getStartPoint().y,this.color));
        super.getPixels().add(new Pixel(Properties.getStartPoint().x,Properties.getStartPoint().y+super.getStep(),this.color));
        super.getPixels().add(new Pixel(Properties.getStartPoint().x+super.getStep(),Properties.getStartPoint().y,Color.GREEN));
        super.getPixels().add(new Pixel(Properties.getStartPoint().x+super.getStep(),Properties.getStartPoint().y+super.getStep(),this.color));
    }

    @Override
    public Boolean clockWiseRotation() {
        return true;
    }

    @Override
    public Boolean antiClockWiseRotation() {
        return true;
    }

}
