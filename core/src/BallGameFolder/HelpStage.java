package BallGameFolder;

import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;


public class HelpStage extends MyStage {
 BackButton backButton;
    public  HelpStage(MyGame game){
        super(new ExtendViewport(160,90), game);
        addBackButtonScreenBackByStackPopListener();
        addActor(new InGameBackgroundActor(game));
        backButton = new BackButton(game, 140,0);
        addActor(backButton);








    }

}
