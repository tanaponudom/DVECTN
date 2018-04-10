//package com.example.user.dvectn.Fragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import R;
//
//
///**
// * Created by User on 21/2/2561.
// */
//
//public class Student_page extends Fragment implements View.OnClickListener {
//    Bundle bn_se;
//    String frg_st;
//
//    public  static  final String TAG_STU = "DENT";
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View viewst = inflater.inflate(R.layout.student_page,container,false);
//
//        viewst.findViewById(R.id.btn_bl).setOnClickListener(this);
//        viewst.findViewById(R.id.fab).setOnClickListener(this);
//        bn_se = getArguments();
//        frg_st = bn_se.getString(Fragment_login.TAG_user);
//
//
//
//
//        FloatingActionButton fab = viewst.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()){
//
//                    case R.id.fab:
//                        Bundle bnq = new Bundle();
//                        bnq.putString(TAG_STU,"11587");
////                        ส่วนภายใน Fragment
//                        Snackbar.make(view, "โปรดกรอกข้อมูล", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//
//                        Student_save student_save = new Student_save();
//                        student_save.setArguments(bnq);
//                        replaceFragment(student_save,bnq);
//                        break;
//
//
//
//                }
//            }
//        });
//
//        return viewst;
//    }
//
//    public void replaceFragment(Fragment fragment, Bundle bundle) {
//
//        if (bundle != null)
//            fragment.setArguments(bundle);
//
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        Fragment oldFragment = fragmentManager.findFragmentByTag(fragment.getClass().getName());
//
//        //if oldFragment already exits in fragmentManager use it
//        if (oldFragment != null) {
//            fragment = oldFragment;
//        }
//
//        fragmentTransaction.replace(R.id.content, fragment, fragment.getClass().getName());
//
//        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//
//        fragmentTransaction.commit();
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()){
//            case R.id.btn_bl:
//                Bundle bn = new Bundle();
//                bn.putString(TAG_STU,"1153");
//
//                Fragment_login fragment_login = new Fragment_login();
//                fragment_login.setArguments(bn);
//                replaceFragment(fragment_login,bn);
//                break;
//
//        }
//
//    }
//}
