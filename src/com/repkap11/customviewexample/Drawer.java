/**
 * Drawer.java
 * $Id:$
 * $Log:$
 * @author Paul Repka psr2608
 */
package com.repkap11.customviewexample;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class Drawer extends View {
	private int mOvelAlpha;

	public Drawer(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Rect rect = new Rect();
		rect.set(70, 30, canvas.getWidth() / 3, canvas.getHeight() / 20);
		Paint rectPaint = new Paint();
		rectPaint.setColor(Color.CYAN);
		rectPaint.setStyle(Paint.Style.FILL);

		ShapeDrawable mDrawableOval;
		ShapeDrawable mDrawableArc;

		mDrawableOval = new ShapeDrawable(new OvalShape());
		mDrawableOval.setBounds(10, 50, canvas.getWidth() / 4, canvas.getHeight() / 8);
		mDrawableOval.getPaint().setColor(Color.BLUE);
		mDrawableOval.setAlpha(mOvelAlpha);

		mDrawableArc = new ShapeDrawable(new ArcShape(-20, 80));
		mDrawableArc.setBounds(10, 120, canvas.getWidth() / 4, canvas.getHeight() / 5);
		mDrawableArc.getPaint().setColor(Color.YELLOW);
		mDrawableArc.setAlpha(50);

		canvas.drawRect(rect, rectPaint);
		mDrawableOval.draw(canvas);
		mDrawableArc.draw(canvas);

	}

	public void setOvalAlpha(int value) {
		mOvelAlpha = value;
		invalidate();
	}

}
