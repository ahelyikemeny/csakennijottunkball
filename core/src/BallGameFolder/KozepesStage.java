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

public class KozepesStage extends Box2dStage {
    protected PlayerActor player1;
    int point = 0;

    public KozepesStage(MyGame game) {
        super(new ExtendViewport(160,90), game);

        addBackButtonScreenBackByStackPopListener();
        addActor(new InGameBackgroundActor(game));
        BallActor ballActor;
        addActor(ballActor = new BallActor(game, world, 70,40));

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
        MyLabel myLabel1 = new MyLabel(game, "", new PontCounter(game));
        addActor(myLabel1);
        myLabel1.setFontScale(0.3f);



        getHelper(sensorActor).addContactListener(new MyContactListener() {
            @Override
            public void beginContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {
                if (otherHelper.getActor() instanceof BallActor){
                    otherHelper.getActor().setPosition(70,40);
                    point++;
                    myLabel1.setText(point);
                    myLabel1.setPositionCenter(95);


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
        myLabel.setFontScale(0.3f);
        myLabel.setPositionCenter(105);


        addTimer(new MultiTickTimer(1f, 120, new MultiTickTimerListener(){
            @Override
            public void onTick(MultiTickTimer sender, float correction, int count) {
                super.onTick(sender, correction, count);
                myLabel.setText(120-count);
            }

            @Override
            public void onStart(MultiTickTimer sender) {
                super.onStart(sender);
                myLabel.setText(120);
            }

            @Override
            public void onStop(MultiTickTimer sender) {
                super.onStop(sender);
                myLabel.setText("Game Over");
                addActor(new BackButton(game,50,80));
                addActor(new NewGameButton(game,90,80));
            }
        }));




    }
}
