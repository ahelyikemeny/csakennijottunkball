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



    @Override
    protected void setStage(Stage stage) {
        super.setStage(stage);
        if (stage != null){

        }
    }
}
