package com.xqli.annotation.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.xqli.annotation.BindView;
import com.xqli.annotation.OnClick;
import com.xqli.annotation.ViewInject;

public class MainActivity extends Activity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button1)
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewInject.inject(this);

    }

    @OnClick(R.id.textView)
    public void click() {
        Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
    }
}
