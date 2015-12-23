package com.example.proto.launcher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Launch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcch);
    }


    public void launchApp(View v){
        try {
            PackageManager manager = this.getPackageManager();
            Intent i = manager.getLaunchIntentForPackage("com.facebook.katana");
            if (i == null) {
                //throw new PackageManager.NameNotFoundException();
            }
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            this.startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
