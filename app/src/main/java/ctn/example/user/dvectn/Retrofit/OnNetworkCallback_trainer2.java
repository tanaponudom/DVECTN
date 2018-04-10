package ctn.example.user.dvectn.Retrofit;

import ctn.example.user.dvectn.POJO.POJO_trainer2;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_trainer2 {
    public void onResponse(List<POJO_trainer2> trainer2);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
