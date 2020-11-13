package BallGameFolder;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class BallMyGameScreen extends MyScreen {
    public BallMyGameScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new BallMyGameStage(game),0,true);
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }
}