package BallGameFolder;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.scenes.scene2d.Stage;

import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyContactListener;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyFixtureDef;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyJoint;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PlayerActor extends OneSpriteStaticActor {

    World world;
    MyActor target;
    MouseJoint j;

    public PlayerActor(MyGame game, World world,  float x, float y) {
        super(game, "PlayerActor.png");
        setSize(10,10);
        setPosition(x,y);
        setActorWorldHelper(new Box2DWorldHelper(world, this, ShapeType.Circle, new MyFixtureDef(), BodyDef.BodyType.DynamicBody));
        this.world = world;

        //this.addListener(new Joint() {
//this.setSize(20,20);public class PlayerActor extends OneSpriteStaticActor {
//    PlayerActor playerActor;
//    public PlayerActor(MyGame game, World world, PlayerActor playerActor, float x, float y) {
//        super(game, "badlogic.jpg");
//        this.playerActor = playerActor;
//       //this.addListener(new Joint() {
////this.setSize(20,20);

    }

    @Override
    protected void setStage(Stage stage) {
        super.setStage(stage);
        if (stage != null) {
            ((Box2DWorldHelper)getActorWorldHelper()).getBody().setFixedRotation(true);
            target = new OneSpriteStaticActor(game, "badlogic.jpg");
            target.setPosition(getX(), getY());
            target.setSize(getWidth(), getHeight());
            target.setActorWorldHelper(new Box2DWorldHelper(world, target, ShapeType.Circle, new MyFixtureDef(), BodyDef.BodyType.StaticBody));
            target.setVisible(false);
            getStage().addActor(target);
            j = (MouseJoint) MyJoint.createMouseJoint(target, this, 9999999f).joint;
            j.setDampingRatio(0.2f);
            j.setFrequency(5);
        }
    }

    public void moveTo(float x, float y){
        j.setTarget(new Vector2(x,y));
    }
}