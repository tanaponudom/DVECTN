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
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.user.dvectn.R;
//
//
//
///**
// * Created by User on 20/2/2561.
// */
//
//public class Fragment_bt_d extends Fragment implements View.OnClickListener{
//    Bundle bn;
//    String frg2;
//    TextView TV_2;
//
//    public  static  final String TAG_HEW = "HEW";
//
//
//
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view1 = inflater.inflate(R.layout.av_bt_d,container,false);
//        bn = getArguments();
//        if(bn != null){
//            frg2 = bn.getString(Fragment_mainapp.TAG_HELL);
//        }
//        view1.findViewById(R.id.btn1).setOnClickListener(this);
//
//
//        Toast.makeText(getContext(), "หน้าเช็คชื่อนักเรียน", Toast.LENGTH_SHORT).show();
//
//        return view1;
//
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
//      @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.btn1:
//                Bundle bn = new Bundle();
//                bn.putString(TAG_HEW,"1156");
//
//                Fragment_mainapp av_main_traner = new Fragment_mainapp();
//                av_main_traner.setArguments(bn);
//
//
////                getActiviity().getSupportFragmentManager().beginTransaction().add(R.id.content,av_main_traner,"name2").commit();
//                break;
//
//        }
//
//    }
//}
