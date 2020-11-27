package BallGameFolder;

import com.badlogic.gdx.scenes.scene2d.Actor;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WallActor extends OneSpriteStaticActor {
    BallMyGameStage1 firstStage;
    public WallActor(MyGame game, String hash, BallMyGameStage1 firstStage) {
        super(game, "badlogic.jpg");
        this.firstStage = firstStage;
this.setSize(10, 100);


    }

}
