package com.example.enot8.legotetris.objects;

import android.graphics.Point;

public class Pixel {
    private Integer height;
    private Integer width;
    private Point position;
    private Integer pixelColor;

    public Pixel(Point p, Integer color){
        this.pixelColor = color;
        this.position   = new Point(p);
        this.height     = Properties.getPixelHeight()-10;
        this.width      = Properties.getPixelWidth()-10;
    }

    public Pixel(Integer x,Integer y, Integer color){
        this.pixelColor = color;
        this.position   = new Point(x,y);
        this.height     = Properties.getPixelHeight()-10;
        this.width      = Properties.getPixelWidth()-10;
    }

    public Point getPosition() {
        return position;
    }

    public Integer getPixelColor() {
        return pixelColor;
    }

    public void setPosition(Point p) {
        this.position = p;
    }

    public void setPixelColor(Integer color) {
        this.pixelColor = color;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Boolean equals(Pixel p) {
        int defX = Math.abs(this.position.x-p.getPosition().x);
        int defY = Math.abs(this.position.y-p.getPosition().y);
        if ((defY<this.getHeight())&&(defX<this.getWidth())){return true;}
        else{return false;}
    }
}
