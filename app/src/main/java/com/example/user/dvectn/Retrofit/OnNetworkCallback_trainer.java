package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJO_row_teacher;
import com.example.user.dvectn.POJO.POJO_trainer;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_trainer {

    public void onResponse(List<POJO_trainer> trainer);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
