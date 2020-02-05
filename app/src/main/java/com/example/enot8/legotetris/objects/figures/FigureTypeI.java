package com.example.enot8.legotetris.objects.figures;

import android.graphics.Color;
import android.graphics.Point;

import com.example.enot8.legotetris.Game;
import com.example.enot8.legotetris.objects.Pixel;
import com.example.enot8.legotetris.objects.Properties;


public class FigureTypeI extends Figure {

    private final Integer color = Color.BLUE;

    public FigureTypeI(){
        super();
        super.getPixels().add(new Pixel(Properties.getStartPoint().x,Properties.getStartPoint().y,this.color));
        super.getPixels().add(new Pixel(Properties.getStartPoint().x,Properties.getStartPoint().y+super.getStep(),this.color));
        super.getPixels().add(new Pixel(Properties.getStartPoint().x,Properties.getStartPoint().y+2*super.getStep(),this.color));
        super.getPixels().add(new Pixel(Properties.getStartPoint().x,Properties.getStartPoint().y+3*super.getStep(),this.color));
    }

    @Override
    public Boolean clockWiseRotation() {
        return this.antiClockWiseRotation();
    }

    @Override
    public Boolean antiClockWiseRotation() {
        Pixel p1 = super.getPixels().get(0);
        Pixel p3 = super.getPixels().get(3);
        Pixel mainP = super.getPixels().get(2);
        Point newPoint1;
        Point newPoint2;
        Point newPoint4;
        if (p1.getPosition().y<mainP.getPosition().y){
            if ((p1.getPosition().x-2*super.getStep()>Properties.getStartPoint().x)&&((p3.getPosition().x+super.getStep()<Properties.getGameDisplayWidth()))){
                newPoint1 = new Point(super.getPixels().get(0).getPosition().x-2*super.getStep(),super.getPixels().get(0).getPosition().y+2*super.getStep());
                newPoint2 = new Point(super.getPixels().get(1).getPosition().x-super.getStep(),super.getPixels().get(1).getPosition().y+super.getStep());
                newPoint4 = new Point(super.getPixels().get(3).getPosition().x+super.getStep(),super.getPixels().get(3).getPosition().y-super.getStep());
            }else{
                return false;
            }
        }else if (p1.getPosition().x<mainP.getPosition().x){
            if (p1.getPosition().y + 2 * super.getStep() < Properties.getGameDisplayHeight()){
                newPoint1 = new Point(super.getPixels().get(0).getPosition().x+2*super.getStep(),super.getPixels().get(0).getPosition().y+2*super.getStep());
                newPoint2 = new Point(super.getPixels().get(1).getPosition().x+super.getStep(),super.getPixels().get(1).getPosition().y+super.getStep());
                newPoint4 = new Point(super.getPixels().get(3).getPosition().x-super.getStep(),super.getPixels().get(3).getPosition().y-super.getStep());
            }else{
                return false;
            }
        }else if (p1.getPosition().y>mainP.getPosition().y){
            if ((p1.getPosition().x + 2 * super.getStep() < Properties.getGameDisplayWidth())&&((p3.getPosition().x-super.getStep()>=Properties.getStartPoint().x))){
                newPoint1 = new Point(super.getPixels().get(0).getPosition().x+2*super.getStep(),super.getPixels().get(0).getPosition().y-2*super.getStep());
                newPoint2 = new Point(super.getPixels().get(1).getPosition().x+super.getStep(),super.getPixels().get(1).getPosition().y-super.getStep());
                newPoint4 = new Point(super.getPixels().get(3).getPosition().x-super.getStep(),super.getPixels().get(3).getPosition().y+super.getStep());
            }else{
                return false;
            }
        }
        else{
            if (p3.getPosition().y + super.getStep() < Properties.getGameDisplayHeight()) {
                newPoint1 = new Point(super.getPixels().get(0).getPosition().x - 2 * super.getStep(), super.getPixels().get(0).getPosition().y - 2 * super.getStep());
                newPoint2 = new Point(super.getPixels().get(1).getPosition().x - super.getStep(), super.getPixels().get(1).getPosition().y - super.getStep());
                newPoint4 = new Point(super.getPixels().get(3).getPosition().x + super.getStep(), super.getPixels().get(3).getPosition().y + super.getStep());
            }else{return false;}
        }
        if ((Game.getField().find(newPoint1.x,newPoint1.y)==null)&&(Game.getField().find(newPoint2.x,newPoint2.y)==null)&&(Game.getField().find(newPoint4.x,newPoint4.y)==null)) {
            super.getPixels().get(0).setPosition(newPoint1);
            super.getPixels().get(1).setPosition(newPoint2);
            super.getPixels().get(3).setPosition(newPoint4);
            return true;
        }
        return false;
    }

}
