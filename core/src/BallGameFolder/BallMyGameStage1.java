package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class BallMyGameStage1 extends Box2dStage {

    WallActor wallActor;

    public BallMyGameStage1 (MyGame game) {
        super(new ExtendViewport(60, 480 ), game);
        addActor(new WallActor(game, world, this, 0, 0));







    }







}
