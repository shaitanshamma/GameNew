package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.Base.Sprite;
import ru.geekbrains.stargame.math.Rect;

public class StarShip extends Sprite {
    private static final float V_LEN = 0.1f;
    private Vector2 v;
    private Rect worldBounds;
    private Game game;
    private Vector2 stpos;
    private Vector2 endPos;
    int pointer;
    int button;
    int key;
    // private Vector2 v;
    private Vector2 buf;


    public StarShip(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("main_ship"));
        this.game = game;
        stpos = new Vector2();
        endPos = new Vector2();
        v = new Vector2();
        buf = new Vector2();
        setHeightProportion(0.22f);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setBottom(worldBounds.getBottom() + 0.01f);
    }

    @Override
    public void update(float delta) {
        checkBounds();
        buf.set(endPos);
        if (keyDown(key)){
            System.out.println(key + " ryjgrf");
            pos.mulAdd(v, delta);
        }else if(buf.sub(pos).len2()>V_LEN){
            pos.mulAdd(v,delta);
         }else {
            pos.set(endPos);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.pointer=pointer;
        this.button = button;
        endPos.set(touch);
        v.set(endPos.sub(pos)).setLength(V_LEN);
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

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return false;
    }

    private void checkBounds() {
//        if (getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
//        if (getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());
//        if (getTop() < worldBounds.getBottom()) setBottom(worldBounds.getTop());
//
    }
}

