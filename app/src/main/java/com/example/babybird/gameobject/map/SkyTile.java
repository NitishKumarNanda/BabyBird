package com.example.babybird.gameobject.map;

import android.graphics.Canvas;
import android.graphics.Rect;

public class SkyTile extends Tile {
    private final SpriteMap spriteMap;
    private final SpriteMap cloudMap;

    public SkyTile(SpriteSheetMap spriteSheetMap, Rect mapLocationRect) {
        super(mapLocationRect);
        spriteMap = spriteSheetMap.getSkySprite();
        cloudMap = spriteSheetMap.getCloudSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        spriteMap.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        cloudMap.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
