package kr.co.tjenit.beautysalon.datas;

import java.io.Serializable;
import java.util.Calendar;

import kr.co.tjenit.beautysalon.Utiles.DateTimeUtil;

/**
 * Created by the on 2017-07-26.
 */

public class DesignCase implements Serializable {

    private int caseImage;
    private Calendar createdOn;
    private int userRating;
    private Designer designer;
    private User user;
    private int cost;
    private String userReivew;

    public DesignCase() {

    }

    public DesignCase(int caseImage, Calendar createdOn, int userRating, Designer designer, User user, int cost, String userReivew) {
        this.caseImage = caseImage;
        this.createdOn = createdOn;
        this.userRating = userRating;
        this.designer = designer;
        this.user = user;
        this.cost = cost;
        this.userReivew = userReivew;
    }

    public int getCaseImage() {
        return caseImage;
    }

    public void setCaseImage(int caseImage) {
        this.caseImage = caseImage;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getUserReivew() {
        return userReivew;
    }

    public void setUserReivew(String userReivew) {
        this.userReivew = userReivew;
    }

    @Override
    public String toString() {
        String dateTimeStr = DateTimeUtil.getdateTimeString(this.createdOn);
        String str = this.user.getName() + " / "  +  dateTimeStr;
        return str;
    }
}
