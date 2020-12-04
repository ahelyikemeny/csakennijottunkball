package BallGameFolder;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class NehezButton extends OneSpriteStaticActor {
    public NehezButton(MyGame game) {
        super(game, "startgomb.png");
        setSize(30,30);
        setPosition(60,20);
    }
}
