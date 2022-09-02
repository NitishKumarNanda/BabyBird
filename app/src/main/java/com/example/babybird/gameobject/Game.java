package com.example.babybird.gameobject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.babybird.gameobject.gameelements.Circle;
import com.example.babybird.gameobject.gameelements.Enemy;
import com.example.babybird.gameobject.gameelements.Player;
import com.example.babybird.gameobject.gamepanel.GameOver;
import com.example.babybird.gameobject.gamepanel.Joystick;
import com.example.babybird.gameobject.gamepanel.Performance;
import com.example.babybird.gameobject.gamepanel.inGameMenu;
import com.example.babybird.gameobject.graphics.Animator;
import com.example.babybird.gameobject.graphics.SpriteSheet;
import com.example.babybird.gameobject.map.SpriteSheetMap;
import com.example.babybird.gameobject.map.Tilemap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game extends SurfaceView implements SurfaceHolder.Callback {

    private final Tilemap tilemap;
    private int joystickPointerId = 0;
    private final Joystick joystick;

    private final Player player;
    private GameLoop gameLoop;
    private List<Enemy> enemyList = new ArrayList<Enemy>();
    private GameOver gameOver;
    private Performance performance;
    private GameDisplay gameDisplay;
    private Animator animatorEnemy;
    private inGameMenu ingameMenu;
    DisplayMetrics displayMetrics;

    public Game(Context context) {
        super(context);

        // Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        gameLoop = new GameLoop(this, surfaceHolder);

        // Initialize game panels
        performance = new Performance(context, gameLoop);
        gameOver = new GameOver(context);
        ingameMenu=new inGameMenu(context);
        displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        joystick = new Joystick(300, displayMetrics.heightPixels-350, 130, 70);
        // Initialize game objects
        SpriteSheet spriteSheet = new SpriteSheet(context);
        Animator animator = new Animator(spriteSheet.getPlayerSpriteArray());
        animatorEnemy = new Animator(spriteSheet.getEnemySpriteArray());
        player = new Player(context, joystick, 0, 0, 100, animator);
        // Initialize display and center it around the player
        gameDisplay = new GameDisplay(displayMetrics.widthPixels, displayMetrics.heightPixels, player);
        // Initialize Tilemap
        tilemap = new Tilemap(new SpriteSheetMap(context,displayMetrics.widthPixels/2, displayMetrics.heightPixels/2));
        setFocusable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // Handle user input touch event actions
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                if(ingameMenu.isGamePauseClicked((double) event.getX(), (double) event.getY())){
                    ingameMenu.setIsPressed(!ingameMenu.isGamePaused());
                }else{
                    ingameMenu.setIsPressed(false);
                }
            case MotionEvent.ACTION_POINTER_DOWN:
                if (joystick.isPressed((double) event.getX(), (double) event.getY())) {
                    // Joystick is pressed in this event -> setIsPressed(true) and store pointer id
                    joystickPointerId = event.getPointerId(event.getActionIndex());
                    joystick.setIsPressed(true);
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if (joystick.getIsPressed()) {
                    // Joystick was pressed previously and is now moved
                    joystick.setActuator((double) event.getX(), (double) event.getY());
                }
                return true;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                if (joystickPointerId == event.getPointerId(event.getActionIndex())) {
                    // joystick pointer was let go off -> setIsPressed(false) and resetActuator()
                    joystick.setIsPressed(false);
                    joystick.resetActuator();
                }
                return true;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("Game.java", "surfaceCreated()");
        if (gameLoop.getState().equals(Thread.State.TERMINATED)) {
            SurfaceHolder surfaceHolder = getHolder();
            surfaceHolder.addCallback(this);
            gameLoop = new GameLoop(this, surfaceHolder);
        }
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d("Game.java", "surfaceChanged()");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("Game.java", "surfaceDestroyed()");
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        // Draw Tilemap
        tilemap.draw(canvas, gameDisplay);
        // Draw game objects
        player.draw(canvas, gameDisplay);
        for (Enemy enemy : enemyList) {
            enemy.draw(canvas, gameDisplay);
        }
        // Draw game panels
        joystick.draw(canvas);
        performance.draw(canvas);

        // Draw Game over if the player is dead
        if (player.getHealthPoint() <= 0) {
            gameOver.draw(canvas);
        }else{
            ingameMenu.draw(canvas,displayMetrics.widthPixels,displayMetrics.heightPixels);
        }
    }

    public void update() {
        // Stop updating the game if Pause Button is clicked
        if(ingameMenu.isGamePaused()){
            return;
        }
        // Stop updating the game if the player is dead
        if (player.getHealthPoint() <1) {
            return;
        }
        // Update game state
        joystick.update();
        player.update();
        // Spawn enemy
        if(Enemy.readyToSpawn()) {
            enemyList.add(new Enemy(getContext(), player,animatorEnemy,displayMetrics.widthPixels));
        }
        // Update states of all enemies
        for (Enemy enemy : enemyList) {
            enemy.update();
        }

        // Iterate through enemyList and Check for collision between each enemy and the player and
        // spells in spellList.
        Iterator<Enemy> iteratorEnemy = enemyList.iterator();
        while (iteratorEnemy.hasNext()) {
            Circle enemy = iteratorEnemy.next();
            if (Circle.isColliding(enemy, player)) {
                // Remove enemy if it collides with the player
                iteratorEnemy.remove();
                player.setHealthPoint(player.getHealthPoint() - 1);
                continue;
            }
            if(enemy.getPositionX()<-(displayMetrics.widthPixels+enemy.getRadius())){
                iteratorEnemy.remove();
            }
        }

        gameDisplay.update();
    }
    public void pause() {
        gameLoop.stopLoop();
    }
}
