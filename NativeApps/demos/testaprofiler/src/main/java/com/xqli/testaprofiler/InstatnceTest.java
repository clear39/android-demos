package com.xqli.testaprofiler;

import android.content.Context;

public class InstatnceTest {

    private static InstatnceTest mInstatnce;



    public static InstatnceTest getInstatnce(Context c){
        synchronized (InstatnceTest.class){
            if(mInstatnce == null){
                mInstatnce = new InstatnceTest(c);
            }
        }

        return mInstatnce;
    }

    private Context mContext;
    private InstatnceTest(Context c){
        mContext = c;
    }
}
