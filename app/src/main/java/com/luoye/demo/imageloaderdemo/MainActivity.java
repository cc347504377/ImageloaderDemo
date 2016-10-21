package com.luoye.demo.imageloaderdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class MainActivity extends AppCompatActivity {


    private ImageView imageView;
    private String path = "http://b.hiphotos.baidu.com/image/pic/item/203fb80e7bec54e72718421fbb389b504fc26a3e.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                setimagesize();
            }
        });
    }
    /*
    加载图片手动操作
     */
    private void loadimage() {
        ImageLoader.getInstance().loadImage(path, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Drawable drawable = new BitmapDrawable(loadedImage);
                imageView.setBackground(drawable);

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }

    /*
    加载图片并且自动显示
     */
    private void displayimage() {
//        ImageLoader.getInstance().displayImage(path, imageView); 简单实现无回调
        ImageLoader.getInstance().displayImage(path, imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Drawable drawable = new BitmapDrawable(loadedImage);
                view.setBackground(drawable);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }

    private void setimagesize() {
        ImageSize imageSize = new ImageSize(200, 100);
        ImageLoader.getInstance().loadImage(path,imageSize,null,new SimpleImageLoadingListener(){
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                imageView.setImageBitmap(loadedImage);
            }
        });
    }
}
