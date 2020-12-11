package BallGameFolder;



import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class HelpScreen extends MyScreen {
    public HelpScreen (MyGame game) {super(game);}

    @Override
    protected void afterAssetsLoaded() {
        addStage(new HelpStage(game), 0, true);
        ((BallMyGame)game).setMusic(BallMyGame.MusicType.GAME);
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }
}
