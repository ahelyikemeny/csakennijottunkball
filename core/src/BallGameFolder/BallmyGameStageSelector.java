package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class BallmyGameStageSelector extends MyStage {
    public BallmyGameStageSelector(MyGame game) {
        super(new ExtendViewport(160,90), game);
        addActor(new InGameBackgroundActor(game));
        addActor(new KonnyuButton(game));
        addActor(new KozepesButton(game));
        addActor(new NehezButton(game));

    }
}
