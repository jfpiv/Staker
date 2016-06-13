package be.staker.pojo;

import be.staker.util.Util;

/**
 * Created by u0098595 on 13/06/2016.
 */
public class Dds extends Weapon implements Special {
    private int addSpec;
    private int decreaseSpec;

    public Dds(){
        addSpec = 5;
        decreaseSpec = 25;
    }

    @Override
    public int getValue() {
        return 20000;
    }

    public int getHit() {
        return Util.randInt(0, 60);
    }

    public int getHit2() {
        return Util.randInt(0, 20);
    }

    @Override
    public int getDecreaseSpec() {
        return decreaseSpec;
    }
}
