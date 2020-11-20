package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.PermanentTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.PermanentTimerListener;

public class BallMyGameStage extends Box2dStage {
    WorldBodyEditorLoader worldBodyEditorLoader = new WorldBodyEditorLoader("ground.phy");
    ExitButton exitButton;
    BallActor cameraBallActor;
    public BallMyGameStage(MyGame game) {
        super(new ExtendViewport(150,90), game);
        setTimeMultiply(3);
        addActor(new GroundActor(game, world, worldBodyEditorLoader, 0,0 ));
        addActor(cameraBallActor = new BallActor(game, world, 80,80));
        addActor(new BallActor(game, world, 10,80));
        addActor(new BallActor(game, world, 140,80));

        addTimer(new PermanentTimer(new PermanentTimerListener(){
            @Override
            public void onTick(PermanentTimer sender, float correction) {
                super.onTick(sender, correction);
                //setCameraZoomXY(cameraBallActor.getX(), cameraBallActor.getY(), 1);
                //setCameraMoveToXY(cameraBallActor.getX(), cameraBallActor.getY(), 1);
            }
        }));
    }

}
