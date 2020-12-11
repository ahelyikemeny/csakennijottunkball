package BallGameFolder;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;


public class HelpStage extends MyStage {
 BackButton backButton;
    public  HelpStage(MyGame game){
        super(new ExtendViewport(160,120), game);
        setCameraResetToCenterOfScreen();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.getMyAssetManager().getFont("font.ttf");
        labelStyle.fontColor = Color.BLACK;
        addBackButtonScreenBackByStackPopListener();
        addActor(new InGameBackgroundActor(game));
        backButton = new BackButton(game, 140,0);
        addActor(backButton);
        MyLabel label = new MyLabel(game, "Info:", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,70);
        addActor(label);

        label = new MyLabel(game, "A piros kis korong segitsegevel kell a", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,60);
        addActor(label);

        label = new MyLabel(game, "labdat a zold teruletre lokodni mikozben", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,52);
        addActor(label);

        label = new MyLabel(game, "az akadalyokat ki kell kerulni", labelStyle);
        label.setFontScale(0.2f);
        label.setPosition(20,44);
        addActor(label);








    }

}
