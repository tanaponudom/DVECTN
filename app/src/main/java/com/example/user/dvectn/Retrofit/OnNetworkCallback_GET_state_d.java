package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJOGetDaily;
import com.example.user.dvectn.POJO.POJO_DD_P3;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_GET_state_d {

    public void onResponse(List<POJOGetDaily> getDailies);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);

}
