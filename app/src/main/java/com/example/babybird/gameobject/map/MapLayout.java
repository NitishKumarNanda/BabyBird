package com.example.babybird.gameobject.map;

public class MapLayout {
    public static final int TILE_WIDTH_PIXELS = 800;
    public static final int TILE_HEIGHT_PIXELS = 800;
    public static final int NUMBER_OF_ROW_TILES = 2;
    public static final int NUMBER_OF_COLUMN_TILES = 200;

    private int[][] layout;

    public MapLayout() {
        initializeLayout();
    }

    public int[][] getLayout() {
        return layout;
    }

    private void initializeLayout() {
        layout = new int[NUMBER_OF_ROW_TILES][NUMBER_OF_COLUMN_TILES];
        for (int iCol = 0; iCol < NUMBER_OF_COLUMN_TILES; iCol++) {
            layout[0][iCol]=0;
            layout[1][iCol]=3;
        }
    }
}
