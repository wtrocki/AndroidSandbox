package com.metawired.tictactoe.logic;

import com.metawired.tictactoe.model.Cell;
import com.metawired.tictactoe.model.MoveResult;
import com.metawired.tictactoe.model.PlayerType;
import com.metawired.tictactoe.model.SecondPlayerMoveResult;

/**
 * Manages game state for player vs computer style
 */
public class AiGameStateRecorder extends GameStateRecorder {

    private Integer[] currentMoves;

    public AiGameStateRecorder() {
        // User is always X
        this.currentPlayer = PlayerType.X;
        // We need this table for tracking progress outside ui
        this.currentMoves = new Integer[TOTAL_NUMBER_OF_MOVES];
    }

    @Override
    public MoveResult processNextMove(Cell tag) {
        MoveResult moveResult = super.processNextMove(tag);
        if(moveResult.isGameFinished()){
            return moveResult;
        }
        // Track user move
        currentMoves[tag.getIndex()] = this.currentPlayer.ordinal();
        SecondPlayerMoveResult secondPlayerMoveResult = new SecondPlayerMoveResult(false, null);
        int nextMove=calculateNextMove();
        secondPlayerMoveResult.setPlayerMove(nextMove);
        return secondPlayerMoveResult;
    }

    private int calculateNextMove() {
        for(int i=0;i<currentMoves.length;i++){
            if(currentMoves[i]==null){
                return i;
            }
        }
        throw new IllegalStateException("Cannot process move. Problem with algorithm");
    }

}
