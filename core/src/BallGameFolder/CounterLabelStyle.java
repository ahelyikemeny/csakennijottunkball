package BallGameFolder;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class CounterLabelStyle extends Label.LabelStyle {
    public CounterLabelStyle(MyGame game) {
        super(game.getMyAssetManager().getFont("font.ttf"), Color.BLACK);
    }
}
