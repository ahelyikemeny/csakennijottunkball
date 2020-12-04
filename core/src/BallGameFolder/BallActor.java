package BallGameFolder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyFixtureDef;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BallActor extends OneSpriteStaticActor {
    public BallActor(MyGame game, World world, float x, float y) {
        super(game, "box2dhelper/ball.png");
        setPosition(x,y);
        setSize(5,5);
        MyFixtureDef myFixtureDef = new MyFixtureDef();
        myFixtureDef.density = 20;
        myFixtureDef.friction = 1;
        myFixtureDef.restitution = 0.8f;
        setActorWorldHelper(new Box2DWorldHelper(world, this, ShapeType.Circle, myFixtureDef, BodyDef.BodyType.DynamicBody));
    }

    @Override
    protected void setStage(Stage stage) {
        super.setStage(stage);
        Box2dStage.getBody(this).setLinearVelocity(new Vector2(10, 20));
    }
}
