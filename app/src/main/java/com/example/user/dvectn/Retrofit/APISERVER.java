package com.example.user.dvectn.Retrofit;

import android.support.annotation.FractionRes;

import com.example.user.dvectn.POJO.POJO_Checkdaily;
import com.example.user.dvectn.POJO.POJO_DD_P1;
import com.example.user.dvectn.POJO.POJO_DD_P2;
import com.example.user.dvectn.POJO.POJO_DD_P3;
import com.example.user.dvectn.POJO.POJO_PJ_P1;
import com.example.user.dvectn.POJO.POJO_PJ_P2;
import com.example.user.dvectn.POJO.POJO_PJ_P3;
import com.example.user.dvectn.POJO.POJO_PJ_P4;
import com.example.user.dvectn.POJO.POJO_PJ_P5;
import com.example.user.dvectn.POJO.POJO_PJ_P6;
import com.example.user.dvectn.POJO.POJO_getdata_ebs;
import com.example.user.dvectn.POJO.POJO_getstu;
import com.example.user.dvectn.POJO.POJO_login;
import com.example.user.dvectn.POJO.POJO_studata;
import com.example.user.dvectn.POJO.ResPOJO;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by kritsanrongkaew on 12/3/2018 AD.
 */

public interface APISERVER {

    @FormUrlEncoded
    @POST("login/")
    Call<POJO_login> loginHandle(@Field("username") String first, @Field("password") String last);



    @FormUrlEncoded
    @POST("getstu/")
    Call<List<POJO_getstu>> getSTD(@Field("dep_id") String dep_id);


    @FormUrlEncoded
    @POST("studata/")
    Call<POJO_studata> getDataStd(@Field("token") String first);

    @FormUrlEncoded
    @POST("Checkdaily/")
    Call<POJO_Checkdaily> getDatadaily(@Field("member_id") int first , @Field("app_name") String Sec ,
                                       @Field("app_date") int Thrir , @Field("app_detai") String Four
                                      /* @Field("img") five */);

    @FormUrlEncoded
    @POST("assessmentstu-1/")
    Call<POJO_PJ_P1> getDataPJP1 (@Field("member_id") int first , @Field("ex11") int Sec ,
                                  @Field("ex12") int Thrir);

    @FormUrlEncoded
    @POST("assessmentstu-2/")
    Call<POJO_PJ_P2> getDataPJP2 (@Field("member_id") int first ,@Field("ex21") int Sec ,
                                  @Field("ex22") int Thrir , @Field("ex23") int four ,
                                  @Field("ex24") int five , @Field("ex25") int six ,
                                  @Field("ex26") int seven , @Field("ex27") int eight ,
                                  @Field("ex28") int nine);

    @FormUrlEncoded
    @POST("assessmentstu-3/")
    Call<POJO_PJ_P3> getDataPJP3 (@Field("member_id") int first , @Field("ex31") int Sec ,
                                  @Field("ex32") int Thrir , @Field("ex33") int four ,
                                  @Field("ex34") int five , @Field("ex35") int six ,
                                  @Field("ex36") int seven , @Field("ex37") int eight);

    @FormUrlEncoded
    @POST("assessmentstu-4/")
    Call<POJO_PJ_P4> getDataPJP4 (@Field("member_id") int first , @Field("ex41") int Sec ,
                                  @Field("ex42") int Thrir , @Field("ex43") int four ,
                                  @Field("ex44") int five , @Field("ex45") int six ,
                                  @Field("ex46") int seven , @Field("ex47") int eight);

    @FormUrlEncoded
    @POST("assessmentstu-5/")
    Call<POJO_PJ_P5> getDataPJP5 (@Field("member_id") int first , @Field("ex51") int Sec ,
                                  @Field("ex52") int Thrir , @Field("ex53") int four ,
                                  @Field("ex54") int five , @Field("ex55") int six ,
                                  @Field("ex56") int seven);

    @FormUrlEncoded
    @POST("assessmentstu-6/")
    Call<POJO_PJ_P6> getDataPJP6 (@Field("member_id") int first , @Field("ex61") int Sec ,
                                  @Field("ex62") int Thrir , @Field("ex63") int four ,
                                  @Field("ex64") int five , @Field("ex65") int six ,
                                  @Field("ex66") int seven);

    @FormUrlEncoded
    @POST("getstu/")
    Call<POJO_getstu> getDataPJP5 (@Field("member_id") int first);

    @FormUrlEncoded
    @POST("getdata-ebs/")
    Call<POJO_getdata_ebs> getData_ebs ();

    @FormUrlEncoded
    @POST("affective-1/")
    Call<POJO_DD_P1> getDataDDP1 (@Field("member_id") int first , @Field("ex11") int Sec ,
                                  @Field("ex12") int Thrir , @Field("ex13") int four ,
                                  @Field("ex14") int five , @Field("ex15") int six ,
                                  @Field("ex21") int seven);

    @FormUrlEncoded
    @POST("affective-2/")
    Call<POJO_DD_P2> getDataDDP2 (@Field("member_id") int first , @Field("ex22") int Sec ,
                                  @Field("ex23") int Thrir , @Field("ex24") int four ,
                                  @Field("ex25") int five , @Field("ex26") int six ,
                                  @Field("ex27") int seven , @Field("ex28") int eight);

    @FormUrlEncoded
    @POST("affective-3/")
    Call<POJO_DD_P3> getDataDDP3 (@Field("member_id") int first , @Field("ex31") int Sec ,
                                  @Field("ex32") int Thrir , @Field("ex33") int four ,
                                  @Field("ex34") int five , @Field("ex35") int six ,
                                  @Field("ex36") int seven , @Field("ex37") int eight);

    @Multipart
    @POST("upload/")
    Call<ResPOJO> updateImageProfile(@Part MultipartBody.Part image,
                                     @Part("memberid") String memberid,
                                     @Part("app_name") String name,
                                     @Part("app_detail") String detail
    );

}
