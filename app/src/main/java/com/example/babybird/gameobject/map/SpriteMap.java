package com.example.babybird.gameobject.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class SpriteMap {
    private final SpriteSheetMap spriteSheetMap;
    private final Rect rect;
    public SpriteMap(SpriteSheetMap spriteSheetMap, Rect rect) {
        this.spriteSheetMap = spriteSheetMap;
        this.rect = rect;
    }
    public void draw(Canvas canvas, int x, int y) {
        canvas.drawBitmap(
                spriteSheetMap.getBitmap(),
                rect,
                new Rect(x, y, x+getWidth(), y+getHeight()),
                null
        );
        System.out.println(x+" : "+y+" : " + getWidth()+ " : "+getHeight() + " :  MapSheet");
    }

    public int getWidth() {
        return rect.width();
    }

    public int getHeight() {
        return rect.height();
    }
}
