package com.xqli.testaprofiler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = "AProfiler";

    private MyHandler mMyHandler = new MyHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: " + this);
        InstatnceTest.getInstatnce(this);
        mMyHandler.sendEmptyMessageDelayed(1,10*1000);
    }
    
    
    protected void print(){
        Log.d(TAG, "print: " + this);
    }


    private class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage: " + msg);
            MainActivity.this.print();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + this);
    }
}
