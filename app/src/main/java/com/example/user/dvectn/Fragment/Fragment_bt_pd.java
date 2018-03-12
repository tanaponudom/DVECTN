//package com.example.user.dvectn.Fragment;
//
//
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
// * Created by User on 20/2/2561.
// */
//
//public class Fragment_bt_pd extends Fragment implements View.OnClickListener {
//    Bundle bn3;
//    String frg1;
//
//    public  static  final String TAG_HEW2 = "HEW2";
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view2 = inflater.inflate(R.layout.av_bt_pd,container,false);
//        bn3 = getArguments();
//
//        if(bn3 != null);
//        {
//            frg1 = bn3.getString(Fragment_mainapp.TAG_HELL);
//        }
//        view2.findViewById(R.id.btn2).setOnClickListener(this);
//        return  view2;
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
//            case R.id.btn2:
//                Bundle bn3 = new Bundle();
//                bn3.putString(TAG_HEW2,"1157");
//
//                Fragment_mainapp av_main_traner = new Fragment_mainapp();
//                av_main_traner.setArguments(bn3);
//                replaceFragment(av_main_traner,bn3);
//
////                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.content,av_main_traner,"name3").commit();
//
//
//                break;
//        }
//    }
//}
