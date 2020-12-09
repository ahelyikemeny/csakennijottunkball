package BallGameFolder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

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

public class KonnyuStage extends Box2dStage {

    protected PlayerActor player1;
    public KonnyuStage(MyGame game) {
        super(new ExtendViewport(160, 90), game);
        addBackButtonScreenBackByStackPopListener();
        addActor(new InGameBackgroundActor(game));
        BallActor ballActor;
        addActor(ballActor = new BallActor(game, world, 75,75));
        addActor(new GlobalWallActor(game, world, 0, 5, 6, 3));
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
        /*Vizszint also*/
        addActor(new GlobalWallActor(game, world, 0, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 10,0, 10, 5));
        addActor(new GlobalWallActor(game, world, 20, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 30, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 40,0, 10, 5));
        /*addActor(new GlobalWallActor(game, world, 50, 0, 10, 5));*/
        /*addActor(new GlobalWallActor(game, world, 60, 0, 10, 5));*/
        /*addActor(new GlobalWallActor(game, world, 70, 0, 10, 5));*/
        /*addActor(new GlobalWallActor(game, world, 80,0, 10, 5));*/
        /*addActor(new GlobalWallActor(game, world, 90, 0, 10, 5));*/
        /*addActor(new GlobalWallActor(game, world, 100, 0, 10, 5));*/
        addActor(new GlobalWallActor(game, world, 110,0, 10, 5));
        addActor(new GlobalWallActor(game, world, 120, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 130, 0, 10, 5));
        addActor(new GlobalWallActor(game, world, 140,0, 10, 5));
        addActor(new GlobalWallActor(game, world, 150, 0, 10, 5));

        /*Felso*/
        addActor(new GlobalWallActor(game, world, 0, 115, 10, 5));
        addActor(new GlobalWallActor(game, world, 10,115, 10, 5));
        addActor(new GlobalWallActor(game, world, 20, 115, 10, 5));
        addActor(new GlobalWallActor(game, world, 30, 115, 10, 5));
        addActor(new GlobalWallActor(game, world, 40,115, 10, 5));
        addActor(new GlobalWallActor(game, world, 50, 115, 10, 5));
        addActor(new GlobalWallActor(game, world, 60, 115, 10, 5));
        addActor(new GlobalWallActor(game, world, 70, 115, 10, 5));
        addActor(new GlobalWallActor(game, world, 80,115, 10, 5));
        addActor(new GlobalWallActor(game, world, 90, 115, 10, 5));
        addActor(new GlobalWallActor(game, world, 100, 115, 10, 5));
        addActor(new GlobalWallActor(game, world, 110,115, 10, 5));
        addActor(new GlobalWallActor(game, world, 120, 115, 10, 5));
        addActor(new GlobalWallActor(game, world, 130, 115, 10, 5));
        addActor(new GlobalWallActor(game, world, 140,115, 10, 5));
        addActor(new GlobalWallActor(game, world, 150, 115, 10, 5));
        /*Bal oldal*/
        addActor(new GlobalWallActor(game, world, 0, 5, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 8, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 11, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 14, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 17, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 20, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 23, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 26, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 29, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 32, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 35, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 38, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 41, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 44, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 47, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 50, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 53, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 56, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 59, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 62, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 65, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 68, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 71, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 74, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 77, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 80, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 83, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 86, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 89, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 92, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 95, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 98, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 101, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 104, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 107, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 110, 6, 3));
        addActor(new GlobalWallActor(game, world, 0, 113, 6, 3));
        /*Jobb oldal*/
        addActor(new GlobalWallActor(game, world, 154, 5, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 8, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 11, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 14, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 17, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 20, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 23, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 26, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 29, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 32, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 35, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 38, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 41, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 44, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 47, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 50, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 53, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 56, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 59, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 62, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 65, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 68, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 71, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 74, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 77, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 80, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 83, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 86, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 89, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 92, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 95, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 98, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 101, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 104, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 107, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 110, 6, 3));
        addActor(new GlobalWallActor(game, world, 154, 113, 6, 3));

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
        myLabel.setPosition(75, 105);
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
        //getWorld().;
        }));
    }


}
