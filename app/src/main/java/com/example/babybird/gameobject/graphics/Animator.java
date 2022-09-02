package com.example.babybird.gameobject.graphics;

import android.graphics.Canvas;
import android.util.Log;

import com.example.babybird.gameobject.GameDisplay;
import com.example.babybird.gameobject.gameelements.Enemy;
import com.example.babybird.gameobject.gameelements.Player;

public class Animator {
    protected Sprite[] spriteArray;
    private int selectImageToTonggle=0;
    protected static final int MAX_UPDATE_BEFORE_NEXT_MOVE_FRAME=45;
    protected int ImageMoving=0, updateBeforeNextMoveFrame=0,EnemyMoving=0,updateBeforeNextMoveFrameEnemy=0;
    protected void toggleImages(int updateBeforeNextMoveFrame, int selectImageToTonggle) {
        int xyz=updateBeforeNextMoveFrame/5;
        if(updateBeforeNextMoveFrame%5==0){
            ImageMoving=selectImageToTonggle+xyz;
        }
    }
    protected void toggleEnemyImages(int updateBeforeNextMoveFrameEnemy) {
        int xyz=updateBeforeNextMoveFrameEnemy/8;
        if(updateBeforeNextMoveFrameEnemy%8==0){
            EnemyMoving=xyz;
        }
    }
    public Animator(Sprite[] spriteArray) {
        this.spriteArray = spriteArray;
    }


    public void draw(Canvas canvas, GameDisplay gameDisplay, Player player) {
        switch (player.getPlayerState().getState()) {
            case FLYING_FRONT:
                selectImageToTonggle=0;
                break;
            case FLYING_BACKWARD:
                selectImageToTonggle=9;
                break;
            case FALLING_DOWN:
                selectImageToTonggle=18;
                break;
            default:
                selectImageToTonggle=0;
                break;
        }
        toggleImages(updateBeforeNextMoveFrame,selectImageToTonggle);
        counter();
        drawFrame(canvas,gameDisplay,player,spriteArray[ImageMoving]);
    }

    public void drawFrame(Canvas canvas, GameDisplay gameDisplay, Player player, Sprite sprite) {
        sprite.draw(
                canvas,
                (int) gameDisplay.gameToDisplayCoordinatesX(player.getPositionX()) - sprite.getWidth()/2,
                (int) gameDisplay.gameToDisplayCoordinatesY(player.getPositionY()) - sprite.getHeight()/2
        );
    }
    public void drawEnemy(Canvas canvas, GameDisplay gameDisplay,Enemy enemy) {
        counterEnemy();
        toggleEnemyImages(updateBeforeNextMoveFrameEnemy);
        drawEnemyFrame(canvas,gameDisplay,enemy,spriteArray[EnemyMoving]);
    }

    private void counterEnemy() {
        updateBeforeNextMoveFrameEnemy++;
        if(updateBeforeNextMoveFrameEnemy==79){
            updateBeforeNextMoveFrameEnemy=0;
        }
    }

    private void drawEnemyFrame(Canvas canvas,GameDisplay gameDisplay, Enemy enemy,  Sprite sprite) {
        sprite.drawEnemy(
                canvas,
                (int) gameDisplay.gameToDisplayCoordinatesX(enemy.getPositionX()) - sprite.getWidth()/2,
                (int) gameDisplay.gameToDisplayCoordinatesY(enemy.getPositionY()) - sprite.getHeight()/2);
    }
    private void counter(){
        updateBeforeNextMoveFrame++;
        if(updateBeforeNextMoveFrame==44){
            updateBeforeNextMoveFrame=0;
        }
    }
}
