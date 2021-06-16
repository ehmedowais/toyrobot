package com.ows.modal;

import com.ows.modal.enums.CardinalDirection;

public class Robot {

    private Position currentPosition;
    private CardinalDirection facingTowards;
    public Robot(){}
    public Robot(Position newPosition, CardinalDirection direction) {
        currentPosition = newPosition;
        facingTowards = direction;
    }
    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
    public Position getCurrentPosition() {
        return currentPosition;
    }
    public void setFacingTowards(CardinalDirection direction) {
        facingTowards = direction;
    }
    public CardinalDirection getFacingTowards() {
        return this.facingTowards;
    }
    public boolean moveToNextPosition() {
        return move(nextPosition());
    }
    public boolean move(Position newPosition) {
        if(newPosition == null) {
            return false;
        }
        this.currentPosition = newPosition;
        return true;
    }
    public Position nextPosition() {
        Position position = new Position(currentPosition);
        switch (this.facingTowards) {
            case NORTH:
                position.setY(position.getY()+1);
                break;
            case EAST:
                position.setX(position.getX()+1);
                break;
            case SOUTH:
                position.setY(position.getY() -1);
                break;
            case WEST:
                position.setX(position.getX() -1);
        }
        return position;
    }
    public void rotateLeft() {
        facingTowards = facingTowards.rotateLeft();

    }
    public void rotateRight() {
        facingTowards = facingTowards.rotateRight();

    }
}
