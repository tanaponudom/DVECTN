package com.example.user.dvectn.Retrofit;


import com.example.user.dvectn.POJO.POJO_PJ_P5;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_PJ_P5 {
    public void onResponse(POJO_PJ_P5 assessmentstu5);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
