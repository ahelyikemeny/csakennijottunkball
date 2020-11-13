package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class BallMyGameStage extends MyStage {
    ExitButton exitButton;
    public BallMyGameStage(MyGame game) {
        super(new ExtendViewport(150,90), game);
    }
}
