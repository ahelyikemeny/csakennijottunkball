package BallGameFolder;

import com.badlogic.gdx.audio.Music;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;
import hu.csanyzeg.master.MyBaseClasses.Timers.OneTickTimer;

public class KozepesScreen extends MyScreen {
    public KozepesScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new KozepesStage(game),0, true);
        ((BallMyGame)game).setMusic(BallMyGame.MusicType.GAME);
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }
}
