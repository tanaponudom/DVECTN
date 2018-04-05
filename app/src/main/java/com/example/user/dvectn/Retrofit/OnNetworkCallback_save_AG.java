package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJO_save_AG;
import com.example.user.dvectn.POJO.POJO_save_data_trainer;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_save_AG {
    public void onResponse(List<POJO_save_AG> save_AG);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
