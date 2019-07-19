package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.stargame.Base.ScaledTouchUpButton;
import ru.geekbrains.stargame.math.Rect;

public class ButtonExit extends ScaledTouchUpButton {

    public ButtonExit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        setBottom(worldBounds.getBottom() + 0.04f);
        setRight(worldBounds.getRight() - 0.04f);
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }
}
