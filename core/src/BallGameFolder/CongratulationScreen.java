package BallGameFolder;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class CongratulationScreen extends MyScreen {
    public CongratulationScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new CongratulationStage(game),0,true);
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }
}
