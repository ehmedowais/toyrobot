package com.ows.modal.enums;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardinalDirectionTest {

    @Test
    public void testRotateLeft() {
        CardinalDirection direction = CardinalDirection.EAST;
        direction = direction.rotateLeft();
        Assert.assertEquals(direction, CardinalDirection.NORTH);

        direction = direction.rotateLeft();
        Assert.assertEquals(direction, CardinalDirection.WEST);

        direction = direction.rotateLeft();
        Assert.assertEquals(direction, CardinalDirection.SOUTH);

        direction = direction.rotateLeft();
        Assert.assertEquals(direction, CardinalDirection.EAST);
    }

    @Test
    public void testRotateRight() {
        CardinalDirection direction = CardinalDirection.EAST;
        direction = direction.rotateRight();
        Assert.assertEquals(direction, CardinalDirection.SOUTH);

        direction = direction.rotateRight();
        Assert.assertEquals(direction, CardinalDirection.WEST);

        direction = direction.rotateRight();
        Assert.assertEquals(direction, CardinalDirection.NORTH);

        direction = direction.rotateRight();
        Assert.assertEquals(direction, CardinalDirection.EAST);
    }
}