package com.example.drawmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class mappingClass extends SurfaceView implements SurfaceHolder.Callback {

    Context mContext;
    SurfaceHolder mHolder;
    RenderingThread mRThread;

    Paint paint;
    int x,y;

    public mappingClass(Context context){
        super(context);
        mContext = context;
        mHolder = getHolder();
        mHolder.addCallback(this);

        mRThread = new mappingClass.RenderingThread();

        x=10;
        y=10;

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(15f);
        paint.setStyle(Paint.Style.FILL);
    }

    public void drawDot(){
        x+=30;
        y+=30;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mRThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        try {
            mRThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    class RenderingThread extends Thread {
        public RenderingThread() {
            Log.d("RenderingThread", "RenderingThread()");
        }

        public void run() {
            Log.d("RenderingThread", "run()");
            Canvas canvas = null;
            Canvas backCanvas = null;

            while (true) {
                canvas = mHolder.lockCanvas();
                try {

                    synchronized (mHolder) {
                        canvas.drawPoint(x,y,paint);
                    }
                } finally {
                    if (canvas == null) return;
                    mHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }


}




