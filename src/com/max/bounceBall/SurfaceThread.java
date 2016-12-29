package com.max.bounceBall;

/*
	Author : Praveenmax
	github : github.com/praveenmax

*/


import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class SurfaceThread extends Thread
{
	BallSurfaceView surface;
	SurfaceHolder holder;
	boolean start;
	
	SurfaceThread(BallSurfaceView ballsurface,SurfaceHolder holder)
	{
		this.holder=holder;
		surface=ballsurface;
	}
	
	public void setState(boolean temp)
	{
		start=temp;
	}
	
	public void run()
	{
		while(start)
		{
			Canvas c=null;
			try{
				
				c=holder.lockCanvas(null);
				synchronized(holder)
				{
					surface.onDraw(c);
					//Thread.sleep(5);
				}
			}
			catch(Exception e)
			{
				System.out.println("Thread error:"+e.toString());
			}
			finally
			{
				if(c!=null)
				{
					holder.unlockCanvasAndPost(c);
				}
			}
		}
	}//run
}
