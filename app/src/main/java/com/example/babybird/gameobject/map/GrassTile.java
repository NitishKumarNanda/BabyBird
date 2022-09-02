package com.example.babybird.gameobject.map;

import android.graphics.Canvas;
import android.graphics.Rect;

public class GrassTile extends Tile {
    private final SpriteMap spriteMap;

    public GrassTile(SpriteSheetMap spriteSheetMap, Rect mapLocationRect) {
        super(mapLocationRect);
        spriteMap = spriteSheetMap.getGrassSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        spriteMap.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
