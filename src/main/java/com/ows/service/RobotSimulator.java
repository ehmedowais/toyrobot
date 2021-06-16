package com.ows.service;


import com.ows.dto.GameDTO;
import com.ows.exception.RobotSimulatorException;
import com.ows.modal.Position;
import com.ows.modal.Robot;
import com.ows.modal.enums.CardinalDirection;
import com.ows.modal.enums.Command;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.ows.constants.ApplicationConstants.INVALID_POS_DIR;
import static com.ows.constants.ApplicationConstants.ROBOT_NOT_ON_TABLE;

public class RobotSimulator {

    private static Logger LOGGER = Logger.getLogger(RobotSimulator.class.getName());
    Robot robot = new Robot();
    private boolean isRobotPlacedOnTable = false;
    private void placeRobot(Position position, CardinalDirection direction) {
        if(position == null || direction == null || !position.isPositionValid()) {
            throw new RobotSimulatorException(INVALID_POS_DIR);

        }
        robot.setCurrentPosition(position);
        robot.setFacingTowards(direction);
        isRobotPlacedOnTable = true;
    }


    private String report() {
        if (robot.getCurrentPosition() == null)
            throw new RobotSimulatorException( ROBOT_NOT_ON_TABLE);
        if(robot.getFacingTowards() == null)
            throw new RobotSimulatorException( ROBOT_NOT_ON_TABLE);
        return robot.getCurrentPosition().getX() + "," + robot.getCurrentPosition().getY() + "," + robot.getFacingTowards().toString();
    }

    public String simulate(GameDTO dto) {
        Command command = dto.getCommand();
        String result = "";
        switch(command) {
            case PLACE:
                placeRobot(dto.getPosition(), dto.getDirection());
                result = "SUCCESS";
                break;
            case MOVE:
                moveRobot();
                result = "SUCCESS";
                break;
            case LEFT:
                turnRobot(Command.LEFT);
                result = "SUCCESS";
                break;
            case RIGHT:
                turnRobot(Command.RIGHT);
                result = "SUCCESS";
                break;
            case REPORT:
                result = report();
                break;
            default:
                throw new RobotSimulatorException("Invalid Command");
        }

        return result;
    }
    private void turnRobot(Command command) {
        if(!isRobotPlacedOnTable) {
            throw new RobotSimulatorException( ROBOT_NOT_ON_TABLE);

        }
        if (command.equals(Command.LEFT)) {
            robot.rotateLeft();
        } else {
            robot.rotateRight();
        }



    }
    private void moveRobot() {

        if(!isRobotPlacedOnTable) {
            throw new RobotSimulatorException(  ROBOT_NOT_ON_TABLE);

        }
        Position newPosition = robot.nextPosition();
        if(newPosition.isPositionValid()) {
            robot.move(newPosition);
        } else {
            throw new RobotSimulatorException( INVALID_POS_DIR);
        }

    }
}
