package BallGameFolder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.World;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2dStage;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyContactListener;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyFixtureDef;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class GroundActor extends OneSpriteStaticActor {
    public GroundActor(MyGame game, World world, WorldBodyEditorLoader loader, float x, float y) {
        super(game, "ground.png");
        setPosition(x,y);
        setWidthWhithAspectRatio(150);
        MyFixtureDef myFixtureDef = new MyFixtureDef();
        setActorWorldHelper(new Box2DWorldHelper(world, this, loader, "ground.png", myFixtureDef, BodyDef.BodyType.StaticBody));
        ((Box2DWorldHelper)getActorWorldHelper()).addContactListener(new MyContactListener() {
            @Override
            public void beginContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {
                if (otherHelper.actor instanceof BallActor){
                    if (otherHelper.body.getLinearVelocity().len() > 3) {
                        System.out.println(otherHelper.body.getLinearVelocity().len());
                    }
                }
            }

            @Override
            public void endContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {

            }

            @Override
            public void preSolve(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {

            }

            @Override
            public void postSolve(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper) {

            }
        });
    }
}
