package BallGameFolder;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class BallMyGame extends MyGame {
    @Override
    public void create() {
        super.create();
        debug = true;
        setScreen(new BallMyGameMenuScreen(this));
    }
}
