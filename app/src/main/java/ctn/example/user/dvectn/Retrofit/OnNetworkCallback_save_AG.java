package ctn.example.user.dvectn.Retrofit;

import ctn.example.user.dvectn.POJO.POJO_save_AG;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_save_AG {
    public void onResponse(List<POJO_save_AG> save_AG);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
