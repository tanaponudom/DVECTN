package com.example.user.dvectn.Retrofit;


import com.example.user.dvectn.POJO.POJO_PJ_P4;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_PJ_P4 {
    public void onResponse(POJO_PJ_P4 assessmentstu4);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
