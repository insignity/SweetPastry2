package com.example.sweetpastry1;

import android.graphics.Matrix;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Pastry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastry);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        int[] list_images = {
                R.drawable.picture1,
                R.drawable.picture2,
                R.drawable.picture3,
                R.drawable.picture4,
                R.drawable.picture5,
                R.drawable.picture6,
                R.drawable.picture7,
                R.drawable.picture8,
                R.drawable.picture9,
                R.drawable.picture10,
                R.drawable.picture11,
                R.drawable.picture12,
                R.drawable.picture13,
                R.drawable.picture14,
                R.drawable.picture15,
                R.drawable.picture16,
                R.drawable.picture17,
                R.drawable.picture18,
                R.drawable.picture19,
                R.drawable.picture20,
                R.drawable.picture21,
                R.drawable.picture22};

        String[] list_title = {
                "Бисквит",
                "Бисквитный торт1",
                "Бисквитный торт2",
                "Донаты1(Пончик)",
                "Донаты2(Пончик)",
                "Капкейки",
                "Красный бархат1",
                "Красный бархат2",
                "Красный бархат3",
                "Медовик",
                "Медовый торт1",
                "Медовый торт2",
                "Медовый торт2",
                "Пончики1",
                "Пончики2",
                "Птичье молоко",
                "Творожные пончики1",
                "Творожные пончики2",
                "Тирамису1",
                "Тирамису2",
                "Шоколадные пирожные1",
                "Шоколадные пирожные2"};
        LinearLayout linearLayout = findViewById(R.id.linearlayout);
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams tparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lparams.setMargins(0,0,0,0);
        tparams.setMargins(0,0,0,0);
        tparams.height = 60;
        tparams.gravity = Gravity.CENTER_HORIZONTAL;
        lparams.height = 550;
        lparams.width = 1000;

        ImageView imageView[] = new ImageView[22];
        TextView textView[] = new TextView[22];
        for(int i = 0; i < 22; i++){
            textView[i] = new TextView(this);
            textView[i].setTypeface(null, Typeface.BOLD);
            imageView[i] = new ImageView(this);

            imageView[i].setImageResource(list_images[i]);
            textView[i].setText(list_title[i]);
            linearLayout.addView(imageView[i], lparams);
            linearLayout.addView(textView[i], tparams);
        }
    }
}
