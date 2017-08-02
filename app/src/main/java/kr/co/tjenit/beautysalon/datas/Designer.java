package kr.co.tjenit.beautysalon.datas;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by the on 2017-07-26.
 */

public class Designer extends Person implements Serializable {
    private String nickName;
    private int majorAge;
    private float avgRating;
    private ArrayList<DesignCase> portFolio;

    public Designer() {

    }

    public Designer(String name, int gender, String nickName, int majorAge, float avgRating, ArrayList<DesignCase> portFolio) {
        setName(name);
        setGender(gender);
        this.nickName = nickName;
        this.majorAge = majorAge;
        this.avgRating = avgRating;
        this.portFolio = portFolio;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getMajorAge() {
        return majorAge;
    }

    public void setMajorAge(int majorAge) {
        this.majorAge = majorAge;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

    public ArrayList<DesignCase> getPortFolio() {
        return portFolio;
    }

    public void setPortFolio(ArrayList<DesignCase> portFolio) {
        this.portFolio = portFolio;
    }

    @Override
    public String toString() {
        String returningStr = this.nickName + " / " + this.avgRating;
        return returningStr;
    }
}
