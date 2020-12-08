package BallGameFolder;

import com.badlogic.gdx.audio.Music;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class BallMyGame extends MyGame {

    public enum MusicType{
        MAIN,
        GAME,
        NONE
    }

    Music music = null;

    public MusicType musicType = MusicType.NONE;

    public void setMusic(MusicType type){
        if (type != musicType){
            musicType = type;
            if (music != null){
                music.stop();
            }
            switch (musicType){
                case MAIN:
                    music = getMyAssetManager().getMusic("mainmusic.mp3");
                    music.setLooping(true);
                    music.play();
                    break;
                case GAME:
                    music = getMyAssetManager().getMusic("ingamemusic.mp3");
                    music.setLooping(true);
                    music.play();
                    break;
                case NONE:
                    break;
            }
        }
    }



    @Override
    public void create() {
        super.create();
        setScreen(new BallMyGameMenuScreen(this));
    }
}
