package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class NehezStage extends Box2dStage {
    public NehezStage(MyGame game) {
        super(new ExtendViewport(150,90), game);
        addBackButtonScreenBackByStackPopListener();
        addActor(new InGameBackgroundActor(game));
        addActor(new GlobalWallActor(game, world, 0, 0, 3, 114));
        addActor(new GlobalWallActor(game, world, 3,0, 10, 3));
        addActor(new GlobalWallActor(game, world, 40, 0, 114, 3));
        addActor(new GlobalWallActor(game, world, 148, 0, 3, 114));
        addActor(new GlobalWallActor(game, world, 138,110, 10, 3));
        addActor(new GlobalWallActor(game, world, 0, 110, 114, 3));
        addActor(new GlobalWallActor(game, world, 45, 60, 60, 3));

    }
}
