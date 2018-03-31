package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJO_AF_teacher;
import com.example.user.dvectn.POJO.POJO_DD_P1;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_AF_teacher {
    public void onResponse(List<POJO_AF_teacher> getnite);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
