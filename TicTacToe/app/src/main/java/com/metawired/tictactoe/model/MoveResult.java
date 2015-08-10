package com.metawired.tictactoe.model;

/**
 * Contains result of the move that can possibly finish the game.
 */
public class MoveResult {

    public static MoveResult CONTINUE_GAME = new MoveResult(false, null);
    public static MoveResult DRAW = new MoveResult(true, null);

    private final boolean gameFinished;
    private final PlayerType winningPlayer;

    public MoveResult(boolean gameFinished, PlayerType winningPlayer) {
        this.gameFinished = gameFinished;
        this.winningPlayer = winningPlayer;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public PlayerType getWinningPlayer() {
        return winningPlayer;
    }
}
