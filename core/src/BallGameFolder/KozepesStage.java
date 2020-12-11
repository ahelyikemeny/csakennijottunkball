package BallGameFolder;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyContactListener;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Timers.MultiTickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.MultiTickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class KozepesStage extends BaseGameStage {

    @Override
    public void buildLevel() {
//fent
        for(int i = 0; i<=150; i = i + 10){
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
        for(int i = 0; i<=40; i = i + 10){
            addActor(new GlobalWallActor(game, world, i, 0, 10, 5));
        }

        //lentjobb

        for(int i = 110; i<=150; i = i + 10){
            addActor(new GlobalWallActor(game, world, i, 0, 10, 5));
        }


//propok

        //bal

        for(int i = 10; i<=30; i = i + 10){
            addActor(new GlobalWallActor(game, world, 30, 50, 20, 10));
        }

//jobb

        for(int i = 10; i<=30; i = i + 10){
            addActor(new GlobalWallActor(game, world, 110, 50, 20, 10));
        }

//fent
        for(int i = 10; i<=30; i = i + 10){
            addActor(new GlobalWallActor(game, world, 70, 70, 20, 10));
        }

//lent
        for(int i = 10; i<=30; i = i + 10){
            addActor(new GlobalWallActor(game, world, 70, 30, 20, 10));
        }

        for(int i = 10; i<=30; i = i + 10){
            addActor(new GlobalWallActor(game, world, 60, 10, 40, 10));
        }





        SensorActor sensorActor;
        addActor(sensorActor = new SensorActor(game,world,50,0, 60, 3));


        getHelper(sensorActor).addContactListener(new MyContactListener() {
            @Override
            public void beginContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {
                if (otherHelper.getActor() instanceof BallActor){
                    otherHelper.getActor().setPosition(70,40);
                    setPoint(getPoint()+1);

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

    public KozepesStage(MyGame game) {
        super(game, 120);
    }
}
