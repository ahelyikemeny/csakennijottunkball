package BallGameFolder;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.awt.Point;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyContactListener;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.MultiTickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.MultiTickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;
import jdk.nashorn.internal.objects.Global;

public class KonnyuStage extends BaseGameStage {

    @Override
    public void buildLevel() {

        /*Vizszint also*/
        addActor(new GlobalWallActor(game, world, 0, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 10,0, 10, 5));
        addActor(new GlobalWallActor(game, world, 20, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 30, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 40,0, 10, 5));
        addActor(new GlobalWallActor(game, world, 110,0, 10, 5));
        addActor(new GlobalWallActor(game, world, 120, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 130, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 140,0, 10, 5));
        addActor(new GlobalWallActor(game, world, 150, 0, 10, 5));

        for(int i = 0; i<=150; i = i + 10){
            addActor(new GlobalWallActor(game, world, i, 115, 10, 5));
        }
        for(int i = 5; i<=113; i = i + 3){
            addActor(new GlobalWallActor(game, world, 0, i, 6, 3));
        }
        for(int i = 5; i<=113; i = i + 3){
            addActor(new GlobalWallActor(game, world, 154, i, 6, 3));
        }

        addActor(new GlobalWallActor(game,world, 30, 55, 20,10));
        addActor(new GlobalWallActor(game,world, 110, 55, 20,10));
        addActor(new GlobalWallActor(game,world, 70, 35, 20,10));

        SensorActor sensorActor;
        addActor(sensorActor = new SensorActor(game,world,50,-3, 60, 5));

        getHelper(sensorActor).addContactListener(new MyContactListener() {
            @Override
            public void beginContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {
                if (otherHelper.getActor() instanceof BallActor){
                    otherHelper.getActor().setPosition(80,75);
                    setPoint(getPoint() + 1);
                    otherHelper.invoke(new Runnable() {
                        @Override
                        public void run() {
                            otherHelper.getBody().setLinearVelocity(0,0);
                            otherHelper.getBody().setAngularVelocity(0);
                        }
                    });
                }
            }
        });


    }

    public KonnyuStage(MyGame game) {
        super(game, 10);
    }


}
