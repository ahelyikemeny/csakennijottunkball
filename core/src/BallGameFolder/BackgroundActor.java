package BallGameFolder;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BackgroundActor extends OneSpriteStaticActor {
    public BackgroundActor(MyGame game, float x, float y) {
        super(game, "MenuBackground.png");
        this.setPosition(x,y);
        this.setSize(160,120);
    }
}
