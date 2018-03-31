package com.example.user.dvectn;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.user.dvectn.Fragment.Fragment_login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.content, new Fragment_login(), "login").commit();

        Fragment_login fragment_login = new Fragment_login();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content, fragment_login).addToBackStack(null).commit();
    }


        private void Exit(){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("คำเตือน");
            builder.setMessage("คุณต้องการออกจากแอพ ?");

            builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });

            builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }


        private void Logout(){

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("คำเตือน");
            builder.setMessage("Logout ?");

            builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.popBackStack();
                }
            });

            builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }

    @Override
    public void onBackPressed() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        int co = fragmentManager.getBackStackEntryCount();

        if(co > 1 ){
                fragmentManager.popBackStack();
        }else{
                Exit();
            }

        String tmp = ""+fragmentManager.findFragmentById(R.id.content);
        String frgLogin = "Fragment_login";
//        Toast.makeText(this, ""+tmp, Toast.LENGTH_SHORT).show();

//        try {
//            if(co > 1 ){
//                fragmentManager.popBackStack();
//            }else if(!tmp.substring(0,13).equals(frgLogin.substring(0,13))){
//                Logout();
//            }else{
//                Exit();
//            }
//
//        }catch (Exception e){
//
//            if(co > 1 ){
//                fragmentManager.popBackStack();
//            }
//
//        }




    }
}
