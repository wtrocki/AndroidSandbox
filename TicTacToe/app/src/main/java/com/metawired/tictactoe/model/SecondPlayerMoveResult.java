package com.metawired.tictactoe.model;

/**
 * Class used to represent moves done by algorithm or external player
 */
public class SecondPlayerMoveResult extends MoveResult{
    // Represents move for external player for new position.
    int playerMove;

    public SecondPlayerMoveResult(boolean gameFinished, PlayerType winningPlayer) {
        super(gameFinished, winningPlayer);
    }


    public int getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(int playerMove) {
        this.playerMove = playerMove;
    }

}
