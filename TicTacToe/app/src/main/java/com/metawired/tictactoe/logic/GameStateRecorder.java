package com.metawired.tictactoe.logic;

import com.metawired.tictactoe.model.Cell;
import com.metawired.tictactoe.model.MoveResult;
import com.metawired.tictactoe.model.PlayerType;

/**
 * Responsible for checking if one of the players won or is draw
 */
public class GameStateRecorder implements IGameStateRecorder {

    // Required to check if user won
    private static int[] winningSumms;

    private static int TOTAL_NUMBER_OF_MOVES = 9;

    // Overall number of moves required to check if there are no other moves.
    private int numberOfMoves = 0;

    // Current turn (player)
    private PlayerType currentPlayer = PlayerType.X;

    static {
        winningSumms = new int[]{
                1 + 2 + 4,
                8 + 16 + 32,
                64 + 128 + 256,
                1 + 8 + 64,
                2 + 16 + 128,
                4 + 32 + 256,
                1 + 16 + 256,
                4 + 16 + 64
        };
    }

    public void GameStateStrategy() {
    }

    @Override
    public MoveResult processNextMove(Cell tag) {
        numberOfMoves++;
        int playerScoreAfterMove = currentPlayer.getScore() + tag.getValue();
        currentPlayer.setScore(playerScoreAfterMove);
        tag.setOwner(currentPlayer);
        currentPlayer = currentPlayer.next();

        if (isWinningMove(playerScoreAfterMove)) {
            resetObject();
            return new MoveResult(true, currentPlayer.next());
        }

        if (isDraw()) {
            resetObject();
            return MoveResult.DRAW;
        }
        return MoveResult.CONTINUE_GAME;
    }

    private void resetObject() {
        numberOfMoves = 0;
        PlayerType.X.setScore(0);
        PlayerType.O.setScore(0);

    }

    private boolean isDraw() {
        if (numberOfMoves == TOTAL_NUMBER_OF_MOVES) {
            return true;
        }
        return false;
    }

    public boolean isWinningMove(int score) {
        for (int i = 0; i < winningSumms.length; i++) {
            if ((score & winningSumms[i]) == winningSumms[i]) {
                return true;
            }
        }
        return false;
    }
}
