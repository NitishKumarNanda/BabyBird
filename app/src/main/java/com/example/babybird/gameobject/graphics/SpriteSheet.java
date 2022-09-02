package com.example.babybird.gameobject.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.babybird.R;

public class SpriteSheet {private static final int SPRITE_WIDTH_PIXELS = 200;
    private static final int SPRITE_HEIGHT_PIXELS = 200;
    private Bitmap bitmap;

    public SpriteSheet(Context context) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite_sheet, bitmapOptions);
    }

    public Sprite[] getPlayerSpriteArray() {
        Sprite[] spriteArray = new Sprite[18];
        spriteArray[0]=new Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS,0,1*SPRITE_WIDTH_PIXELS,200));
        spriteArray[1]=new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS,0,2*SPRITE_WIDTH_PIXELS,200));
        spriteArray[2]=new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS,0,3*SPRITE_WIDTH_PIXELS,200));
        spriteArray[3]=new Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS,0,4*SPRITE_WIDTH_PIXELS,200));
        spriteArray[4]=new Sprite(this, new Rect(4*SPRITE_WIDTH_PIXELS,0,5*SPRITE_WIDTH_PIXELS,200));
        spriteArray[5]=new Sprite(this, new Rect(5*SPRITE_WIDTH_PIXELS,0,6*SPRITE_WIDTH_PIXELS,200));
        spriteArray[6]=new Sprite(this, new Rect(6*SPRITE_WIDTH_PIXELS,0,7*SPRITE_WIDTH_PIXELS,200));
        spriteArray[7]=new Sprite(this, new Rect(7*SPRITE_WIDTH_PIXELS,0,8*SPRITE_WIDTH_PIXELS,200));
        spriteArray[8]=new Sprite(this, new Rect(8*SPRITE_WIDTH_PIXELS,0,9*SPRITE_WIDTH_PIXELS,200));
        spriteArray[9]=new Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS,200,1*SPRITE_WIDTH_PIXELS,400));
        spriteArray[10]=new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS,200,2*SPRITE_WIDTH_PIXELS,400));
        spriteArray[11]=new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS,200,3*SPRITE_WIDTH_PIXELS,400));
        spriteArray[12]=new Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS,200,4*SPRITE_WIDTH_PIXELS,400));
        spriteArray[13]=new Sprite(this, new Rect(4*SPRITE_WIDTH_PIXELS,200,5*SPRITE_WIDTH_PIXELS,400));
        spriteArray[14]=new Sprite(this, new Rect(5*SPRITE_WIDTH_PIXELS,200,6*SPRITE_WIDTH_PIXELS,400));
        spriteArray[15]=new Sprite(this, new Rect(6*SPRITE_WIDTH_PIXELS,200,7*SPRITE_WIDTH_PIXELS,400));
        spriteArray[16]=new Sprite(this, new Rect(7*SPRITE_WIDTH_PIXELS,200,8*SPRITE_WIDTH_PIXELS,400));
        spriteArray[17]=new Sprite(this, new Rect(8*SPRITE_WIDTH_PIXELS,200,9*SPRITE_WIDTH_PIXELS,400));
        return spriteArray;
    }
    public Sprite[] getEnemySpriteArray() {
        Sprite[] spriteArray = new Sprite[10];
/*        spriteArray[0]=new Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS,400,1*SPRITE_WIDTH_PIXELS,600));
        spriteArray[1]=new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS,400,2*SPRITE_WIDTH_PIXELS,600));
        spriteArray[2]=new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS,400,3*SPRITE_WIDTH_PIXELS,600));
        spriteArray[3]=new Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS,400,3*SPRITE_WIDTH_PIXELS,600));
        spriteArray[4]=new Sprite(this, new Rect(4*SPRITE_WIDTH_PIXELS,400,4*SPRITE_WIDTH_PIXELS,600));
        spriteArray[5]=new Sprite(this, new Rect(5*SPRITE_WIDTH_PIXELS,400,5*SPRITE_WIDTH_PIXELS,600));
        spriteArray[6]=new Sprite(this, new Rect(6*SPRITE_WIDTH_PIXELS,400,6*SPRITE_WIDTH_PIXELS,600));
        spriteArray[7]=new Sprite(this, new Rect(7*SPRITE_WIDTH_PIXELS,400,7*SPRITE_WIDTH_PIXELS,600));
        spriteArray[8]=new Sprite(this, new Rect(8*SPRITE_WIDTH_PIXELS,400,8*SPRITE_WIDTH_PIXELS,600));
        spriteArray[9]=new Sprite(this, new Rect(9*SPRITE_WIDTH_PIXELS,400,9*SPRITE_WIDTH_PIXELS,600));
        spriteArray[10]=new Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS,600,1*SPRITE_WIDTH_PIXELS,800));
        spriteArray[11]=new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS,600,2*SPRITE_WIDTH_PIXELS,800));
        spriteArray[12]=new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS,600,3*SPRITE_WIDTH_PIXELS,800));
        spriteArray[13]=new Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS,600,3*SPRITE_WIDTH_PIXELS,800));
        spriteArray[14]=new Sprite(this, new Rect(4*SPRITE_WIDTH_PIXELS,600,4*SPRITE_WIDTH_PIXELS,800));
        spriteArray[15]=new Sprite(this, new Rect(5*SPRITE_WIDTH_PIXELS,600,5*SPRITE_WIDTH_PIXELS,800));
        spriteArray[16]=new Sprite(this, new Rect(6*SPRITE_WIDTH_PIXELS,600,6*SPRITE_WIDTH_PIXELS,800));
        spriteArray[17]=new Sprite(this, new Rect(7*SPRITE_WIDTH_PIXELS,600,7*SPRITE_WIDTH_PIXELS,800));
        spriteArray[18]=new Sprite(this, new Rect(8*SPRITE_WIDTH_PIXELS,600,8*SPRITE_WIDTH_PIXELS,800));
        spriteArray[19]=new Sprite(this, new Rect(9*SPRITE_WIDTH_PIXELS,600,9*SPRITE_WIDTH_PIXELS,800));*/
        spriteArray[0]=new Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS,600,1*SPRITE_WIDTH_PIXELS,800));
        spriteArray[1]=new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS,600,2*SPRITE_WIDTH_PIXELS,800));
        spriteArray[2]=new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS,600,3*SPRITE_WIDTH_PIXELS,800));
        spriteArray[3]=new Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS,600,4*SPRITE_WIDTH_PIXELS,800));
        spriteArray[4]=new Sprite(this, new Rect(4*SPRITE_WIDTH_PIXELS,600,5*SPRITE_WIDTH_PIXELS,800));
        spriteArray[5]=new Sprite(this, new Rect(5*SPRITE_WIDTH_PIXELS,600,6*SPRITE_WIDTH_PIXELS,800));
        spriteArray[6]=new Sprite(this, new Rect(6*SPRITE_WIDTH_PIXELS,600,7*SPRITE_WIDTH_PIXELS,800));
        spriteArray[7]=new Sprite(this, new Rect(7*SPRITE_WIDTH_PIXELS,600,8*SPRITE_WIDTH_PIXELS,800));
        spriteArray[8]=new Sprite(this, new Rect(8*SPRITE_WIDTH_PIXELS,600,9*SPRITE_WIDTH_PIXELS,800));
        spriteArray[9]=new Sprite(this, new Rect(9*SPRITE_WIDTH_PIXELS,600,10*SPRITE_WIDTH_PIXELS,800));
        return spriteArray;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
