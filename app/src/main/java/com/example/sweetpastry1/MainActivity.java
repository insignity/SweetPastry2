package com.example.sweetpastry1;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        ImageView imageView = findViewById(R.id.imageView);

        final Display display = getWindowManager().getDefaultDisplay();
        final float screenWidth = display.getWidth();
        final float screenHeight = display.getHeight();
        final float imageWidth = imageView.getDrawable().getIntrinsicWidth();
        final float imageHeight = imageView.getDrawable().getIntrinsicHeight();
        final Matrix splashMatrix = new Matrix();
        final float scale = Math.max(screenHeight/imageHeight,screenWidth/imageWidth);
        splashMatrix.postScale( scale, scale );
        imageView.setImageMatrix(splashMatrix);

        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            }
        };
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            }
        }, 3000);
        relativeLayout.setOnClickListener(onClickListener);
    }
}
