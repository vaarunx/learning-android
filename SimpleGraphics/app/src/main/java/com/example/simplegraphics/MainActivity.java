package com.example.simplegraphics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        SampleCanvas sc = new SampleCanvas(this);
        setContentView(sc);

    }
    private class SampleCanvas extends View {


        public SampleCanvas(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            Paint paint2 = new Paint();
            Paint square = new Paint();
            Paint line = new Paint();
            line.setTextSize(40f);
            line.setColor(Color.RED);
            line.setStrokeWidth(5);
            paint.setColor(Color.CYAN);
            paint2.setColor(Color.GREEN);
            square.setColor(Color.rgb(200 , 120 , 110));

            canvas.drawPaint(paint);

            canvas.drawText("Circle" , 120 , 150 , line);
            canvas.drawCircle(200 , 350 , 150 , paint2);

            canvas.drawText("Square" , 120 , 800 , line);
            canvas.drawRect( 50,850,350,1150 ,square  ); //Square

            canvas.drawText("Rectange" , 420 , 150 , line);
            canvas.drawRect( 400,200,650,750 ,line ); //Rectange

            canvas.drawText("Line" , 480 , 800 , line);
            canvas.drawLine(520,850 ,520 , 1150, line);

            //canvas.drawText();

            //super.onDraw(canvas);
        }
    }
}