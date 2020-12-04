package BallGameFolder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class KozepesStage extends Box2dStage {
    protected PlayerActor player1;

    public KozepesStage(MyGame game) {
        super(new ExtendViewport(150,90), game);
        addActor(new BallActor(game, world, 70,40));
        addActor(new GlobalWallActor(game, world, 0, 0, 3, 30));
        player1 = new PlayerActor(game, world, 10,50);
        addActor(player1);
        world.setGravity(new Vector2(0,0));

        addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                System.out.println("X: " + x + " Y: " + y + " Button: " + pointer);
                player1.moveTo(x,y);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("X: " + x + " Y: " + y + " Button: " + pointer);
                player1.moveTo(x,y);
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
