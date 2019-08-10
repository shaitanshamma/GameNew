package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.stargame.Base.ScaledTouchUpButton;
import ru.geekbrains.stargame.Screen.MenuScreen;
import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.Screen.GameScreen;

public class ButtonPlay extends ScaledTouchUpButton {

    private Game game;

    public ButtonPlay(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.25f);
        setBottom(worldBounds.getBottom() + 0.04f);
        setLeft(worldBounds.getLeft() + 0.04f);
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen(game));
    }
}
