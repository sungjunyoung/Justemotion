package com.playrtc.simplechat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.jar.Attributes;

public class drawActivity extends Activity {
    Button back_btn;
    Button reset_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        back_btn = (Button)findViewById(R.id.back_btn);
        reset_btn = (Button)findViewById(R.id.reset_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(drawActivity.this, MainActivity.class);
                finish();
                startActivity(i);
            }
        });

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paper.onReset();
            }
        });
    }


}

class Paper extends View{
    Paint paint = new Paint();
    static Path path = new Path();

    float x, y;

    public Paper(Context context){
        super(context);
    }

    static void onReset() {
        path.reset();
    }

    public Paper(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas){
        invalidate();

        paint.setStrokeWidth(3);
        paint.setColor(Color.parseColor("#2e7d32"));
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawPath(path, paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX();
                y = event.getY();
                path.lineTo(x, y);

                System.out.println("X : " + x + " Y : " + y);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        invalidate();

        return true;
    }

}
