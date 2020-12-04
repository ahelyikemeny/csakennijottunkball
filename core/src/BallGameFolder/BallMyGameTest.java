package BallGameFolder;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class BallMyGameTest extends MyGame {
    @Override
    public void create() {
        super.create();
        setScreen(new KozepesScreen(this));
    }
}
