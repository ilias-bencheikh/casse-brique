package entity.brick;

import geometry.Coordinates;

public class BrickClassic extends Brick {

    public static final int BASE_DURABILITY = 100;

    public BrickClassic(Coordinates c) {
        super(c, BASE_DURABILITY);
    }
}
