package com.metawired.tictactoe.model;

import com.metawired.tictactoe.R;

/**
 * Represents player. Using predefined players X and Y.
 */
public enum PlayerType {

    X(R.drawable.abc_btn_check_material),
    O(R.drawable.abc_btn_radio_material);

    private int imageRes;
    private int score=0;

    PlayerType(int imageRes){
        this.imageRes = imageRes;
    }

    public PlayerType next() {
        if(this.equals(X)){
            return O;
        }
        return X;
    }

    public int getImageRes() {
        return imageRes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}