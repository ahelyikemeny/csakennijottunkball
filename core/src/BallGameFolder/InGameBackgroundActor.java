package BallGameFolder;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class InGameBackgroundActor extends OneSpriteStaticActor {
    public InGameBackgroundActor(MyGame game) {
        super(game, "IngameBackground.png");
        this.setSize(160,120);
        this.setPosition(0,0);
    }
}
