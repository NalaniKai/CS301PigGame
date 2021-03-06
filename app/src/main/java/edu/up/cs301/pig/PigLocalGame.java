package edu.up.cs301.pig;

import edu.up.cs301.game.GameHumanPlayer;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigLocalGame extends LocalGame {

    PigGameState pigGameState;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        pigGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    public boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        return pigGameState.getID() == playerIdx;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    public boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if( canMove(getPlayerIdx(action.getPlayer())) ){
           if( action instanceof PigHoldAction ) {
               pigGameState.onHold();
           }
           else {
               pigGameState.onRoll();
           }
            return true; //make move
        }

        return false;

    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState copyState = new PigGameState(pigGameState);
        p.sendInfo(copyState);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    public String checkIfGameOver() {
        //TODO  You will implement this method
        if(pigGameState.getScore1() >= 50) {
            return "Player 1 wins";
        }
        else if(pigGameState.getScore2() >= 50) {
            return "Player 2 wins";
        }

        return null;
    }

}// class PigLocalGame
