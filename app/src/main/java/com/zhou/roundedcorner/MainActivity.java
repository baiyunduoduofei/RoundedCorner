package com.zhou.roundedcorner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ImageView mBitmapShaderImg;
    private ImageView mXfermodeImg;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBitmapShaderImg = findViewById(R.id.main_bitmapshader);
        mXfermodeImg = findViewById(R.id.main_xfermode);
        try {
            Bitmap bitmap= BitmapFactory.decodeStream(getAssets().open("weizhuang.png"));
            mBitmapShaderImg.setImageBitmap(RoundedCornerUtil.roundByBitmapShader(bitmap,20));
            mXfermodeImg.setImageBitmap(RoundedCornerUtil.roundByXfermode(bitmap,20));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
