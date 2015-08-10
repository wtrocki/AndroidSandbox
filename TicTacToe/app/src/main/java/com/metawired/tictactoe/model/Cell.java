package com.metawired.tictactoe.model;

/**
 * Class represents one of the cells on tic tac toe board
 */
public class Cell {

    private int value;
    private int index;
    private PlayerType owner;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PlayerType getOwner() {
        return owner;
    }

    public void setOwner(PlayerType owner) {
        this.owner = owner;
    }
}
