package BallGameFolder;

import com.badlogic.gdx.audio.Music;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class BallMyGameMenuScreen extends MyScreen {
    Music music;
    public BallMyGameMenuScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new BallMyGameMenuStage(game),0,true);
        music = game.getMyAssetManager().getMusic("mainmusic.mp3");
        music.setLooping(true);
        music.play();
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }
}
