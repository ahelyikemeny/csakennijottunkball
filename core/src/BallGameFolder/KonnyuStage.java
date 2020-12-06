package BallGameFolder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class KonnyuStage extends Box2dStage {


    public KonnyuStage(MyGame game) {
        super(new ExtendViewport(160, 90), game);
        addActor(new InGameBackgroundActor(game));
        addActor(new GlobalWallActor(game, world, 0, 0, 50, 50));
        getWorld().setGravity(new Vector2(0,0));
        setTimeMultiply(3);
        //getWorld().;

    }


}
