package com.example.enot8.legotetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.graphics.Rect;
import android.graphics.Region;

import android.util.AttributeSet;
import android.view.View;

import com.example.enot8.legotetris.objects.Pixel;
import com.example.enot8.legotetris.objects.Properties;

import java.util.List;

public class DisplayView extends View {
    Rect blackGround;
    Paint p;
    Region.Op op = Region.Op.UNION;
    final int myColorWay = Color.argb(15,255,255,255);

    public DisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.p = new Paint();
        p.setStrokeWidth(10);
        blackGround = new Rect(10,10,Properties.getGameDisplayWidth()+20, Properties.getGameDisplayHeight()+20);
    }

    public DisplayView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public DisplayView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        this.drawDisplay(canvas);

        this.drawNextFigure(canvas);

        this.drawWay(canvas);

        this.drawFigure(canvas);

        this.drawField(canvas);

    }

    private void drawDisplay(Canvas canvas){
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);
        canvas.drawRect(blackGround, p);
    }
    private void drawNextFigure(Canvas canvas){
        List<Pixel> nextFigure = Game.getNextFigure().getPixels();
        int deltaXFigure = Game.getNextFigure().maxX() - Game.getNextFigure().minX();
        int startX = (Properties.getPhoneDisplayWidth() + Properties.getGameDisplayWidth() - deltaXFigure - Properties.getPixelWidth())/2;
        int startY = Properties.getStartPoint().y;

        for(Pixel item : nextFigure){
            int x = startX+item.getPosition().x;
            int y = startY + item.getPosition().y+item.getHeight();
            Rect pixel = new Rect(x,y,x+item.getWidth(),y+item.getHeight());
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            canvas.drawRect(pixel, p);
            p.setStyle(Paint.Style.FILL);
            p.setColor(item.getPixelColor());
            canvas.drawRect(pixel, p);
        }
    }
    private void drawWay(Canvas canvas){
        int min = Game.getFigure().minX();
        int max = Game.getFigure().maxX();
        Rect way = new Rect(min,Properties.getStartPoint().y,max+Properties.getPixelWidth()-10,Properties.getGameDisplayHeight());

        p.setStyle(Paint.Style.FILL);
        p.setColor(this.myColorWay);
        canvas.drawRect(way, p);
    }
    private void drawFigure(Canvas canvas){
        List<Pixel> figure = Game.getFigure().getPixels();
        for(Pixel item : figure){
            Rect pixel = new Rect(item.getPosition().x,item.getPosition().y,item.getPosition().x+item.getHeight(),item.getPosition().y+item.getWidth());
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            canvas.drawRect(pixel, p);
            p.setStyle(Paint.Style.FILL);
            p.setColor(item.getPixelColor());
            canvas.drawRect(pixel, p);
        }
    }
    private void drawField(Canvas canvas){
        List<Pixel> field = Game.getField().getPixels();
        for(Pixel item : field){
            Rect pixel = new Rect(item.getPosition().x,item.getPosition().y,item.getPosition().x+item.getHeight(),item.getPosition().y+item.getWidth());
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            canvas.drawRect(pixel, p);
            p.setStyle(Paint.Style.FILL);
            p.setColor(item.getPixelColor());
            canvas.drawRect(pixel, p);
        }
    }
}

