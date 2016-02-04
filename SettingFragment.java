package com.example.proto.launcher.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proto.launcher.Login;
import com.example.proto.launcher.R;

/**
 * Created by Proto on 1/31/2016.
 */
public class SettingFragment extends Fragment {
    public SettingFragment(){

    }

    Button logout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.setting, container, false);
        logout = (Button)rootView.findViewById(R.id.btnLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = getActivity().getSharedPreferences("loginFile", getActivity().MODE_PRIVATE).edit();
                edit.clear();
                edit.commit();

                Intent i = new Intent(getActivity(), MultiFragment.class);
                getActivity().finish();
                startActivity(i);
            }
        });
        return rootView;
    }



//    public void logout(View v){
//        v.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences.Editor edit = getActivity().getSharedPreferences("loginFile", getActivity().MODE_PRIVATE).edit();
//                edit.clear();
//                edit.commit();
//
//                Intent i = new Intent(getActivity(), MultiFragment.class);
//                getActivity().finish();
//                startActivity(i);
//            }
//        });
//
//    }
}
