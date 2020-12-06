package BallGameFolder;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class NehezButton extends OneSpriteStaticActor {
    public NehezButton(MyGame game) {
        super(game, "Hard Gomb.png");
        setSize(40,40);
        setPosition(110,40);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("onclick.mp3").play();
                game.setScreen(new NehezScreen(game));


            }

        });
    }
}
