package ru.geekbrains.stargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.Base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture back;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 pos;

    @Override
    public void show() {
        super.show();
        img = new Texture("7d9.gif");
        back = new Texture("background.jpg");
        touch = new Vector2();
        v = new Vector2(0.4f, 0.7f);
        pos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        pos.add(v);
        Gdx.gl.glClearColor(0.26f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(back,0,0);
        batch.draw(img, pos.x, pos.y, 150,150);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("touch.x = " + touch.x + " touch.y = " + touch.y);
        return false;
    }
}
