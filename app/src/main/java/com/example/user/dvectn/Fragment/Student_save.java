package com.example.user.dvectn.Fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.dvectn.POJO.ResPOJO;
import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_Student_Recycel;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallbackListener;
import com.kbeanie.multipicker.api.ContactPicker;
import com.kbeanie.multipicker.api.ImagePicker;
import com.kbeanie.multipicker.api.Picker;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;


/**
 * Created by User on 21/2/2561.
 */
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import static android.app.Activity.RESULT_OK;

public class Student_save extends Fragment implements View.OnClickListener {
    String Detail;
    EditText et_ins;
    EditText et_title;
    String frg_sa;
    ImagePicker imagePicker;
    ImageView imageView;
    Context context;
    String user_id = "";
    MultipartBody.Part body;
    RequestBody name;
    ProgressDialog progressDialog;
    Button btn_up;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    public static final String TAG_STUSA = "STUSAVE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewses = inflater.inflate(R.layout.student_save, container, false);



        init(viewses);

        return viewses;
    }

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content, fragment).addToBackStack(null).commit();


    }

    private void init(View view) {

        et_title=view.findViewById(R.id.et_title);
        et_ins=view.findViewById(R.id.et_in);
        view.findViewById(R.id.btn_se).setOnClickListener(this);
        view.findViewById(R.id.btn_up).setOnClickListener(this);
        btn_up = view.findViewById(R.id.btn_up);

        btn_up.setEnabled(false);

        imageView = view.findViewById(R.id.img_1);

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        user_id = ""+ sharedPreferences.getInt(Fragment_login.KEY_member_id,0);

        context = getContext();

        imagePicker = new ImagePicker(this);

        imagePicker.allowMultiple(); //เลือกหลายภาพ

        imagePicker.setImagePickerCallback(new ImagePickerCallback() {

                                               @Override
                                               public void onImagesChosen(List<ChosenImage> list) {
                                                   // Do something
                                                   // get path and create file.
                                                   String path = list.get(0).getOriginalPath();
                                                   File file = new File(path);

                                                   // convert file to bitmap and set to imageView.
                                                   if (file.exists()) {

                                                       Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                                                       imageView.setImageBitmap(myBitmap);

//                          img = RequestBody.create(MediaType.parse("image/jpeg"), file);

                                                       RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
                                                       body = MultipartBody.Part.createFormData("image", file.getName(), reqFile);
                                                       name = RequestBody.create(MediaType.parse("text/plain"), "upload_test");


                                                       btn_up.setEnabled(true);

                                                   }
                                               }

                                               @Override
                                               public void onError(String message) {
                                                   // Do error handling
                                               }
                                           }
        );


    }


    private void callServerUploadImageProfile(MultipartBody.Part img,
                                              int member_id
                                             , String app_name
                                                , String app_detail) {
//        Toast.makeText(context, ""+member_id, Toast.LENGTH_SHORT).show();

        new NetworkConnectionManager().pushImage(listener, img, member_id, app_name, app_detail);
    }

    OnNetworkCallbackListener listener = new OnNetworkCallbackListener() {
        @Override
        public void onResponse(ResPOJO user, Retrofit retrofit) {

            String state = user.getStatus();
            Toast.makeText(context, ""+state, Toast.LENGTH_SHORT).show();
            if (state.equals("success")) {
                Toast.makeText(context, "บันทึกข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();
//                showImg(user.getUrl());

            } else {
                Toast.makeText(context, "บันทึกข้อมูลล้มเหลว", Toast.LENGTH_SHORT).show();
            }

            if (progressDialog.isShowing()) {
                progressDialog.dismiss();

            }

        }

        @Override
        public void onBodyError(ResponseBody responseBodyError) {
            Toast.makeText(context, "ResponseBody", Toast.LENGTH_SHORT).show();
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

        @Override
        public void onBodyErrorIsNull() {
            Toast.makeText(context, "ResponseBody", Toast.LENGTH_SHORT).show();
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

        @Override
        public void onFailure(Throwable t) {
            Toast.makeText(context, "ResponseBody"+t.getMessage(), Toast.LENGTH_SHORT).show();
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    };


    private void onSelect() {

        imagePicker.pickImage();

    }

    private void onUpload() {



        Detail = et_ins.getText().toString();

        if (Detail.isEmpty()){
            Toast.makeText(context, "กรุณากรอกข้อมูล", Toast.LENGTH_SHORT).show();


        }
        else {

            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Loading.......");
            progressDialog.show();

            callServerUploadImageProfile(body, Integer.parseInt(user_id), et_title.getText().toString(), Detail);

        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == Picker.PICK_IMAGE_DEVICE) {
                imagePicker.submit(data);
            }
        }
    }
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this.getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(context, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this.getActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }
    }


    private void showImg(String url) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dialog_layout, null);
        ImageView imageView = view.findViewById(R.id.imgShow);

        Picasso.with(context).load(url).into(imageView);

        builder.setView(view);

        builder.setNegativeButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();


    }



    @Override
    public void onClick (View view){
        switch (view.getId()) {
            case R.id.btn_se:
                onSelect();
                break;
            case R.id.btn_up:
                onUpload();
                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (checkPermission())
            {
                // Code for above or equal 23 API Oriented Device
                // Your Permission granted already .Do next code
            } else {
                requestPermission(); // Code for permission
            }
        }
        else
        {

            // Code for Below 23 API Oriented Device
            // Do next code
        }
    }
}
