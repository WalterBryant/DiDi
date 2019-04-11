package com.didi.common.base;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

public class BaseDilog extends Dialog {
    public BaseDilog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public void setContentView(int layoutResID) {
        setContentView(layoutResID);
    }

    public void setContentView(View view) {

    }

    public void resizeView(View view) {

    }

    public String getLogTag() {
        return getClass().getSimpleName();
    }
}

