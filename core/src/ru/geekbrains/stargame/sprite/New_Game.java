package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.stargame.Base.ScaledTouchUpButton;
import ru.geekbrains.stargame.Screen.GameScreen;
import ru.geekbrains.stargame.Screen.MenuScreen;
import ru.geekbrains.stargame.StarGame;
import ru.geekbrains.stargame.math.Rect;

public class New_Game extends ScaledTouchUpButton {


    public New_Game(TextureAtlas atlas) {
        super(atlas.findRegion("button_new_game"));

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.08f);
        setBottom(worldBounds.getBottom() + 0.25f);
    }

    @Override
    public void action() {
      new MenuScreen(new Game() {
            @Override
            public void create() {
            }
        });
    }
}