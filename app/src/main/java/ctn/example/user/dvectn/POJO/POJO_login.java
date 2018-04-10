package ctn.example.user.dvectn.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 22/3/2561.
 */

public class POJO_login {

    @SerializedName("member_id")
    @Expose
    private String memberId;
    @SerializedName("member_firstname")
    @Expose
    private String memberFirstname;
    @SerializedName("member_lastname")
    @Expose
    private String memberLastname;
    @SerializedName("member_email")
    @Expose
    private String memberEmail;
    @SerializedName("dep_id")
    @Expose
    private String depId;
    @SerializedName("member_type")
    @Expose
    private String memberType;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberFirstname() {
        return memberFirstname;
    }

    public void setMemberFirstname(String memberFirstname) {
        this.memberFirstname = memberFirstname;
    }

    public String getMemberLastname() {
        return memberLastname;
    }

    public void setMemberLastname(String memberLastname) {
        this.memberLastname = memberLastname;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

}
