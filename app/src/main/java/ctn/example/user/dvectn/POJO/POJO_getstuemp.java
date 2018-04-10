package ctn.example.user.dvectn.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class POJO_getstuemp  {

    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("member_id")
    @Expose
    private String memberId;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("check_nited")
    @Expose
    private String checkNited;
    @SerializedName("img")
    @Expose
    private String img;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCheckNited() {
        return checkNited;
    }

    public void setCheckNited(String checkNited) {
        this.checkNited = checkNited;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
