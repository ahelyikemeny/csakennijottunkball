package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.Szakkor.Start;

public class BallMyGameMenuStage extends MyStage {
    StartButton startButton;
    ExitButton exitButton;
    CreditButton creditButton;
    public BallMyGameMenuStage(MyGame game) {
        super(new ExtendViewport(160,90), game);
        startButton = new StartButton(game);
        startButton.setPosition(65,80);
        addActor(startButton);
        exitButton = new ExitButton(game);
        exitButton.setPosition(65,20);
        addActor(exitButton);
        creditButton = new CreditButton(game);
        creditButton.setPosition(65,50);
        addActor(creditButton);
    }
}
