package com.ows.modal;

import static com.ows.constants.ApplicationConstants.MAX_COLS;
import static com.ows.constants.ApplicationConstants.MAX_ROWS;

public class Position {
    private int x;
    private int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPositionValid() {
        if(this.x < 0 || this.x > MAX_COLS) {
            return false;
        }
        if(this.y < 0 || this.y > MAX_ROWS ) {
            return false;
        }
        return true;
    }
}
