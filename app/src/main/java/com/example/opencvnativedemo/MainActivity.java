package com.example.opencvnativedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.opencvnativedemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'opencvnativedemo' library on application startup.
    static {
        System.loadLibrary("opencvnativedemo");
    }

    private ActivityMainBinding binding;

    Bitmap srcBitmap = null;
    Bitmap dstBitmap = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);

        srcBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.man);

        if(srcBitmap!=null)
        dstBitmap = srcBitmap.copy(srcBitmap.getConfig(),true);

        if(dstBitmap!=null)
        imageView.setImageBitmap(dstBitmap);
    }


    public void btnFlip_click(View view)
    {
        if(srcBitmap!= null && dstBitmap!= null)
        myFlip(srcBitmap,dstBitmap);
    }

    /**
     * A native method that is implemented by the 'opencvnativedemo' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String myFlip(Bitmap bitmapIn,Bitmap bitmapOut);

    public native String myBlur(Bitmap bitmapIn,Bitmap bitmapOut,Float sigma);

}