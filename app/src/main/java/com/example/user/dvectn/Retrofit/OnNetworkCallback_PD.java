package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJO_Checkdaily;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_PD {

    public void onResponse( );
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
