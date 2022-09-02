package com.example.babybird.gameobject.map;

import android.graphics.Canvas;
import android.graphics.Rect;

public class TreeTile extends Tile {
    //private final Sprite grassSprite;
    private final SpriteMap treeSpriteMap;
    private final SpriteMap skySprite;
    private final SpriteMap grassSprite;

    public TreeTile(SpriteSheetMap spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        skySprite = spriteSheet.getSkySprite();
        treeSpriteMap = spriteSheet.getTreeSprite();
        grassSprite = spriteSheet.getGrassSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        skySprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        treeSpriteMap.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        grassSprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
