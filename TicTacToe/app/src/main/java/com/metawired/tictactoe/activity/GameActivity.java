package com.metawired.tictactoe.activity;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.metawired.tictactoe.R;
import com.metawired.tictactoe.logic.GameStateRecorder;
import com.metawired.tictactoe.logic.IGameStateRecorder;
import com.metawired.tictactoe.model.Cell;
import com.metawired.tictactoe.model.MoveResult;

public class GameActivity extends AppCompatActivity {

    protected ImageView[] applicationViews;
    private Handler asyncHandler = new Handler();
    private IGameStateRecorder recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        recorder = createRecorder();
        buildGameViews();
        setupMetadataForViews();
    }

    protected GameStateRecorder createRecorder() {
        return new GameStateRecorder();
    }

    private void setupMetadataForViews() {
        for (int i = 0; i < applicationViews.length; i++) {
            resetCellForIndex(i);
            applicationViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cell tag = (Cell) v.getTag();
                    if (tag.getOwner() == null) {
                        handleOnClick((ImageView) v, tag);
                    }
                }
            });
        }
    }

    private void buildGameViews() {
        applicationViews = new ImageView[9];
        applicationViews[0] = (ImageView) this.findViewById(R.id.imageView);
        applicationViews[1] = (ImageView) this.findViewById(R.id.imageView2);
        applicationViews[2] = (ImageView) this.findViewById(R.id.imageView3);
        applicationViews[3] = (ImageView) this.findViewById(R.id.imageView4);
        applicationViews[4] = (ImageView) this.findViewById(R.id.imageView5);
        applicationViews[5] = (ImageView) this.findViewById(R.id.imageView6);
        applicationViews[6] = (ImageView) this.findViewById(R.id.imageView7);
        applicationViews[7] = (ImageView) this.findViewById(R.id.imageView8);
        applicationViews[8] = (ImageView) this.findViewById(R.id.imageView9);
    }

    private void resetCellForIndex(int i) {
        Cell cell = new Cell();
        cell.setIndex(i);
        cell.setOwner(null);
        cell.setValue((int) Math.pow(2, i));
        applicationViews[i].setTag(cell);
    }

    private void handleOnClick(ImageView v, Cell tag) {
        MoveResult moveResult = handleResult(v, tag);
        handleExternalMove(moveResult);
    }

    protected MoveResult handleResult(ImageView v, Cell tag) {
        MoveResult result = recorder.processNextMove(tag);
        v.setImageDrawable(getImageForPlayer(tag));
        if (result.isGameFinished()) {
            if (result.getWinningPlayer() == null) {
                showResultDialog(getString(R.string.win_dialog_draw));
            } else {
                String message = result.getWinningPlayer().name() + getString(R.string.win_dialog_player_won);
                showResultDialog(message);
                clearFields();
            }
        }
        return result;
    }

    protected void handleExternalMove(MoveResult tag) {
    }

    void showResultDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton(getString(R.string.win_dialog_ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //
                    }
                });
        AlertDialog dialog = builder.create();
        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
        wmlp.gravity = Gravity.TOP | Gravity.LEFT;
        wmlp.x = 100;
        wmlp.y = 100;

        dialog.show();
    }

    private Drawable getImageForPlayer(Cell tag) {
        return getResources().getDrawable(tag.getOwner().getImageRes());
    }

    private void clearFields() {
        // Running async code for flushing gui. Prevent form blinking
        asyncHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < applicationViews.length; i++) {
                    applicationViews[i].setImageDrawable(null);
                    resetCellForIndex(i);
                }
            }
        }, 2000);
    }

}
