package com.max.bounceBall;
/*
*
	Author : Praveenmax
	github : github.com/praveenmax


 * This is the view on which the ball is drawn
 * 
 * 
 */
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class BallSurfaceView extends SurfaceView implements Callback,OnTouchListener{

	//creating a ball instance
	ArrayList<Ball> ballarray;
	Paint pBrush;
	int alpha=255;
	//thread to draw onto this surface
	SurfaceThread thread;
	
	
	
	BallSurfaceView(Context context)
	{
		super(context);
		
		setFocusable(true);
		pBrush=new Paint();
		pBrush.setColor(Color.WHITE);
		
		//get the holder
		getHolder().addCallback(this);

		
		//ball instance
		ballarray=new ArrayList<Ball>();
		

			
		//setting the listener
		setOnTouchListener(this);
		
		
		
		
		//our drawing thread
		thread=new SurfaceThread(this,getHolder());
	}
	
	//this is wat the surfaceview going to draw
	public void onDraw(Canvas c)
	{
		//set the BG color 
			c.drawColor(Color.WHITE);
			for(Ball b:ballarray)
			{
				b.drawBall(c);
			}
		
	}
	
	public boolean onTouch(View v,MotionEvent me)
	{
		//add another ball to the surface
		if(me.getAction()==MotionEvent.ACTION_UP)
		{
			ballarray.add(new Ball(30,this));
			System.out.println("added a ball");
		}
		return true;
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		
		thread.setState(true);
		thread.start();
		Toast.makeText(getContext(),"Touch",Toast.LENGTH_SHORT).show();
		System.out.println("Surface Created");

	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
		Toast.makeText(getContext(),"Surface Changed,Ball count:"+ballarray.size(),Toast.LENGTH_SHORT).show();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		thread.setState(false);
		System.out.println("Surface destroyed");
	}
}
