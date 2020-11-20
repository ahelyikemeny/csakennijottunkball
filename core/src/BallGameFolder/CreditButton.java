package BallGameFolder;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class CreditButton extends OneSpriteStaticActor {
    public CreditButton(MyGame game) {
        super(game, "badlogic.jpg");
        setSize(30,30);
    }
}
