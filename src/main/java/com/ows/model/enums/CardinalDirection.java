package com.ows.modal.enums;

import com.ows.constants.ApplicationConstants;

public enum CardinalDirection {

    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private int cardinalIndex;
    private final static int MAX_DIRECTIONS = CardinalDirection.values().length;
    CardinalDirection(int index) {
        cardinalIndex = index;
    }

    public CardinalDirection rotateLeft() {
        return rotate(ApplicationConstants.GO_BACK);
    }
    public CardinalDirection rotateRight() {
        return rotate(ApplicationConstants.GO_FORWARD);
    }
    private CardinalDirection rotate(int rotation) {
        int newCardinalPos = (cardinalIndex + rotation) < 0 ? MAX_DIRECTIONS -1 : (cardinalIndex + rotation) % MAX_DIRECTIONS;
        return CardinalDirection.values()[newCardinalPos];
    }
}
