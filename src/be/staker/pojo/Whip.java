package be.staker.pojo;

import be.staker.util.Util;

/**
 * Created by u0098595 on 13/06/2016.
 */
public class Whip extends Weapon {

    public Whip(){}

    public int getValue(){
        return 5000000;
    }

    public int getHit(){
        return Util.randInt(0, 26);
    }
}
