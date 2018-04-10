package ctn.example.user.dvectn.Retrofit;

import ctn.example.user.dvectn.POJO.POJO_getstuemp;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_getstuemp {

    public void onResponse(List<POJO_getstuemp> getstuemp);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
