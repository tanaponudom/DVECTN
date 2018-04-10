package ctn.example.user.dvectn.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class POJO_test1_in_ag {
    @SerializedName("member_id")
    @Expose
    private String memberId;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("img")
    @Expose
    private String img;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}

