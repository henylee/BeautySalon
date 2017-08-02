package kr.co.tjenit.beautysalon.datas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by the on 2017-07-26.
 */

public class User extends Person implements Serializable {
    private Calendar birthDay;
    private ArrayList<Designer> likeDesigners;
    private String profilePicture;

    // user 클래스 객체들이 intent.putExtra => Intent에 첨부되어 전송될 수 있도록 하는 구분

    public User() {

    }

    public User(String name, int gender, Calendar birthDay, ArrayList<Designer> likeDesigners, String pass) {
        setName(name);
        setGender(gender);
        this.birthDay = birthDay;
        this.likeDesigners = likeDesigners;
        this.profilePicture = pass;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Calendar getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Calendar birthDay) {
        this.birthDay = birthDay;
    }

    public ArrayList<Designer> getLikeDesigners() {
        return likeDesigners;
    }

    public void setLikeDesigners(ArrayList<Designer> likeDesigners) {
        this.likeDesigners = likeDesigners;
    }
}
