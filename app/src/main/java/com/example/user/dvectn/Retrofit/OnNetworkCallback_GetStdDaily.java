package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJOGetDaily;


import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_GetStdDaily {
    public void onResponse(List<POJOGetDaily> Checkdaily);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
