package BallGameFolder;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyFixtureDef;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class SensorActor extends OneSpriteStaticActor {
    public SensorActor(MyGame game, World world, float x, float y, float width, float height) {
        super(game, "SensorActor.png");
        setPosition(x, y);
        setSize(width,height);
        MyFixtureDef myFixtureDef = new MyFixtureDef();
        myFixtureDef.density = 20;
        myFixtureDef.friction = 1;
        myFixtureDef.restitution = 0.8f;
        myFixtureDef.isSensor = true;
        setActorWorldHelper(new Box2DWorldHelper(world, this, ShapeType.Circle, myFixtureDef, BodyDef.BodyType.StaticBody));
    }
}