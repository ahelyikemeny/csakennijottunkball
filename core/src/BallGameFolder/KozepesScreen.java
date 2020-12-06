package BallGameFolder;

import com.badlogic.gdx.audio.Music;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;
import hu.csanyzeg.master.MyBaseClasses.Timers.OneTickTimer;

public class KozepesScreen extends MyScreen {
    Music music;
    public KozepesScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new KozepesStage(game),0, true);
        music = game.getMyAssetManager().getMusic("ingamemusic.mp3");
        music.setLooping(true);
        music.play();
        music.setVolume(100);

    }

    @Override
    public AssetList getAssetList() {
        return null;
    }
}
