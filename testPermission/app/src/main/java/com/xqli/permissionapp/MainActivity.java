package com.xqli.permissionapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RationaleDialogFragment.PermissionCallbacks {

    public static final String TAG = "MainActivity";

    private static final int RC_CAMERA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.i(TAG, "onRequestPermissionsResult:" + requestCode + "," + Arrays.toString(permissions) + "," + Arrays.toString(grantResults));
        switch (requestCode) {
            case RC_CAMERA: {
                // 如果请求被取消了，那么结果数组就是空的
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 权限被授予了
                    showCameraPreview();
                }
                return;
            }
        }
    }

    public void showCamera(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            // 我们应该给用户个解释?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {

                // 向用户显示一个解释，要以异步非阻塞的方式
                // 该线程将等待用户响应！等用户看完解释后再继续尝试请求权限
                /*RationaleDialogFragment.newInstance(android.R.string.ok, android.R.string.cancel,getString(R.string.rationale_camera), RC_CAMERA,new String[]{Manifest.permission.CAMERA})
                        .show(getSupportFragmentManager(), RationaleDialogFragment.TAG);*/
            } else {

                // 不需要向用户解释了，我们可以直接请求该权限
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                        RC_CAMERA);
            }
        } else {
            showCameraPreview();
        }

    }

    private void showCameraPreview() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_fragment, CameraPreviewFragment.newInstance())
                .addToBackStack("camera")
                .commit();
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.i(TAG, "onPermissionsGranted:" + requestCode + ":" + perms.size());
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.i(TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size());
    }

}

