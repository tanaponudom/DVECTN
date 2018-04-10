package ctn.example.user.dvectn.Retrofit;

import ctn.example.user.dvectn.POJO.POJO_confirm_AG;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_confirm_AG {

    public void onResponse(List<POJO_confirm_AG> confirm_ag);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
