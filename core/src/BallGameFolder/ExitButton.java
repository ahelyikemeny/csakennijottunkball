package BallGameFolder;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Timers.OneTickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.OneTickTimerListener;

public class ExitButton extends OneSpriteStaticActor {
    ClickListener cl;

    public ExitButton(MyGame game) {
        super(game, "ExitGomb.png");
        setSize(30,30);
        this.addListener(cl = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("onclick.mp3").play();
                addTimer(new OneTickTimer(1, new OneTickTimerListener(){
                    @Override
                    public void onTick(OneTickTimer sender, float correction) {
                        super.onTick(sender, correction);
                        game.setScreenBackByStackPop();
                    }
                }));

                removeListener(cl);


            }

        });
    }
}
