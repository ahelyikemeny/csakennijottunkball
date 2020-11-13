package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.Szakkor.Start;

public class BallMyGameMenuStage extends MyStage {
    StartButton startButton;
    ExitButton exitButton;
    public BallMyGameMenuStage(MyGame game) {
        super(new ExtendViewport(160,90), game);
        startButton = new StartButton(game);
        addActor(startButton);
        exitButton = new ExitButton(game);
        addActor(exitButton);
    }
}