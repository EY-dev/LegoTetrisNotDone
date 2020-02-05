package com.example.enot8.legotetris.objects;

import java.util.List;

public interface FigureInterface {

    Boolean moveRight();
    Boolean moveLeft();
    Boolean moveDown();
    Boolean clockWiseRotation();
    Boolean antiClockWiseRotation();
    List<Pixel> getPixels();
    Boolean isReady();
    Boolean isLast();
}
