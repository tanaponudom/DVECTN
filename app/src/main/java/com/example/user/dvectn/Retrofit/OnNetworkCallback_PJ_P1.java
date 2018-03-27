package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJO_PJ_P1;
import com.example.user.dvectn.POJO.POJO_login;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_PJ_P1 {

    public void onResponse(POJO_PJ_P1 assessmentstu1);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
