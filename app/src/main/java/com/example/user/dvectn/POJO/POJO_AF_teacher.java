package com.example.user.dvectn.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class POJO_AF_teacher {
    @SerializedName("member_id")
    @Expose
    private String memberId;
    @SerializedName("dep_id")
    @Expose
    private String depId;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("member_code")
    @Expose
    private String memberCode;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastnamename")
    @Expose
    private String lastnamename;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("score")
    @Expose
    private String score;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastnamename() {
        return lastnamename;
    }

    public void setLastnamename(String lastnamename) {
        this.lastnamename = lastnamename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


}