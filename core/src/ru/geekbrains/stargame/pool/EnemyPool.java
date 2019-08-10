package ru.geekbrains.stargame.pool;

import ru.geekbrains.stargame.Base.SpritesPool;
import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.sprite.Enemy;
import ru.geekbrains.stargame.sprite.MainShip;

public class EnemyPool extends SpritesPool<Enemy> {
    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private Rect worldBounds;
    private MainShip mainShip;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, MainShip mainShip) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
        this.mainShip = mainShip;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, explosionPool, worldBounds, mainShip);
    }

}
