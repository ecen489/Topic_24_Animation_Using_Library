package com.example.t24_more_graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import stanford.androidlib.graphics.GCanvas;
import stanford.androidlib.graphics.GColor;
import stanford.androidlib.graphics.GLabel;
import stanford.androidlib.graphics.GOval;
import stanford.androidlib.graphics.GRect;

public class FaceView extends GCanvas {

    private GOval face;
    private int dx =5;

    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void init() {
        face = new GOval(100, 100, 200, 200); // face
        face.setColor(GColor.BLACK);
        face.setFillColor(GColor.YELLOW);
        add(face);
        animate(50);
    }

    @Override
    public void onAnimateTick() {
        super.onAnimateTick();
        face.setX(face.getX() + dx);
        if(face.getRightX() >= getWidth() || face.getX() <=0){
            dx=-dx; //bounce
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if	(event.getAction()	==	MotionEvent.ACTION_DOWN){
            dx = -dx;
        }
        return super.onTouch(v, event);
    }

}

