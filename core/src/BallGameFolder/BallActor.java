package BallGameFolder;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyContactListener;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyFixtureDef;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Timers.PermanentTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.PermanentTimerListener;

public class BallActor extends OneSpriteStaticActor {
    public BallActor(MyGame game, World world, float x, float y) {
        super(game, "box2dhelper/ball.png");
        setPosition(x,y);
        setSize(10,10);
        MyFixtureDef myFixtureDef = new MyFixtureDef();
        myFixtureDef.density = 20;
        myFixtureDef.friction = 1;
        myFixtureDef.restitution = 0.8f;
        setActorWorldHelper(new Box2DWorldHelper(world, this, ShapeType.Circle, myFixtureDef, BodyDef.BodyType.DynamicBody));
    }

    Vector2 lastClick = null;


    @Override
    protected void setStage(Stage stage) {
        super.setStage(stage);
        if (stage != null){
            ((Box2DWorldHelper)getActorWorldHelper()).addContactListener(new MyContactListener() {
                @Override
                public void beginContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {
                    if (lastClick == null){
                        lastClick = new Vector2(myHelper.body.getPosition());
                            game.getMyAssetManager().getSound("onhit.wav").play();
                    }else{
                        if (lastClick.sub(myHelper.body.getPosition()).len() > 10f){
                             game.getMyAssetManager().getSound("onhit.wav").play();
                        }
                        lastClick.set(myHelper.body.getPosition());
                    }

                    /*
                    System.out.println(myHelper.getBody().getLinearVelocity().len());
                    float speed = myHelper.getBody().getLinearVelocity().len();
                    s.play(speed < 35f ? 0f : (speed > 80f ? 1f : ( (speed - 20f) / 45f )));

                     */
                }
            });

            addTimer(new PermanentTimer(new PermanentTimerListener(){
                @Override
                public void onTick(PermanentTimer sender, float correction) {
                    super.onTick(sender, correction);
                    Vector2 newspeed = ((Box2DWorldHelper)BallActor.this.getActorWorldHelper()).getBody().getLinearVelocity().scl(0.993f);
                    ((Box2DWorldHelper)BallActor.this.getActorWorldHelper()).getBody().setLinearVelocity(newspeed);
                    ((Box2DWorldHelper)BallActor.this.getActorWorldHelper()).getBody().setAngularVelocity(0.993f);
                }
            }));

        }
    }
}
