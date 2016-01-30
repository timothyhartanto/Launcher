package com.example.proto.launcher.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.proto.launcher.R;

public class MultiFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_fragment);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.menuContainer, new MenuFragment()).commit();
        }
    }
}
