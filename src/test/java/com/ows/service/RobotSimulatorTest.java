package com.ows.service;

import com.ows.dto.GameDTO;
import com.ows.exception.RobotSimulatorException;
import com.ows.modal.Position;
import com.ows.modal.enums.CardinalDirection;
import com.ows.modal.enums.Command;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotSimulatorTest {

    @Test
    public void simulate() {
        RobotSimulator simulator = new RobotSimulator();
        String result = "";
        GameDTO dto = new GameDTO();
        dto.setCommand(Command.PLACE);
        dto.setDirection(CardinalDirection.NORTH);
        dto.setPosition(new Position(1,2));
        result = simulator.simulate(dto);
        assertEquals(result, "SUCCESS");
        dto.setCommand(Command.MOVE);
        result = simulator.simulate(dto);
        assertEquals(result, "SUCCESS");
        dto.setCommand(Command.REPORT);
        result = simulator.simulate(dto);
        assertEquals("1,3,NORTH", result);
        dto.setCommand(Command.LEFT);
        result = simulator.simulate(dto);
        dto.setCommand(Command.REPORT);
        result = simulator.simulate(dto);
        assertEquals("1,3,WEST", result);
        dto.setCommand(Command.MOVE);
        result = simulator.simulate(dto);
        dto.setCommand(Command.REPORT);
        result = simulator.simulate(dto);
        assertEquals("0,3,WEST", result);
    }
    @Test(expected = RobotSimulatorException.class)
    public void shouldThrowExceptionWhenRobotNotPlaced() {
        RobotSimulator simulator = new RobotSimulator();
        String result = "";
        GameDTO dto = new GameDTO();
        dto.setCommand(Command.MOVE);
        result = simulator.simulate(dto);
    }
    @Test(expected = RobotSimulatorException.class)
    public void shouldThrowExceptionIfPositionInvalidSouth() {
        RobotSimulator simulator = new RobotSimulator();
        String result = "";
        GameDTO dto = new GameDTO();
        dto.setCommand(Command.PLACE);
        dto.setDirection(CardinalDirection.SOUTH);
        dto.setPosition(new Position(0,0));
        result = simulator.simulate(dto);
        assertEquals(result, "SUCCESS");
        dto.setCommand(Command.MOVE);
        result = simulator.simulate(dto);


    }

    @Test(expected = RobotSimulatorException.class)
    public void shouldThrowExceptionIfPositionInvalidWest() {
        RobotSimulator simulator = new RobotSimulator();
        String result = "";
        GameDTO dto = new GameDTO();
        dto.setCommand(Command.PLACE);
        dto.setDirection(CardinalDirection.WEST);
        dto.setPosition(new Position(0,4));
        result = simulator.simulate(dto);
        assertEquals(result, "SUCCESS");
        dto.setCommand(Command.MOVE);
        result = simulator.simulate(dto);
        dto.setCommand(Command.REPORT);
        result = simulator.simulate(dto);
        System.out.println(result);
    }
    @Test(expected = RobotSimulatorException.class)
    public void shouldThrowExceptionIfPositionInvalidNorth() {
        RobotSimulator simulator = new RobotSimulator();
        String result = "";
        GameDTO dto = new GameDTO();
        dto.setCommand(Command.PLACE);
        dto.setDirection(CardinalDirection.NORTH);
        dto.setPosition(new Position(0,4));
        result = simulator.simulate(dto);
        assertEquals(result, "SUCCESS");
        dto.setCommand(Command.MOVE);
        result = simulator.simulate(dto);
        dto.setCommand(Command.REPORT);
        result = simulator.simulate(dto);

    }
}