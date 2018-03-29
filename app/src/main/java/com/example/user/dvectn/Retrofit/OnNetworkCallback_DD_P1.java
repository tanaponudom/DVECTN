package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJO_DD_P1;


import okhttp3.ResponseBody;

public interface OnNetworkCallback_DD_P1 {

    public void onResponse(POJO_DD_P1 assessmentstu1);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
