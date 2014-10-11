package com.repkap11.customviewexample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	Drawer mDraw;
	private AnimatorSet mAnim;
	private boolean mIsEndingAnimator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDraw = new Drawer(this);
		setContentView(mDraw);
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (mAnim != null) {
			mIsEndingAnimator = true;
			mAnim.cancel();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		mIsEndingAnimator = false;
		mAnim = new AnimatorSet();

		ObjectAnimator darkerFade = ObjectAnimator.ofInt(mDraw, "ovalAlpha", 0, 255);
		darkerFade.setDuration(1000);

		ObjectAnimator lighterFade = ObjectAnimator.ofInt(mDraw, "ovalAlpha", 255, 0);
		lighterFade.setDuration(1000);

		mAnim.playSequentially(darkerFade, lighterFade);
		mAnim.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				if (!mIsEndingAnimator) {
					mAnim.start();
				}
			}
		});
		mAnim.start();
		mAnim.start();
	}

}
