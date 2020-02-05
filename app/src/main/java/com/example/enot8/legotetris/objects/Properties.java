package com.example.enot8.legotetris.objects;

import android.graphics.Point;

public final class Properties {

    private static int gameDisplayHeight;
    private static int gameDisplayWidth;
    private static int phoneDisplayHeight;
    private static int phoneDisplayWidth;

    private static Point startPoint;

    private static int pixelHeight = 90;
    private static int pixelWidth = 90;


    public static int getPixelHeight() { return pixelHeight; }

    public static void setPixelHeight(int height) { Properties.pixelHeight = height; }

    public static int getPixelWidth() { return pixelWidth; }

    public static void setPixelWidth(int wight) { Properties.pixelWidth = wight; }

    public static int getGameDisplayHeight() { return gameDisplayHeight; }

    public static void setGameDisplayHeight(int height) { Properties.gameDisplayHeight = height; }

    public static int getGameDisplayWidth() { return gameDisplayWidth; }

    public static void setGameDisplayWidth(int wight) { Properties.gameDisplayWidth = wight; }

    public static int getPhoneDisplayWidth() { return phoneDisplayWidth; }

    public static void setPhoneDisplayWidth(int wight) { Properties.phoneDisplayWidth = wight; }

    public static int getPhoneDisplayHeight() { return phoneDisplayHeight; }

    public static void setPhoneDisplayHeight(int height) { Properties.phoneDisplayHeight = height; }

    public static Point getStartPoint() { return startPoint; }

    public static void setStartPoint(Point point) { Properties.startPoint = point; }
}
