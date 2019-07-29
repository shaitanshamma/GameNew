package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.stargame.Base.Sprite;
import ru.geekbrains.stargame.math.Rect;

public class Gameover extends Sprite {

    public Gameover(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }
    public void resize(Rect worldBounds) {
        setHeightProportion(0.13f);
        setBottom(worldBounds.getBottom() + 0.6f);
    }
}
