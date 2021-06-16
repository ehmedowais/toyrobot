package com.ows.modal;

import com.ows.modal.enums.CardinalDirection;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {
    Robot robot;

    @Before
    public void setup() {
        robot = new Robot(new Position(2,2), CardinalDirection.NORTH);
    }
    @Test
    public void nextPosition() {
        Position position = robot.nextPosition();
        assertEquals(position.getY(), 3);
        robot.setFacingTowards(CardinalDirection.WEST);
        position = robot.nextPosition();
        assertEquals(position.getX(), 1);
    }

    @Test
    public void rotateLeft() {
        robot.rotateLeft();
        assertEquals(robot.getFacingTowards(),CardinalDirection.WEST);
        robot.rotateLeft();
        assertEquals(robot.getFacingTowards(),CardinalDirection.SOUTH);
        robot.rotateLeft();
        assertEquals(robot.getFacingTowards(),CardinalDirection.EAST);
        robot.rotateLeft();
        assertEquals(robot.getFacingTowards(),CardinalDirection.NORTH);
    }

    @Test
    public void rotateRight() {
        robot.rotateRight();
        assertEquals(robot.getFacingTowards(),CardinalDirection.EAST);
        robot.rotateRight();
        assertEquals(robot.getFacingTowards(),CardinalDirection.SOUTH);
        robot.rotateRight();
        assertEquals(robot.getFacingTowards(),CardinalDirection.WEST);
        robot.rotateRight();
        assertEquals(robot.getFacingTowards(),CardinalDirection.NORTH);
    }
}