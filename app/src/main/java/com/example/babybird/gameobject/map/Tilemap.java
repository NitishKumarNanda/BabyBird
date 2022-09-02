package com.example.babybird.gameobject.map;

import static com.example.babybird.gameobject.map.MapLayout.NUMBER_OF_COLUMN_TILES;
import static com.example.babybird.gameobject.map.MapLayout.NUMBER_OF_ROW_TILES;
import static com.example.babybird.gameobject.map.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.babybird.gameobject.map.MapLayout.TILE_WIDTH_PIXELS;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.babybird.gameobject.GameDisplay;


public class Tilemap {
    private final MapLayout mapLayout;
    private Tile[][] tilemap;
    private SpriteSheetMap spriteSheetMap;
    private Bitmap mapBitmap;
    public int tileHeightPixels,tileWidthPixels;

    public Tilemap(SpriteSheetMap spriteSheetMap) {
        mapLayout = new MapLayout();
        this.spriteSheetMap = spriteSheetMap;
        tileHeightPixels=spriteSheetMap.imgHeightPixels;
        tileWidthPixels=tileHeightPixels;
        initializeTilemap();
    }

    private void initializeTilemap() {
        int[][] layout = mapLayout.getLayout();
        tilemap = new Tile[NUMBER_OF_ROW_TILES][NUMBER_OF_COLUMN_TILES];
        for (int iRow = 0; iRow < NUMBER_OF_ROW_TILES; iRow++) {
            for (int iCol = 0; iCol < NUMBER_OF_COLUMN_TILES; iCol++) {
                tilemap[iRow][iCol] = Tile.getTile(
                        layout[iRow][iCol],
                        spriteSheetMap,
                        getRectByIndex(iRow, iCol)
                );
            }
        }

        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        mapBitmap = Bitmap.createBitmap(
                NUMBER_OF_COLUMN_TILES*spriteSheetMap.imgHeightPixels,
                NUMBER_OF_ROW_TILES*spriteSheetMap.imgHeightPixels,
                config
        );

        Canvas mapCanvas = new Canvas(mapBitmap);

        for (int iRow = 0; iRow < NUMBER_OF_ROW_TILES; iRow++) {
            for (int iCol = 0; iCol < NUMBER_OF_COLUMN_TILES; iCol++) {
                tilemap[iRow][iCol].draw(mapCanvas);
            }
        }
    }

    private Rect getRectByIndex(int idxRow, int idxCol) {
        return new Rect(
                idxCol*tileWidthPixels,
                idxRow*tileHeightPixels,
                (idxCol + 1)*tileWidthPixels,
                (idxRow + 1)*tileHeightPixels
        );
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        canvas.drawBitmap(
                mapBitmap,
                gameDisplay.getGameRect(),
                gameDisplay.DISPLAY_RECT,
                null
        );
    }
}
