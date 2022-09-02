package com.example.babybird.gameobject.map;

import android.graphics.Canvas;
import android.graphics.Rect;

public class GroundTile extends Tile {
    private final SpriteMap spriteMap;

    public GroundTile(SpriteSheetMap spriteSheetMap, Rect mapLocationRect) {
        super(mapLocationRect);
        spriteMap = spriteSheetMap.getGroundSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        spriteMap.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}

