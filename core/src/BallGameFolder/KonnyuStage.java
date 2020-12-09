package BallGameFolder;

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

public class KonnyuStage extends Box2dStage {

    protected PlayerActor player1;
    protected int point = 0;
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
        MyLabel myLabel1 = new MyLabel(game, "", new PontCounter(game));
        addActor(myLabel1);
        myLabel1.setPosition(78, 85);
        myLabel1.setFontScale(0.3f);


        SensorActor sensorActor;
        addActor(sensorActor = new SensorActor(game,world,50,-3, 60, 5));
        MyLabel myLabel = new MyLabel(game, "", new CounterLabelStyle(game));
        addActor(myLabel);
        myLabel.setPosition(70, 105);
        getHelper(sensorActor).addContactListener(new MyContactListener() {
            @Override
            public void beginContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {
                if (otherHelper.getActor() instanceof BallActor){
                    otherHelper.getActor().setPosition(80,75);
                    point++;
                        myLabel1.setText(point);
                        myLabel1.setColor(255,255,255,255);
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



        addTimer(new MultiTickTimer(1f, 180, new MultiTickTimerListener(){
            @Override
            public void onTick(MultiTickTimer sender, float correction, int count) {
                super.onTick(sender, correction, count);
                myLabel.setText(180-count);
                myLabel.setFontScale(0.5f);
            }

            @Override
            public void onStart(MultiTickTimer sender) {
                super.onStart(sender);
                myLabel.setText(180);
                myLabel.setFontScale(0.5f);
            }

            @Override
            public void onStop(MultiTickTimer sender) {
                super.onStop(sender);
                myLabel.setText("Game Over");
                myLabel1.setText(point);
            }
        //getWorld().;
        }));
    }


}
