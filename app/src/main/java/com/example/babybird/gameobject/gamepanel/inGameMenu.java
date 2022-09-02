package com.example.babybird.gameobject.gamepanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.babybird.R;

public class inGameMenu {
    private Context context;
    private boolean isPasued=false;

    public inGameMenu(Context context){
        this.context=context;
    }
    public void draw(Canvas canvas, int widthPixels, int heightPixels) {
        drawMenu(canvas,widthPixels,heightPixels);
    }
    public void drawMenu(Canvas canvas, int widthPixels, int heightPixels) {
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(100);
        if(isPasued){
            canvas.drawText("CLICK TO RESUME", (widthPixels/2)-500, heightPixels/2, paint);
        }
        else {
            canvas.drawText("| |", 50, 120, paint);
        }
    }

    public boolean isGamePaused() {
        return isPasued;
    }

    public boolean isGamePauseClicked(double x, double y) {
        return x<130 & y<150;
    }

    public void setIsPressed(boolean isPaused) {
        isPasued=isPaused;
    }
}
