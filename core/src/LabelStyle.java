import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class LabelStyle extends Label.LabelStyle {
    public LabelStyle(MyGame game) {
        super(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
    }
}
