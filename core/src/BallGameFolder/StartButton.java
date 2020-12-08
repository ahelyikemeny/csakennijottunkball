package BallGameFolder;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class StartButton extends OneSpriteStaticActor {
    BallMyGameStage firstStage;

    public void setMainStage(BallMyGameStage firstStage) {
        super.setStage(firstStage);
    }

    public StartButton(MyGame game) {
        super(game, "StartGomb.png");
        this.setSize(40, 40);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("onclick.mp3").play();
                game.setScreen(new BallMyGameScreen(game));


            }

        });

    }


}
