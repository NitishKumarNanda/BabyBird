package com.example.babybird.gameobject.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;

import com.example.babybird.R;

public class SpriteSheetMap {
    private static final int SPRITE_WIDTH_PIXELS = 800;
    private static final int SPRITE_HEIGHT_PIXELS = 800;
    public int imgWidthPixels,imgHeightPixels;
    private Bitmap bitmap;

    public SpriteSheetMap(Context context, int imgWidthPixels, int imgHeightPixels) {
        this.imgWidthPixels=imgWidthPixels;
        this.imgHeightPixels=imgHeightPixels;
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        Bitmap originalBitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite_sheet_background, bitmapOptions);
        bitmap = Bitmap.createScaledBitmap(originalBitmap, imgHeightPixels*5, imgHeightPixels*5, false);
        System.out.print("Original Dimension : "+originalBitmap.getWidth()+"x"+originalBitmap.getHeight()+" Resized : "+bitmap.getWidth()+"x"+bitmap.getHeight());
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public SpriteMap getSkySprite() { return getSpriteByIndex(4, 4); }
    public SpriteMap getGroundSprite() {
        return getSpriteByIndex(4, 2);
    }
    public SpriteMap getGrassSprite() {
        return getSpriteByIndex(3, 0);
    }
    public SpriteMap getCloudSprite() {
        int cloudNumber= (int) (Math.random() * 10);
        if(cloudNumber>5){
            cloudNumber=10-cloudNumber;
        }
        return getSpriteByIndex(1, cloudNumber);
    }
    public SpriteMap getTreeSprite() {
        int treeNumber= (int) (Math.random() * 10);
        if(treeNumber>5){
            treeNumber=10-treeNumber;
        }
        return getSpriteByIndex(0, treeNumber);
    }

    private SpriteMap getSpriteByIndex(int idxRow, int idxCol) {
        return new SpriteMap(this, new Rect(
                idxCol*imgHeightPixels,
                idxRow*imgHeightPixels,
                (idxCol + 1)*imgHeightPixels,
                (idxRow + 1)*imgHeightPixels
        ));
        /*return new SpriteMap(this, new Rect(
                idxCol*SPRITE_WIDTH_PIXELS,
                idxRow*SPRITE_HEIGHT_PIXELS,
                (idxCol + 1)*SPRITE_WIDTH_PIXELS,
                (idxRow + 1)*SPRITE_HEIGHT_PIXELS
        ));*/
    }
}
