package ru.geekbrains.stargame.pool;

import ru.geekbrains.stargame.Base.SpritesPool;
import ru.geekbrains.stargame.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
