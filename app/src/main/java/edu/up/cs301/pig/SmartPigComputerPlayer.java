package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by chunm18 on 10/14/2015.
 */
public class SmartPigComputerPlayer extends GameComputerPlayer {
    /**
     * ctor does nothing extra
     */
    public SmartPigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        int temp = (int) (Math.random() * 4);

        if (temp == 0) {
            PigHoldAction hold = new PigHoldAction(this);
            game.sendAction(hold);

        } else {
            PigRollAction roll = new PigRollAction(this);
            game.sendAction(roll);
        }

    }//receiveInfo
}
