    package ru.geekbrains.stargame.Screen;

    import com.badlogic.gdx.Game;
    import com.badlogic.gdx.Gdx;
    import com.badlogic.gdx.audio.Music;
    import com.badlogic.gdx.audio.Sound;
    import com.badlogic.gdx.graphics.GL20;
    import com.badlogic.gdx.graphics.Texture;
    import com.badlogic.gdx.graphics.g2d.TextureAtlas;
    import com.badlogic.gdx.graphics.g2d.TextureRegion;
    import com.badlogic.gdx.math.Vector2;
    import ru.geekbrains.stargame.Base.BaseScreen;
    import ru.geekbrains.stargame.math.Rect;
    import ru.geekbrains.stargame.sprite.Background;
    import ru.geekbrains.stargame.sprite.ButtonExit;
    import ru.geekbrains.stargame.sprite.ButtonPlay;
    import ru.geekbrains.stargame.sprite.Star;

    public class MenuScreen extends BaseScreen {

        private static final int STAR_COUNT = 256;

        private Sound sound;
        private Music music;
        public static  float musicPos;
        private Game game;

        private TextureAtlas atlas;
        private Texture bg;
        private Background background;

        private Star[] starArray;
        private ButtonExit buttonExit;
        private ButtonPlay buttonPlay;

        public MenuScreen(Game game) {
            this.game = game;
        }

        @Override
        public void show() {
            super.show();
            atlas = new TextureAtlas("textures/menuAtlas.tpack");
            bg = new Texture("back.jpg");
            background = new Background(new TextureRegion(bg));
            starArray = new Star[STAR_COUNT];
            for (int i = 0; i < STAR_COUNT; i++) {
                starArray[i] = new Star(atlas);
            }
            sound = Gdx.audio.newSound(Gdx.files.internal("sounds/laser.wav"));
            music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
            buttonExit = new ButtonExit(atlas);
            buttonPlay = new ButtonPlay(atlas, game);
            music.play();
        }

        @Override
        public void resize(Rect worldBounds) {
            background.resize(worldBounds);
            for (Star star : starArray) {
                star.resize(worldBounds);
            }
            buttonExit.resize(worldBounds);
            buttonPlay.resize(worldBounds);
        }

        @Override
        public void render(float delta) {
            super.render(delta);
            update(delta);
            draw();
        }

        @Override
        public void dispose() {
            atlas.dispose();
            bg.dispose();
            music.dispose();
            super.dispose();
        }

        @Override
        public boolean touchDown(Vector2 touch, int pointer, int button) {
            buttonExit.touchDown(touch, pointer, button);
            buttonPlay.touchDown(touch, pointer, button);
            return false;
        }

        @Override
        public boolean touchUp(Vector2 touch, int pointer, int button) {
            buttonExit.touchUp(touch, pointer, button);
            buttonPlay.touchUp(touch, pointer, button);
            return false;
        }

        private void update(float delta) {
            for (Star star : starArray) {
                star.update(delta);
            }
        }

        private void draw() {
            Gdx.gl.glClearColor(0.26f, 0.5f, 0.8f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            background.draw(batch);
            for (Star star : starArray) {
                star.draw(batch);
            }
            buttonExit.draw(batch);
            buttonPlay.draw(batch);
            batch.end();
        }

        public float getMusicPos() {
            return musicPos;
        }
    }