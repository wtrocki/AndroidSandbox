package com.metawired.tictactoe.logic;

import com.metawired.tictactoe.model.Cell;
import com.metawired.tictactoe.model.MoveResult;

/**
 * Interface for game logic.
 * Can have different  implementation depending on game type.
 */
public interface IGameStateRecorder {

    /**
     * Process next player move (should perform all game logic behing)
     * Implementers should return result object to calculate new gui state.
     *
     * @param tag - tic tac toe cell
     *
     * @return result of move
     */
    MoveResult processNextMove(Cell tag);
}
