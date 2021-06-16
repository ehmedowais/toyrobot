package com.ows.modal;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void isPositionValid() {
        Position position = new Position(4,4);
        assertTrue(position.isPositionValid());
        position.setX(0);
        position.setY(0);
        assertTrue(position.isPositionValid());
        position.setX(0);
        position.setY(4);
        assertTrue(position.isPositionValid());
        position.setX(4);
        position.setY(0);
        assertTrue(position.isPositionValid());
    }
    @Test
    public void isPositionInvalid() {
        Position position = new Position(5,5);
        assertFalse(position.isPositionValid());
        position.setX(-1);
        position.setY(-1);
        assertFalse(position.isPositionValid());
        position.setX(10);
        position.setY(0);
        assertFalse(position.isPositionValid());
        position.setX(4);
        position.setY(5);
        assertFalse(position.isPositionValid());
    }
}