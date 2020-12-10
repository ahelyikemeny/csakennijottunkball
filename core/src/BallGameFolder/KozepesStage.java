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
import sun.management.Sensor;

public class KozepesStage extends Box2dStage {
    protected PlayerActor player1;

    public KozepesStage(MyGame game) {
        super(new ExtendViewport(160,90), game);

        addBackButtonScreenBackByStackPopListener();
        addActor(new InGameBackgroundActor(game));
        BallActor ballActor;
        addActor(ballActor = new BallActor(game, world, 70,40));
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
        addActor(new GlobalWallActor(game, world, 0, 0, 3, 114));
        addActor(new GlobalWallActor(game, world, 3,0, 10, 3));
        addActor(new GlobalWallActor(game, world, 40, 0, 114, 3));
        addActor(new GlobalWallActor(game, world, 148, 0, 3, 114));
        addActor(new GlobalWallActor(game, world, 138,110, 10, 3));
        addActor(new GlobalWallActor(game, world, 0, 110, 114, 3));
        addActor(new GlobalWallActor(game, world, 45, 60, 60, 3));
        SensorActor sensorActor;
        addActor(sensorActor = new SensorActor(game,world,10,0, 60, 5));
SensorActor1 sensorActor1;
addActor(sensorActor1 = new SensorActor1(game,world,110, 110,30,5));

        getHelper(sensorActor).addContactListener(new MyContactListener() {
            @Override
            public void beginContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {
                if (otherHelper.getActor() instanceof BallActor){
                    otherHelper.getActor().setPosition(70,40);
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

        MyLabel myLabel = new MyLabel(game, "", new CounterLabelStyle(game));
        addActor(myLabel);
        myLabel.setPosition(68, 105);
        myLabel.setFontScale(0.3f);


        addTimer(new MultiTickTimer(1f, 180, new MultiTickTimerListener(){
            @Override
            public void onTick(MultiTickTimer sender, float correction, int count) {
                super.onTick(sender, correction, count);
                myLabel.setText(180-count);
            }

            @Override
            public void onStart(MultiTickTimer sender) {
                super.onStart(sender);
                myLabel.setText(180);
            }

            @Override
            public void onStop(MultiTickTimer sender) {
                super.onStop(sender);
                myLabel.setText("Game Over");
            }
        }));




    }
}
