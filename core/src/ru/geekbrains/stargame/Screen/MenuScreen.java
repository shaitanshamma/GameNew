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
    private Vector2 change;
    private Vector2 pos;
    private Vector2 up;
    private Vector2 down;

    @Override
    public void show() {
        super.show();
        img = new Texture("7d9.gif");
        back = new Texture("background.jpg");
        touch = new Vector2();
        change = new Vector2();
        v = new Vector2();
        pos = new Vector2();
        up = new Vector2();
        down = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        pos.add(change.nor());
        Gdx.gl.glClearColor(0.26f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        down.add(up);
        batch.draw(back, 0, 0);
//
//        if (Math.round(pos.len()) != Math.round(touch.len())) {
//            batch.draw(img, pos.x, pos.y, 150, 150);
//
//        } else if (Math.round(pos.len()) == Math.round(touch.len())&& Math.toDegrees(Math.acos(pos.cpy().nor().dot(touch.cpy().nor())))==0 ) {
//            change.set(0, 0);
//            pos.set(touch.x, touch.y);
//            batch.draw(img, pos.x, pos.y, 150, 150);
//        }
        if (Math.toDegrees(Math.acos(pos.cpy().nor().dot(touch.cpy().nor())))!=0) {
            batch.draw(img, pos.x, pos.y, 150, 150);

        } else if (Math.toDegrees(Math.acos(pos.cpy().nor().dot(touch.cpy().nor())))==0 ) {
            change.set(0, 0);
            pos.set(touch.x, touch.y);
            batch.draw(img, pos.x, pos.y, 150, 150);
        }
//        pos.set(Math.round(pos.x),Math.round(pos.y));
//        if (Math.round(pos.x) != Math.round(touch.x)&&Math.round(pos.y) != Math.round(touch.y)) {
//            batch.draw(img, pos.x, pos.y, 150, 150);
//
//        } else if (Math.round(pos.x) == Math.round(touch.x)&&Math.round(pos.y) == Math.round(touch.y)&& Math.toDegrees(Math.acos(pos.cpy().nor().dot(touch.cpy().nor())))==0 ) {
//            change.set(0, 0);
//            pos.set(touch.x, touch.y);
//            batch.draw(img, pos.x, pos.y, 150, 150);
//        }

        System.out.println(pos.x);
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
        change.set(screenX, Gdx.graphics.getHeight() - screenY);
        change.sub(pos);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 19) {
            change.set(0, 1);
        } else if (keycode == 20) {
            change.set(0, -1);
        } else if (keycode == 22) {
            change.set(1, 0);
        } else if (keycode == 21) {
            change.set(-1, 0);
        } else if (keycode == 62) {
            change.set(0, 0);
        }
        return super.keyDown(keycode);
    }
}
