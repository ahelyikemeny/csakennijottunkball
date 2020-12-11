package BallGameFolder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyContactListener;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Timers.MultiTickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.MultiTickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.PermanentTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.PermanentTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public abstract class BaseGameStage extends Box2dStage {
    protected PlayerActor player1;
    private MyLabel timerLabel;
    private MyLabel pontCounter;
    private MyLabel bounceCounter;
    private int point = 0;
    private int ballhit = 0;
    private Vector2 lastClick = null;


    public abstract void buildLevel();


    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
        pontCounter.setText("Points:" +point);
    }

    public int getBounce() {
        return ballhit;
    }
    public void setBounce( int ballhit) {
        this.ballhit = ballhit;
        bounceCounter.setText("Bounces:" +ballhit);
    }

    public BaseGameStage(MyGame game, int playTime) {
        super(new ExtendViewport(160,120), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        addActor(new InGameBackgroundActor(game));
        BallActor ballActor;
        addActor(ballActor = new BallActor(game, world, 75,75));
        addActor(new GlobalWallActor(game, world, 0, 5, 6, 3));
        player1 = new PlayerActor(game, world, 10,50);
        addActor(player1);
        world.setGravity(new Vector2(0,0));

        ClickListener moveListener;

        addListener(moveListener = new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                //System.out.println("X: " + x + " Y: " + y + " Button: " + pointer);
                player1.moveTo(x,y);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //System.out.println("X: " + x + " Y: " + y + " Button: " + pointer);
                player1.moveTo(x,y);
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        buildLevel();

        pontCounter = new MyLabel(game, "", new PontCounter(game));
        addActor(pontCounter);
        pontCounter.setFontScale(0.3f);
        pontCounter.setPositionCenter(95);


        bounceCounter = new MyLabel(game, "",new BounceCounterStyle(game));
        addActor(bounceCounter);
        bounceCounter.setPositionCenter(85);
        bounceCounter.setAlignment(2);
        bounceCounter.setFontScale(0.3f);
        setBounce(0);

        timerLabel = new MyLabel(game, "", new CounterLabelStyle(game));
        addActor(timerLabel);
        timerLabel.setPositionCenter(105);
        timerLabel.setFontScale(0.5f);
        timerLabel.setAlignment(2);
        setPoint(0);



        addTimer(new MultiTickTimer(1f, playTime, new MultiTickTimerListener(){
            @Override
            public void onTick(MultiTickTimer sender, float correction, int count) {
                super.onTick(sender, correction, count);
                timerLabel.setText(playTime-count);
                game.getMyAssetManager().getSound("clock.wav").play();

            }

            @Override
            public void onStart(MultiTickTimer sender) {
                super.onStart(sender);
                timerLabel.setText(playTime);
            }

            @Override
            public void onStop(MultiTickTimer sender) {
                super.onStop(sender);
                timerLabel.setText("Game Over");
                addActor(new BackButton(game,50,80));
                addActor(new NewGameButton(game,90,80));
                BaseGameStage.this.removeListener(moveListener);
            }
        }));





        ((Box2DWorldHelper)ballActor.getActorWorldHelper()).addContactListener(new MyContactListener() {
            @Override
            public void beginContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {
                if (otherHelper.getActor() instanceof GlobalWallActor) {
                    if (lastClick == null) {
                        lastClick = new Vector2(myHelper.body.getPosition());
                        game.getMyAssetManager().getSound("onhit.wav").play();
                        setBounce(getBounce() + 1);
                    } else {
                        if (lastClick.sub(myHelper.body.getPosition()).len() > 5f) {
                            game.getMyAssetManager().getSound("onhit.wav").play();
                            setBounce(getBounce() + 1);
                        }
                        lastClick.set(myHelper.body.getPosition());
                    }

                    /*
                    System.out.println(myHelper.getBody().getLinearVelocity().len());
                    float speed = myHelper.getBody().getLinearVelocity().len();
                    s.play(speed < 35f ? 0f : (speed > 80f ? 1f : ( (speed - 20f) / 45f )));

                     */
                }
            }});

        addTimer(new PermanentTimer(new PermanentTimerListener(){
            @Override
            public void onTick(PermanentTimer sender, float correction) {
                super.onTick(sender, correction);
                Vector2 newspeed = ((Box2DWorldHelper)ballActor.getActorWorldHelper()).getBody().getLinearVelocity().scl(0.993f);
                ((Box2DWorldHelper)ballActor.getActorWorldHelper()).getBody().setLinearVelocity(newspeed);
                ((Box2DWorldHelper)ballActor.getActorWorldHelper()).getBody().setAngularVelocity(0.993f);
            }
        }));


    }
}
