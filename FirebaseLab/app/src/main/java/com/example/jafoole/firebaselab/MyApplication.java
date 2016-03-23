package com.example.jafoole.firebaselab;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by
 *  /\     /\      __        _____              __                /\      /\
 * \ \    \ \     |__|____ _/ ____\____   ____ |  |   ____       / /     / /
 * \ \    \ \     |  \__  \\   __\/  _ \ /  _ \|  | _/ __ \     / /     / /
 * \ \    \ \     |  |/ __ \|  | (  <_> |  <_> )  |_\  ___/    / /     / /
 * \ \    \ \ /\__|  (____  /__|  \____/ \____/|____/\___  >  / /     / /
 * \/     \/  \______|    \/                             \/   \/      \/
 * on 3/23/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
