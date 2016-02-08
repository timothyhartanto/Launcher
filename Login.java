package com.example.proto.launcher.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.proto.launcher.Login;
import com.example.proto.launcher.R;

public class MultiFragment extends AppCompatActivity {
    public static String PREF_NAME = "loginFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Restore preferences
        SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        getPref(PREF_NAME, this);
        boolean already_logged_in = sp.getBoolean("loggedIn", false);

        if(!already_logged_in){
            Intent i = new Intent(MultiFragment.this, Login.class);
            startActivity(i);
        }
        if(already_logged_in){
            String username = sp.getString("userName", null);
            String password = sp.getString("password", null);
            Login.AttemptLogin login = new Login().new AttemptLogin();
            login.execute(username, password);
        }

        setContentView(R.layout.multi_fragment);

            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.menuContainer, new MenuFragment()).commit();
            }

    }

    public static SharedPreferences getPref(String file, Context context){
        return context.getSharedPreferences(file, Context.MODE_PRIVATE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Restore preferences
        SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        boolean already_logged_in = sp.getBoolean("loggedIn", false);

        if(already_logged_in){

        }
    }
}
