package ctn.example.user.dvectn.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kritsanrongkaew on 14/3/2018 AD.
 */

public class ResPOJO {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("url")
    @Expose
    private String url;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
