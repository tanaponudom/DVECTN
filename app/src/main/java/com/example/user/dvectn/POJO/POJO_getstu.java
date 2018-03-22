package com.example.user.dvectn.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 22/3/2561.
 */

public class POJO_getstu {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastnamename")
    @Expose
    private String lastnamename;
    @SerializedName("type")
    @Expose
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}