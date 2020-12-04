package BallGameFolder;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class KonnyuButton extends OneSpriteStaticActor {
    public KonnyuButton(MyGame game) {
        super(game, "startgomb.png");
        setSize(30,30);
        setPosition(60,60);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("onclick.mp3").play();
                game.setScreen(new KonnyuScreen(game));


            }

        });
    }
}