package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class BallmyGameStageSelector extends MyStage {
    BackButton backButton;
    public BallmyGameStageSelector(MyGame game) {
        super(new ExtendViewport(160,120), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        addActor(new InGameBackgroundActor(game));
        addActor(new KonnyuButton(game));
        addActor(new KozepesButton(game));
        addActor(new NehezButton(game));
        backButton = new BackButton(game, 140,0);
        addActor(backButton);

    }
}
