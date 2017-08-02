package kr.co.tjenit.beautysalon.datas;

import java.io.Serializable;

/**
 * Created by the on 2017-07-26.
 */

public abstract class Person implements Serializable{
    private String name;
    private int gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
