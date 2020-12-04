package BallGameFolder;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyFixtureDef;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WallActorSmall extends OneSpriteStaticActor {
    KonnyuStage firstStage;
    public WallActorSmall(MyGame game, World world, KonnyuStage firstStage, float x, float y) {
        super(game, "badlogic.jpg");

this.setSize(75, 10);
setPosition(225,50);
        MyFixtureDef myFixtureDef = new MyFixtureDef();
        setActorWorldHelper(new Box2DWorldHelper(world, this, ShapeType.Rectangle, myFixtureDef, BodyDef.BodyType.StaticBody));

    }

}
