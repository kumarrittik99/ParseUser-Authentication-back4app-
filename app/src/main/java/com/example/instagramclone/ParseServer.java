package com.example.instagramclone;

import android.app.Application;
import com.parse.Parse;

public class ParseServer extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("88I1nk4tyP2n0dBrq2JrbY3eCsYqyVvIWPyAWL8D")
                // if defined
                .clientKey("40woL3iL0KsoLEX6ybmiDou1VQ5WMXwCFo36l7vs")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
