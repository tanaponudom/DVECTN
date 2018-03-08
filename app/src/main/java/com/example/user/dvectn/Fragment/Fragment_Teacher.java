//package com.example.user.dvectn.Fragment;
//
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
//
//import com.example.user.dvectn.R;
//
///**
// * Created by User on 21/2/2561.
// */
//
//public class Fragment_Teacher extends Fragment implements View.OnClickListener {
//    Bundle bd_tch;
//    String str_tch;
//    public static final String TAG_TCH="TCH";
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View viewtch = inflater.inflate(R.layout.teacher_layout,container,false);
//        viewtch.findViewById(R.id.btn_th).setOnClickListener(this);
//        viewtch.findViewById(R.id.fab1).setOnClickListener(this);
//        bd_tch = getArguments();
//        str_tch = bd_tch.getString(Fragment_login.TAG_user);
//
//        FloatingActionButton fab1 = viewtch.findViewById(R.id.fab1);
//        fab1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()){
//                    case R.id.fab1:
//                        Bundle bgh = new Bundle();
//                        bgh.putString(TAG_TCH,"147258");
//
//                        Snackbar.make(view, "โปรดกรอกข้อมูล", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//
//                        Fragment_Teacher fragment_teacher = new Fragment_Teacher();
//                        fragment_teacher.setArguments(bgh);
//                        replaceFragment(fragment_teacher,bgh);
//                        break;
//                }
//            }
//        });
//        return viewtch;
//
//
//
//    }
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
//        switch (view.getId()){
//            case R.id.btn_th:
//                Bundle bg = new Bundle();
//                bg.putString(TAG_TCH,"123458");
//
//                Fragment_login fragment_login = new Fragment_login();
//                fragment_login.setArguments(bg);
//                replaceFragment(fragment_login,bg);
//                break;
//
//
//        }
//
//    }
//}
//
//
//
//
