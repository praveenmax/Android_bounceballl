package com.max.bounceBall;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceView;
import android.view.View;

/*
	Author : Praveenmax
	github : github.com/praveenmax

*/


/*
 * Ball class:-
 * -contains ball attribs
 * -contains method to draw
 * 
 * 
 * 
 */


public class Ball {
	
	//ball details
	private final int radius;
	private int x_pos=0;
	private int y_pos=0;
	private int x_speed=1;
	private int y_speed=1;
	
	//Paint object 
	final Paint pBrush;
	
	//View canvas
	SurfaceView canvas;
	
	Ball(int radius,SurfaceView sv,int color)
	{
		this.radius=radius;
		canvas=sv;
		
		//our Paint object
		pBrush=new Paint();
			pBrush.setARGB(color, (int)(255*Math.random()), (int)(255*Math.random()), (int)(255*Math.random()));
			pBrush.setAntiAlias(true);
			
	}
	
	Ball(int radius,SurfaceView sv)
	{
		this.radius=radius;
		canvas=sv;
		
		//our Paint object
		pBrush=new Paint();
			pBrush.setARGB(255, (int)(255*Math.random()), (int)(255*Math.random()), (int)(255*Math.random()));
			pBrush.setAntiAlias(true);
			
	}
	//must be called to draw the circle
	public void drawBall(Canvas c)
	{
		//calculate the direction
		calculateMotion();
		
		//draws the circle
	c.drawCircle(x_pos,y_pos,radius,pBrush);
		//c.drawCircle(30,30,radius,pBrush);
	//System.out.println(x_pos+","+y_pos);
	}
	
	//calculate the motion and bound condition

	private void calculateMotion()
	{
		//move the ball
		x_pos=x_pos-x_speed;
		y_pos=y_pos-y_speed;
		
		//check bound condition
		//X
		if((x_pos-radius)<0)
		{
			x_pos=radius;
			x_speed=-x_speed;//changes the x direction
		}
		else
		if(x_pos+radius>canvas.getWidth())
		{
			x_pos=canvas.getWidth()-radius;
			x_speed=-x_speed;//changes the x direction
		}
	
		//Y
		if((y_pos-radius)<0)
		{
			y_pos=radius;
			y_speed=-y_speed;//change y dir
		}
		else
		if((y_pos+radius)>canvas.getHeight())
		{
			y_pos=canvas.getHeight()-radius;
			y_speed=-y_speed;//changes the y direction
		}
		
	}
}
