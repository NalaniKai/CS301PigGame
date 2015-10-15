package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by chunm18 on 10/14/2015.
 */
public class PigGameState extends GameState {

    int playerID;
    int score1;
    int score2;
    int runningScore;
    int dieValue;
    PigGameState pigGameState1;

    public PigGameState() {
        score1 = 0;
        score2 = 0;
        runningScore = 0;
        dieValue = 1;
        playerID = 1;
    }

    public PigGameState(PigGameState pigGameState) {
        score1 = pigGameState.getScore1();
        score2 = pigGameState.getScore2();
        runningScore = pigGameState.getRunningScore();
        dieValue = pigGameState.getDieValue();
        playerID = pigGameState.getID();

        pigGameState1 = pigGameState;
    }

    public int getID() { return playerID; }
    public int getScore1() { return score1; }
    public int getScore2() { return score2; }
    public int getRunningScore() { return runningScore; }
    public int getDieValue() { return dieValue; }

    public void onHold() {
        if(playerID == 0) {
            score1 += runningScore;
            runningScore = 0;
            playerID = 1;
        }
        else if(playerID == 1) {
            score2 += runningScore;
            runningScore = 0;
            playerID = 0;
        }
    }

    public void onRoll() {
        dieValue = (int) (Math.random() * 6)+ 1;

        if (dieValue == 1) {

            runningScore = 0;

            if (playerID == 0) {
                playerID = 1;
            }
            else if (playerID == 1) {
                playerID = 0;
            }
        } else {
            runningScore += dieValue;
        }

    }
}
