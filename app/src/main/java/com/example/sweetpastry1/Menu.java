package com.example.sweetpastry1;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        View.OnClickListener onClickListener = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        Intent intent = new Intent(Menu.this, Pastry.class);
                        startActivity(intent);
                        break;
                    case R.id.button2:
                        Intent intent1 = new Intent(Menu.this, Recipes.class);
                        startActivity(intent1);
                        break;
                    case R.id.button3:
                        Intent intent2 = new Intent(Menu.this, Basket.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
    }
}
