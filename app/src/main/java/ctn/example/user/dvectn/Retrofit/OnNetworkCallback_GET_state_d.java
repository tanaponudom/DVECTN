package ctn.example.user.dvectn.Retrofit;

import ctn.example.user.dvectn.POJO.POJOGetDaily;

import java.util.List;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_GET_state_d {

    public void onResponse(List<POJOGetDaily> getDailies);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);

}
