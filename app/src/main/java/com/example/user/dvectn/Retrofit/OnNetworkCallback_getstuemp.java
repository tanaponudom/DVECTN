package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJO_DD_P2;
import com.example.user.dvectn.POJO.POJO_getstuemp;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_getstuemp {

    public void onResponse(List<POJO_getstuemp> getstuemp);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
