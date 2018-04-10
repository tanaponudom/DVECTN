package ctn.example.user.dvectn.Retrofit;

import ctn.example.user.dvectn.POJO.POJO_test1_in_ag;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_test1_in_ag {
    public void onResponse(POJO_test1_in_ag test1);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
