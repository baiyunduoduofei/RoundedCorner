package com.zhou.roundedcorner;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * @author: zhouyunfei
 * @date: 2018/6/14
 * @desc:
 */
public class RoundedCornerUtil {

    /***
     *
     * @param bitmap 原图片
     * @param radius 圆角大小
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static Bitmap roundByBitmapShader(Bitmap bitmap, int radius) {
        Bitmap roundedCornerBitmap = null;
        if (null != bitmap) {
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            // 创建BitmapShader
            BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            // 创建目标bitmap
            roundedCornerBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            // 创建画布
            Canvas canvas = new Canvas(roundedCornerBitmap);
            // 创建画笔
            Paint paint = new Paint();
            //设置抗锯齿
            paint.setAntiAlias(true);
            //设置shader
            paint.setShader(bitmapShader);
            // 绘制圆角矩形
            canvas.drawRoundRect(0, 0, width, height, radius, radius, paint);

        }
        return roundedCornerBitmap;
    }

    /***
     *
     * @param bitmap 原图片
     * @param radius 圆角大小
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static Bitmap roundByXfermode(Bitmap bitmap, int radius) {
        Bitmap roundedCornerBitmap = null;
        if (null != bitmap) {
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            // 创建目标bitmap
            roundedCornerBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            // 创建画布
            Canvas canvas = new Canvas(roundedCornerBitmap);
            // 创建画笔
            Paint paint = new Paint();
            //设置抗锯齿
            paint.setAntiAlias(true);
            canvas.drawRoundRect(0, 0, width, height, radius, radius, paint);
            // 设置Xfermode
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            // 绘制图片
            canvas.drawBitmap(bitmap, 0, 0, paint);
        }

        return roundedCornerBitmap;
    }


}
