package BallGameFolder;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.lang.reflect.InvocationTargetException;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class NewGameHardButton extends OneSpriteStaticActor {
    ClickListener c1;
    public NewGameHardButton(MyGame game, float x, float y) {
        super(game,"NewGame.png");
        setSize(20,20);
        setPosition(x,y);
        this.addListener(c1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("onclick.mp3").play();
                try {
                    game.setScreen(game.getScreen().getClass().getConstructor(MyGame.class).newInstance(game), false);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                removeListener(c1);
            }
        });
    }
}
