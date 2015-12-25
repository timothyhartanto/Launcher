package com.example.proto.launcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
        //first way
//        Intent facebookIntent = getOpenFacebookIntent(this);
//        startActivity(facebookIntent);

        //second way
            //String uri = "https://www.facebook.com/<user_id>";
        String uri = "fb://facewebmodal/f?href=https://www.facebook.com/<user_id>"; // put the profile id here
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));

        startActivity(intent);

        //third way
//        try {
//            PackageManager manager = this.getPackageManager();
//            Intent i = manager.getLaunchIntentForPackage("com.facebook.katana");
//
//            if (i == null) {
//                //throw new PackageManager.NameNotFoundException();
//            }
//            i.addCategory(Intent.CATEGORY_LAUNCHER);
//            this.startActivity(i);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/<user_id>")); //Trys to make intent with FB's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/<user_id>")); //catches and opens a url to the desired page
        }
    }
}
