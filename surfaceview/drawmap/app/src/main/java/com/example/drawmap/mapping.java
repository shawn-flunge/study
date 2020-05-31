package com.example.drawmap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class mapping extends AppCompatActivity {

    Button btnAdd;
    Paint paint;
    Canvas canvas;
    mappingClass mp;

    //여기 클래스에서 angle값을 만들어야함
    //angle값을 drawDot메소드에 넘겨줘야함

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapping);

        btnAdd = (Button)findViewById(R.id.btnAdd);

        mp = new mappingClass(this);
        FrameLayout temp;
        temp = (FrameLayout) findViewById(R.id.frameInMapping);
        temp.addView(mp);

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(15f);
        paint.setStyle(Paint.Style.FILL);

        canvas = new Canvas();
        canvas.drawRect(220,150, 1220,1150,paint);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //이것도 메소드를 수정해야함, 파라미터를 받는걸로다가
               mp.drawDot();
            }
        });

    }



}
