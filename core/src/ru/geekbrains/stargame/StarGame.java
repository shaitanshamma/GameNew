package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.geekbrains.stargame.Screen.GameScreen;
import ru.geekbrains.stargame.Screen.MenuScreen;

public class StarGame extends Game {

    public MenuScreen menuScreen;
    public GameScreen gameScreen;

    @Override
    public void create() {
       // gameScreen = new GameScreen(this);
        menuScreen = new MenuScreen(this);
        setScreen(menuScreen);
    }
}