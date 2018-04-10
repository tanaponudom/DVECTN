package ctn.example.user.dvectn.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class POJO_row_teacher {

    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
