package com.metawired.tictactoe.activity;

import android.widget.ImageView;

import com.metawired.tictactoe.logic.AiGameStateRecorder;
import com.metawired.tictactoe.logic.GameStateRecorder;
import com.metawired.tictactoe.model.Cell;
import com.metawired.tictactoe.model.MoveResult;
import com.metawired.tictactoe.model.SecondPlayerMoveResult;

/**
 * Dedicated for player vs computer playing style
 */
public class AiGameActivity extends GameActivity {

    @Override
    protected GameStateRecorder createRecorder() {
        return new AiGameStateRecorder();
    }

    protected void handleExternalMove(MoveResult result) {
        if (result instanceof SecondPlayerMoveResult) {
            int playerMove = ((SecondPlayerMoveResult) result).getPlayerMove();
            if (playerMove >= 0 && playerMove < GameStateRecorder.TOTAL_NUMBER_OF_MOVES) {
                ImageView selectedView = applicationViews[playerMove];
                handleResult(selectedView, (Cell) selectedView.getTag());
            }
        }
    }

    protected void handleResultInSubclasses(MoveResult result, ImageView v, Cell tag) {

    }
}
