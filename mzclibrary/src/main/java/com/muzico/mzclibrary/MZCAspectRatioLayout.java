package com.muzico.mzclibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class MZCAspectRatioLayout extends RelativeLayout {
    private String mProportion;

    public MZCAspectRatioLayout(Context context) {
        this(context, null);
    }

    public MZCAspectRatioLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MZCAspectRatioLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        @SuppressLint("Recycle") TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MZCAspectRatioLayout);
        mProportion = array.getString(R.styleable.MZCAspectRatioLayout_aspectRatio);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int childWidthSize = getMeasuredWidth();
        int childHeightSize = getMeasuredHeight();
        String[] mProportionArr = mProportion.split(":");
        int width_pro = Integer.parseInt(mProportionArr[0]);
        int height_pro = Integer.parseInt(mProportionArr[1]);
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec((int)(childWidthSize * height_pro * 1.0) / width_pro, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
