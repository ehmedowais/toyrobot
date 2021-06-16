package com.ows.dto;

import com.ows.exception.RobotSimulatorException;
import com.ows.modal.enums.CardinalDirection;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameDTOTest {

    @Test
    public void setPositionAndDirectionForPlaceCommand() {
        GameDTO dto = new GameDTO();
        dto.setPositionAndDirectionForPlaceCommand("1,2,NORTH");
        assertEquals(dto.getDirection(),CardinalDirection.NORTH);
        assertEquals(dto.getPosition().getX(), 1);
        assertEquals(dto.getPosition().getY(), 2);
    }

    @Test(expected = RobotSimulatorException.class)
    public void setPositionAndDirectionForPlaceCommandShouldThrowExceptionForInvalidPlacement() {
        GameDTO dto = new GameDTO();
        dto.setPositionAndDirectionForPlaceCommand("NORTH, 0,0");

    }
    @Test(expected = RobotSimulatorException.class)
    public void setPositionAndDirectionForPlaceCommandShouldThrowExceptionForInvalidNumbers() {
        GameDTO dto = new GameDTO();
        dto.setPositionAndDirectionForPlaceCommand("10,10,NORTH");

    }
    @Test(expected = RobotSimulatorException.class)
    public void setPositionAndDirectionForPlaceCommandShouldThrowExceptionForInvalidArgs() {
        GameDTO dto = new GameDTO();
        dto.setPositionAndDirectionForPlaceCommand("0,0");

    }
    @Test(expected = RobotSimulatorException.class)
    public void setPositionAndDirectionForPlaceCommandShouldThrowExceptionForEmptyArgs() {
        GameDTO dto = new GameDTO();
        dto.setPositionAndDirectionForPlaceCommand(" ");

    }
}