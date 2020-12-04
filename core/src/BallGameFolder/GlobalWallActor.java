package BallGameFolder;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyFixtureDef;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class GlobalWallActor extends OneSpriteStaticActor {
    public GlobalWallActor(MyGame game, World world, float x, float y) {
        super(game,"badlogic.jpg");
        setPosition(x,y);
        this.setSize(400, 10);
        MyFixtureDef myFixtureDef = new MyFixtureDef();
        myFixtureDef.density = 20;
        myFixtureDef.friction = 1;
        myFixtureDef.restitution = 0.8f;
        setActorWorldHelper(new Box2DWorldHelper(world, this, ShapeType.Rectangle, myFixtureDef, BodyDef.BodyType.StaticBody));
    }
}