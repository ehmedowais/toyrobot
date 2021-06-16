package com.ows.exception;

public class RobotSimulatorException extends RuntimeException{
    String message;
    public RobotSimulatorException(String message) {
        super(message);
        this.message = message;
    }
}
