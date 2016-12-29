package com.max.bounceBall;
/*
	Author : Praveenmax
	github : github.com/praveenmax

*/


import android.app.Activity;
import android.os.Bundle;

public class act1 extends Activity {
    /** Called when the activity is first created. */
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        BallSurfaceView bsv=new BallSurfaceView(this);
        setContentView(bsv);
    }
}