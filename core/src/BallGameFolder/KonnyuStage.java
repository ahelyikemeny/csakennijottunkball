package BallGameFolder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class KonnyuStage extends Box2dStage {

    WallActor wallActor;

    public KonnyuStage(MyGame game) {
        super(new ExtendViewport(60, 480), game);
        addActor(new WallActor(game, world, this, 0, 0));
        addActor(new WallActor1(game, world, this, 0, 0));
        addActor(new WallActor2(game, world, this, 0, 0));
        addActor(new WallActorSmall(game, world, this, 0, 0));
        addActor(new WallActorSmall1(game, world, this, 0, 0));
        addActor(new BallActor(game, world, 280, 200));
        getWorld().setGravity(new Vector2(0,0));
        setTimeMultiply(3);
        //getWorld().;

    }


}