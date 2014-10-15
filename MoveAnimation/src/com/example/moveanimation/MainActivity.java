package com.example.moveanimation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements AnimationListener {

	ImageView moveRight;
	ImageView moveLeft;
    LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		moveRight = (ImageView) findViewById(R.id.moveRight);
		moveLeft = (ImageView) findViewById(R.id.moveLeft);
		layout = (LinearLayout)findViewById(R.id.moveanimation);
		// load the animation
		 android.view.ViewGroup.LayoutParams layParamsGet=  layout.getLayoutParams();
		    float width=layParamsGet.width/2;
		    
		TranslateAnimation LeftRight = new TranslateAnimation(0.0f, 150.0f,
				0.0f, 0.0f); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
		LeftRight.setDuration(2000); // animation duration
		LeftRight.setRepeatCount(-1); // animation repeat count
		LeftRight.setRepeatMode(2); // repeat animation (left to right, right to
									// left )
		// animation.setFillAfter(true);

		TranslateAnimation RightLeft = new TranslateAnimation(0.0f, -150.0f,
				0.0f, 0.0f);
		RightLeft.setDuration(2000); // animation duration
		RightLeft.setRepeatCount(-1); // animation repeat count
		RightLeft.setRepeatMode(2);
		moveRight.startAnimation(LeftRight);
		moveLeft.startAnimation(RightLeft);

	}

	@Override
	public void onAnimationEnd(Animation arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationRepeat(Animation arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation arg0) {
		// TODO Auto-generated method stub

	}
}
