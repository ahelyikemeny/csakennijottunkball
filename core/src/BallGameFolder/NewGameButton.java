package BallGameFolder;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Timers.OneTickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.OneTickTimerListener;

public class NewGameButton extends OneSpriteStaticActor {
    ClickListener c1;
    public NewGameButton(MyGame game,float x, float y) {
        super(game,"NewGame.png");
        setSize(20,20);
        setPosition(x,y);
        this.addListener(c1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("onclick.mp3").play();
                addTimer(new OneTickTimer(1, new OneTickTimerListener(){
                    @Override
                    public void onTick(OneTickTimer sender, float correction) {
                        super.onTick(sender, correction);
                        game.setScreen(new KonnyuScreen(game));
                    }
                }));

                removeListener(c1);

            }

        });
    }
}
