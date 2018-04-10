package ctn.example.user.dvectn.Retrofit;

import ctn.example.user.dvectn.POJO.POJO_getstu;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by User on 26/3/2561.
 */

public interface OnNetworkCallBackGetStd {

    public void onResponse(List<POJO_getstu> getstu);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);


}
