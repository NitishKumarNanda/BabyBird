package com.example.babybird.gameobject.gameelements;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.example.babybird.R;
import com.example.babybird.gameobject.GameDisplay;
import com.example.babybird.gameobject.GameLoop;
import com.example.babybird.gameobject.Utils;
import com.example.babybird.gameobject.gamepanel.HealthBar;
import com.example.babybird.gameobject.gamepanel.Joystick;
import com.example.babybird.gameobject.graphics.Animator;

public class Player extends Circle {
    public static final double SPEED_PIXELS_PER_SECOND = 600.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    public static final int MAX_HEALTH_POINTS = 5;
    private Joystick joystick;
    private HealthBar healthBar;
    private int healthPoints = MAX_HEALTH_POINTS;
    private Animator animator;
    private PlayerState playerState;
    double gameCentreX=0,gameCentreY=0,displayCentreX=0,displayCentreY=0;

    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius, Animator animator) {
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);
        this.joystick = joystick;
        this.healthBar = new HealthBar(context, this);
        this.animator = animator;
        this.playerState = new PlayerState(this);
    }

    public void update() {

        // Update velocity based on actuator of joystick
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;

        // Update position
//        positionX += velocityX;
//        positionY += velocityY;
        if((positionY) < displayCentreY && positionY>=-displayCentreY) {
            positionY += velocityY;
            if(positionX >(int)(displayCentreX)) {
                positionX =(int)(displayCentreX)-1;
            }
            if(positionX<-displayCentreX){
                positionX=(int)-displayCentreX+1;
            }
        }
        if(positionX < displayCentreX && positionX>=-displayCentreX) {
            positionX += velocityX;
            if(positionY >(int)(displayCentreY)) {
                positionY =(int)(displayCentreY)-1;
            }
            if(positionY<-displayCentreY){
                positionY=(int)-displayCentreY+1;
            }
        }



        // Update direction
        if (velocityX != 0 || velocityY != 0) {
            // Normalize velocity to get direction (unit vector of velocity)
            double distance = Utils.getDistanceBetweenPoints(0, 0, velocityX, velocityY);
            directionX = velocityX/distance;
            directionY = velocityY/distance;
        }
        playerState.update();
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        gameCentreX=gameDisplay.gameToDisplayCoordinatesX(0);
        gameCentreY=gameDisplay.gameToDisplayCoordinatesY(0);
        displayCentreX=gameDisplay.gameDisplayCentreX()-radius;
        displayCentreY=gameDisplay.gameDisplayCentreY()-radius;
        animator.draw(canvas, gameDisplay, this);
        healthBar.draw(canvas, gameDisplay);
    }

    public int getHealthPoint() {
        return healthPoints;
    }

    public void setHealthPoint(int healthPoints) {
        // Only allow positive values
        if (healthPoints >= 0)
            this.healthPoints = healthPoints;
    }
    public boolean direction(){
        if(velocityX<0) return false;
        else return true;
    }
    public PlayerState getPlayerState() {
        return playerState;
    }
}
