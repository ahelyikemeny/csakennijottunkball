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
        //fent
        for(int i = 0; i<=110; i = i + 10){
            addActor(new GlobalWallActor(game, world, i, 115, 10, 5));
        }


        //bal
        for(int i = 5; i<=113; i = i + 3){
            addActor(new GlobalWallActor(game, world, 0, i, 6, 3));

            //jobb
        }
        for(int i = 5; i<=120; i = i + 3){
            addActor(new GlobalWallActor(game, world, 154, i, 6, 3));
        }

        //lentbal
        for(int i = 0; i<=10; i = i + 10){
            addActor(new GlobalWallActor(game, world, i, 0, 10, 5));
        }

        //lentjobb
        addActor(new GlobalWallActor(game, world, 70, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 80, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 90, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 100, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 110, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 120, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 130, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 140, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 150, 0, 10, 5));

//kozepplatform


        addActor(new GlobalWallActor(game, world, 30, 60, 10, 5));
        addActor(new GlobalWallActor(game, world, 40, 60, 10, 5));
        addActor(new GlobalWallActor(game, world, 50, 60, 10, 5));
        addActor(new GlobalWallActor(game, world, 60, 60, 10, 5));
        addActor(new GlobalWallActor(game, world, 100, 60, 10, 5));
        addActor(new GlobalWallActor(game, world, 110, 60, 10, 5));
        addActor(new GlobalWallActor(game, world, 120, 60, 10, 5));
        addActor(new GlobalWallActor(game, world, 110, 80, 10, 5));
        addActor(new GlobalWallActor(game, world, 60, 80, 10, 5));
        addActor(new GlobalWallActor(game, world, 100, 80, 10, 5));
        addActor(new GlobalWallActor(game, world, 120, 30, 10, 5));
        addActor(new GlobalWallActor(game, world, 110, 30, 10, 5));
        addActor(new GlobalWallActor(game, world, 60, 30, 10, 5));
        addActor(new GlobalWallActor(game, world, 100, 30, 10, 5));
        addActor(new GlobalWallActor(game, world, 50, 40, 10, 5));
        addActor(new GlobalWallActor(game, world, 80, 40, 10, 5));

    }
}
