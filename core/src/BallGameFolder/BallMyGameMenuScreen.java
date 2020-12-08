package BallGameFolder;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class BallMyGameMenuScreen extends MyScreen {
    public BallMyGameMenuScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new BallMyGameMenuStage(game),0,true);
        ((BallMyGame)game).setMusic(BallMyGame.MusicType.MAIN);
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }

}
