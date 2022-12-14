package com.example.babybird.gameobject;

import android.graphics.Rect;
import android.util.Log;

import com.example.babybird.gameobject.gameelements.GameObject;

public class GameDisplay {
    public final Rect DISPLAY_RECT;
    private final int widthPixels;
    private final int heightPixels;
    //private final GameObject centerObject;
    private final double displayCenterX;
    private final double displayCenterY;
    private double gameToDisplayCoordinatesOffsetX;
    private double gameToDisplayCoordinatesOffsetY;
    private double gameCenterX;
    private final double gameCenterY;

    public GameDisplay(int widthPixels, int heightPixels, GameObject centerObject) {
        this.widthPixels = widthPixels;
        this.heightPixels = heightPixels;
        DISPLAY_RECT = new Rect(0, 0, widthPixels, heightPixels);

        //this.centerObject = centerObject;

        displayCenterX = widthPixels/2.0;
        displayCenterY = heightPixels/2.0;
        gameCenterX=displayCenterX;
        gameCenterY=displayCenterY;
        update();
    }

    public void update() {
        /*gameCenterX = centerObject.getPositionX();
        gameCenterY = centerObject.getPositionY();*/
        gameCenterX=gameCenterX+5;
        gameToDisplayCoordinatesOffsetX = displayCenterX ;
        gameToDisplayCoordinatesOffsetY = displayCenterY ;
        //Log.d("Display Position : ","Display Centre X : "+ displayCenterX+" -> Game Centre X : "+gameCenterX+" -> offset : "+gameToDisplayCoordinatesOffsetX);
    }

    public double gameToDisplayCoordinatesX(double x) {
        return x + gameToDisplayCoordinatesOffsetX;
    }

    public double gameToDisplayCoordinatesY(double y) {
        return y + gameToDisplayCoordinatesOffsetY;
    }

    public Rect getGameRect() {
        return new Rect(
                (int) (gameCenterX - widthPixels/2),
                (int) (gameCenterY - heightPixels/2),
                (int) (gameCenterX + widthPixels/2),
                (int) (gameCenterY + heightPixels/2)
        );
    }
    public double gameDisplayCentreX() {
        return displayCenterX;
    }
    public double gameDisplayCentreY() {
        return displayCenterY;
    }
}
