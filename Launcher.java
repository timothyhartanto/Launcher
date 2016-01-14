package com.example.proto.launcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Launch extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcch);
    }

    public void launchAppTwitter(View v){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("twitter://user?screen_name="));
            startActivity(intent);

        }catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/#!/")));
        }
    }

    public void launchApp(View v){
        //first way
        Intent facebookIntent = getOpenFacebookIntent(this);
        startActivity(facebookIntent);

        //second way
            //String uri = "https://www.facebook.com/timmy.hartanto";
//        String uri = "fb://facewebmodal/f?href=https://www.facebook.com/"; // put the profile id here
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//
//        startActivity(intent);

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
                    Uri.parse("fb://profile/xxxxx")); //Trys to make intent with FB's URI /254175194653125
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/xxxx")); // note: the xxx is the facebook name(link)
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://www.facebook.com/")); //catches and opens a url to the desired page
        }
    }

    /* make the API call */
//    new GraphRequest(
//            AccessToken.getCurrentAccessToken(),
//    "/me/friendrequests",
//            null,
//    HttpMethod.GET,
//            new GraphRequest.Callback() {
//        public void onCompleted(GraphResponse response) {
//            /* handle the result */
//        }
//    }
//    ).executeAsync();
}
