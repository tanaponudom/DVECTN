package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJO_PJ_P1;
import com.example.user.dvectn.POJO.POJO_PJ_P2;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_PJ_P2 {
    public void onResponse(POJO_PJ_P2 assessmentstu2);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
