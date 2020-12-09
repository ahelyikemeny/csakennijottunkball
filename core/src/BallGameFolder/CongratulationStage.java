package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class CongratulationStage extends MyStage {
    public CongratulationStage(MyGame game) {
        super(new ExtendViewport(160,90), game);
        MyLabel myLabel = new MyLabel(game, "", new CounterLabelStyle(game));
        addActor(myLabel);
    }
}
