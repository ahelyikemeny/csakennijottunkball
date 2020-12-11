package BallGameFolder;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class BallMyGameMenuStage extends MyStage {
    StartButton startButton;
    ExitButton exitButton;
    CreditButton creditButton;
    public BallMyGameMenuStage(MyGame game) {
        super(new ExtendViewport(160,120), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        addActor(new BackgroundActor(game, 0,0));
        startButton = new StartButton(game);
        startButton.setPosition(10,20);
        addActor(startButton);
        exitButton = new ExitButton(game);
        exitButton.setPosition(110,20);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.getMyAssetManager().getSound("onclick.mp3").play();
            }

        });
        addActor(exitButton);
        creditButton = new CreditButton(game);
        creditButton.setPosition(60,20);
        addActor(creditButton);


    }
}
