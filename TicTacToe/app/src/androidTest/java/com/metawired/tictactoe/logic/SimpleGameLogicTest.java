package com.metawired.tictactoe.logic;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 */
public class SimpleGameLogicTest {

    private GameStateRecorder recorder;

    @Before
    void init() {
        recorder = new GameStateRecorder();
    }

    @Test
    void testWinningLogic() {
        Assert.assertTrue(recorder.isWinningMove(1 + 2 + 4));
        Assert.assertTrue(recorder.isWinningMove(8 + 16 + 32));
        Assert.assertTrue(recorder.isWinningMove(64 + 128 + 256));
        Assert.assertTrue(recorder.isWinningMove(1 + 8 + 64));
        Assert.assertTrue(recorder.isWinningMove(2 + 16 + 128));
        Assert.assertTrue(recorder.isWinningMove(4 + 32 + 256));
        Assert.assertTrue(recorder.isWinningMove(1 + 16 + 256));
        Assert.assertTrue(recorder.isWinningMove(4 + 16 + 64));
    }

}
