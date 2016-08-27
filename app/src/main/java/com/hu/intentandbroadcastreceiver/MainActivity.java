package com.hu.intentandbroadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCall();
            }
        });
        Animal animal = getCat();
        animal.eat();
        animal.run();
        animal.play();
        Mammals mammals = new Dog();
        mammals.getMethod();


    }

    private void startCall() {
        sendBroadcast(new Intent("com.hu.testreceiver"), "com.hu.myreceiver.permission");

//        String action = Intent.ACTION_BUG_REPORT;
//        Intent intent = new Intent(action);
//        Log.d(TAG, "Action:" + action);
//        PackageManager pm = getPackageManager();
//        ComponentName cn = intent.resolveActivity(pm);
//        if (null == cn) {
//            Log.d(TAG, "show all app activity is not exist!");
//        } else {
//            startActivity(intent);
//        }

    }

    public Animal getCat() {
        return new Cat();
    }


    private class Cat implements Animal {

        @Override
        public void eat() {
            Log.d(TAG, "cat eat");
        }

        @Override
        public void run() {
            Log.d(TAG, "cat run");
        }

        @Override
        public void play() {
            Log.d(TAG, "cat play");
        }
    }
}
