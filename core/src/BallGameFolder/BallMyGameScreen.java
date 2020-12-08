package BallGameFolder;

import com.badlogic.gdx.audio.Music;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class BallMyGameScreen extends MyScreen {

    public BallMyGameScreen(MyGame game) {
        super(game);
    }


    @Override
    protected void afterAssetsLoaded() {
        addStage(new BallmyGameStageSelector(game), 0, true);
        ((BallMyGame)game).setMusic(BallMyGame.MusicType.MAIN);
        /*addStage(new BallMyGameStage1(game),0,true);*/
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }
}


