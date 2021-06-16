package com.ows.dto;

import com.ows.exception.RobotSimulatorException;
import com.ows.modal.Position;
import com.ows.modal.enums.CardinalDirection;
import com.ows.modal.enums.Command;

import static com.ows.constants.ApplicationConstants.INVALID_POS_DIR;

public class GameDTO {


    private Position position;
    private CardinalDirection direction;
    private Command command;
    public GameDTO(){}
    public GameDTO(Position position, CardinalDirection direction, Command command) {
        this.position = position;
        this.direction = direction;
        this.command = command;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public CardinalDirection getDirection() {
        return direction;
    }

    public void setDirection(CardinalDirection direction) {
        this.direction = direction;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
    public void setPositionAndDirectionForPlaceCommand(String str) {
        String[] strings = str.split(",");
        Position newPosition;
        if(strings.length < 3) {
            throw new RobotSimulatorException("Invalid Number of arguments");
        }
        try {
            newPosition = new Position(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));

        }catch (NumberFormatException ex) {
            throw new RobotSimulatorException(ex.getMessage());
        }
        if(!newPosition.isPositionValid()) {
            throw new RobotSimulatorException(INVALID_POS_DIR);
        }
        this.setPosition(newPosition);
        this.setDirection(CardinalDirection.valueOf(strings[2]));

    }
}
