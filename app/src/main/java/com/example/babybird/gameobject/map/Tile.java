package com.example.babybird.gameobject.map;

import android.graphics.Canvas;
import android.graphics.Rect;

public abstract class Tile {
    protected final Rect mapLocationRect;

    public Tile(Rect mapLocationRect) {
        this.mapLocationRect = mapLocationRect;
    }

    public enum TileType {
        SKY_TILE,
        GROUND_TILE,
        GRASS_TILE,
        TREE_TILE,
    }

    public static Tile getTile(int idxTileType, SpriteSheetMap spriteSheet, Rect mapLocationRect) {

        switch(TileType.values()[idxTileType]) {
            case SKY_TILE:
                return new SkyTile(spriteSheet, mapLocationRect);
            case GROUND_TILE:
                return new GroundTile(spriteSheet, mapLocationRect);
            case GRASS_TILE:
                return new GrassTile(spriteSheet, mapLocationRect);
            case TREE_TILE:
                return new TreeTile(spriteSheet, mapLocationRect);
            default:
                return null;
        }

    }

    public abstract void draw(Canvas canvas);
}
