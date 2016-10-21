package com.luoye.demo.imageloaderdemo;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.Log;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

/**
 * Created by Luoye on 2016/10/21.
 */

public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("haha", "oncreate");
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageOnFail(R.drawable.ic_clear_black_24dp)
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)//设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型
                .displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间，可能会出现闪动
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片的缩放方式
                /*
              EXACTLY :图像将完全按比例缩小的目标大小
              EXACTLY_STRETCHED:图片会缩放到目标大小完全
              IN_SAMPLE_INT:图像将被二次采样的整数倍
              IN_SAMPLE_POWER_OF_2:图片将降低2倍，直到下一减少步骤，使图像更小的目标大小
              NONE:图片不会调整
                 */
                .build();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .writeDebugLogs()
                .threadPoolSize(3)
                .memoryCacheExtraOptions(480, 800)
                .diskCacheExtraOptions(480, 800, null)
                .defaultDisplayImageOptions(options)
                .diskCacheSize(1024 * 1024 * 20)
                .memoryCacheSize(1024 * 1024 * 10)
                .build();

        ImageLoader.getInstance().init(configuration);

    }
}
