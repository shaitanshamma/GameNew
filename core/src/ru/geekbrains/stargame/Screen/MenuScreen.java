package ru.geekbrains.stargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.Base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private static final float V_LEN = 0.005f;
    private Texture img;
    private Texture back;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 touchV;
    private Vector2 pos;
    private int key;
    private Vector2 buf;

    @Override
    public void show() {
        super.show();
        img = new Texture("7d9.gif");
        back = new Texture("background.jpg");
        touch = new Vector2();
        touchV = new Vector2();
        v = new Vector2();
        pos = new Vector2();
        buf = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.26f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buf.set(touchV);
        batch.begin();
        if (buf.sub(pos).len() > V_LEN || keyDown(key)) {
            pos.add(v);
            key=62;
        } else {
            pos.set(touchV);
        }
        batch.draw(img, pos.x, pos.y, 0.2f, 0.2f);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        v.set(touch.cpy().sub(pos)).setLength(V_LEN * 1.5f);
        touchV.set(touch);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 19) {
            v.set(0, V_LEN* 1.5f);
            key = keycode;
            return true;
        } else if (keycode == 20) {
            v.set(0, -V_LEN* 1.5f);
            key = keycode;
            return true;
        } else if (keycode == 22) {
            v.set(V_LEN* 1.5f, 0);
            key = keycode;
            return true;
        } else if (keycode == 21) {
            v.set(-V_LEN* 1.5f, 0);
            key = keycode;
            return true;
        } else if (keycode == 62) {
            v.set(0, 0);
            key = keycode;
            return true;
        }
        return false;
    }
}
