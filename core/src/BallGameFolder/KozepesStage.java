package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class KozepesStage extends Box2dStage {
    public KozepesStage(MyGame game) {
        super(new ExtendViewport(150,90), game);
        addActor(new BallActor(game, world, 70,40));
        addActor(new GlobalWallActor(game, world, 0, 0, 3, 114));
        addActor(new GlobalWallActor(game, world, 3,0, 10, 3));
        addActor(new GlobalWallActor(game, world, 40, 0, 114, 3));
        addActor(new GlobalWallActor(game, world, 148, 0, 3, 114));
        addActor(new GlobalWallActor(game, world, 138,110, 10, 3));
        addActor(new GlobalWallActor(game, world, 0, 110, 114, 3));
        addActor(new GlobalWallActor(game, world, 45, 60, 60, 3));

    }
}
