package com.example.proto.launcher.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proto.launcher.R;

public class MenuFragment extends Fragment {

    Fragment frag;
    FragmentTransaction fragmentTransaction;
    Button btnUser, btnFriends, btnAddFriend, btnSetting;

    public MenuFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment ,container, false);

        frag = new UserFragment();
        fragmentTransaction = getFragmentManager().beginTransaction().add(R.id.container, frag);
        fragmentTransaction.commit();

        btnUser = (Button)view.findViewById(R.id.btnUser);
        btnFriends = (Button)view.findViewById(R.id.btnFriends);
        btnAddFriend = (Button)view.findViewById(R.id.btnAddFriend);
        btnSetting = (Button)view.findViewById(R.id.btnSetting);

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuBtnOnClick("user");
            }
        });

        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuBtnOnClick("friends");
            }
        });

        btnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuBtnOnClick("add friend");
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuBtnOnClick("setting");
            }
        });
        return view;
    }

    private void menuBtnOnClick(String btn){
        switch(btn){
            case "user":
                frag = new UserFragment();
                break;
            case "friends":
                frag = new FriendsFragment();
                break;
            case "add friend":
                frag = new AddFriendFragment();
                break;
            case "setting":
                frag = new SettingFragment();
                break;
        }
        fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, frag);
        fragmentTransaction.commit();
    }
}
