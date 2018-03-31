package com.example.user.dvectn.Retrofit;


import com.example.user.dvectn.POJO.POJO_Stu_naja_gogo;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_Stu_naja_gogo {
    public void onResponse(List<POJO_Stu_naja_gogo> stu_naja_gogo);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}

