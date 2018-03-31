package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJOGetDaily;
import com.example.user.dvectn.POJO.POJO_Stu_naja;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_Stu_naja {
    public void onResponse(List<POJO_Stu_naja> stu_naja);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
