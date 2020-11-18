package com.bitspilani.library.infoBits;

import android.content.Context;
import android.widget.Scroller;

public class CustomScroller extends Scroller {

    private int mDuration = 1500;

    public CustomScroller(Context context) {
        super(context);
    }


    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
}
