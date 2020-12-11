package BallGameFolder;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class CreditStage extends MyStage {
    public CreditStage(MyGame game) {
        super(new ExtendViewport(160,120), game);
        setCameraResetToCenterOfScreen();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.getMyAssetManager().getFont("alegreyaregular.otf");
        labelStyle.fontColor = Color.BLACK;
        addBackButtonScreenBackByStackPopListener();
        addActor(new InGameBackgroundActor(game));
        MyLabel label = new MyLabel(game, "Creators:", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,70);
        addActor(label);


        label = new MyLabel(game, "Kele Lorand", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,64);
        addActor(label);

        label = new MyLabel(game, "Fellner Milan", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,58);
        addActor(label);

        label = new MyLabel(game, "Zsebok David Ferenc", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,52);
        addActor(label);

        label = new MyLabel(game, "Kancsal Mate", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,46);
        addActor(label);

        label = new MyLabel(game, "Teacher:", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,40);
        addActor(label);

        label = new MyLabel(game, "Tuske Balazs", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,34);
        label.setColor(0,50,100,100);
        addActor(label);

    }
}

