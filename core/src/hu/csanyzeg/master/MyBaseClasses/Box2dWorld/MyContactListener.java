package hu.csanyzeg.master.MyBaseClasses.Box2dWorld;

import com.badlogic.gdx.physics.box2d.Contact;

public abstract class MyContactListener {
    public void beginContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper){};

    public void endContact(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper){};

    public void preSolve(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper){};

    public void postSolve(Contact contact, Box2DWorldHelper myHelper, Box2DWorldHelper otherHelper){};
}
