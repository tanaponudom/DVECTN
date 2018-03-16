package com.example.user.dvectn.Retrofit;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

/**
 * Created by kritsanrongkaew on 12/3/2018 AD.
 */

public class Login {

    @SerializedName("accesstoken")
    @Expose
    private String accesstoken;

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

}
