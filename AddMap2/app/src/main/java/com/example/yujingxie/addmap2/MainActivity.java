
package com.example.yujingxie.addmap2;

import android.app.TabActivity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;
import android.support.v7.app.ActionBar;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.content.res.Resources;

public class MainActivity extends TabActivity{



        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
           Resources ressources = getResources();
            TabHost tabHost = getTabHost();

            Intent intentMap = new Intent().setClass(this, MapsActivity.class);
            TabSpec tabSpecMap = tabHost
                    .newTabSpec("Maps")
                    .setIndicator("")
                    .setContent(intentMap);

            Intent intentReport= new Intent().setClass(this, ReportWaterActivity.class);
            TabSpec tabSpecReport = tabHost
                    .newTabSpec("Maps")
                    .setIndicator("")
                    .setContent(intentReport);

            tabHost.addTab(tabSpecMap);
            tabHost.addTab(tabSpecReport);
            tabHost.setCurrentTab(0);

            // Determine whether the current user is an anonymous user
            if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
                // If user is anonymous, send the user to LoginSignupActivity.class
                Intent intent = new Intent(MainActivity.this,
                        LoginSignupActivity.class);
                startActivity(intent);
                finish();
            } else {
                // If current user is NOT anonymous user
                // Get current user data from Parse.com
                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser != null) {
                    // Send logged in users to Welcome.class
                    Intent intent = new Intent(MainActivity.this, Welcome.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Send user to LoginSignupActivity.class
                    Intent intent = new Intent(MainActivity.this,
                            LoginSignupActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        }
    }

