package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.stargame.Base.ScaledTouchUpButton;
import ru.geekbrains.stargame.Screen.GameScreen;
import ru.geekbrains.stargame.Screen.MenuScreen;
import ru.geekbrains.stargame.StarGame;
import ru.geekbrains.stargame.math.Rect;

public class New_Game extends ScaledTouchUpButton {
    Game game;
    MenuScreen menuScreen;

    public New_Game(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.08f);
        setBottom(worldBounds.getBottom() + 0.25f);
    }

    @Override
    public void action() {
        game.setScreen(new MenuScreen(game));
    }
}