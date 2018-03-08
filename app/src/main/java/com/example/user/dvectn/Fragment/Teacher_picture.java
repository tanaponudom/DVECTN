//package com.example.user.dvectn.Fragment;
//
//import android.icu.text.Replaceable;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
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
//public class Teacher_picture extends Fragment implements View.OnClickListener {
//    Bundle bn_pc;
//    String frg_pc;
//
//    public  static  final String TAG_STUPC = "STUPC";
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//       View viewpc = inflater.inflate(R.layout.student_picture,container,false);
//        viewpc.findViewById(R.id.btn_pc).setOnClickListener(this);
//        bn_pc = getArguments();
//
//        if (bn_pc != null){
//            frg_pc = bn_pc.getString(Student_page.TAG_STU);
//        }
//       return viewpc;
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
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.btn_pc:
//                Bundle bn_pc = new Bundle();
//                bn_pc.getString(TAG_STUPC);
//
//                Student_page student_page = new student_page();
//                student_page.setArguments(bn_pc);
//                replaceFragment(student_page,bn_pc);
//                break;
//
//        }
//
//    }
//}
