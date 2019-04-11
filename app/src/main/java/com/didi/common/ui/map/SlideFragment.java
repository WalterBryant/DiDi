package com.didi.common.ui.map;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.didi.R;
import com.didi.async.task.AsyncListenerInter;
import com.didi.async.task.CommonAsyncTask;

import java.lang.reflect.Field;

public class SlideFragment extends Fragment {

    AsyncListenerInter asyncListener = new AsyncListener();
    private boolean isDestroyed;
    protected boolean mIsActive = false;
    private boolean mPaused;

    public ViewGroup mRootView;
    private Animation.AnimationListener mSlideInListener = new AnimaListener();
    private IFTransitionListener mTransListener;


    class TouchListener implements View.OnTouchListener {

        TouchListener() {

        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    }

    class SlideThread implements Runnable {
        SlideThread() {

        }
        @Override
        public void run() {
            new CommonAsyncTask(SlideFragment.this.asyncListener).execute(new Void[0]);
        }
    }

    class AsyncListener implements AsyncListenerInter {

        @Override
        public void doInBack() {

        }

        @Override
        public void doOnCancel() {

        }

        @Override
        public void doOnPost() {

        }

        @Override
        public void doOnPre() {

        }

        @Override
        public void doOnProcess() {

        }
    }

    class AnimaListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    public interface FragmentStateListener {
        void isDestroyView();
    }

    public interface IFTransitionListener {
        void showNewFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mTransListener = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        this.mIsActive = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        this.mIsActive = false;
    }

    @Override
    public void onPause() {
        this.mPaused = true;
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mPaused = false;
    }

    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (nextAnim != R.anim.slide_in && nextAnim != R.anim.slide_back_in) {
            return null;
        }

        Animation anim = AnimationUtils.loadAnimation(getActivity(), nextAnim);
        anim.setAnimationListener(this.mSlideInListener);
        return anim;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public String getFragmentTag() {
        return getClass().getSimpleName();
    }

    public String getLogTag() {
        return getClass().getSimpleName();
    }

    public boolean onBackPressed() {
        return true;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        this.isDestroyed = false;
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        if (v == null) {
            return null;
        }
        v.setOnTouchListener(new TouchListener());
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void doInBack() {
        Log.i("doInBackFather==", "doInBackFather");
    }

    @Override
    public void onDestroy() {
        this.isDestroyed = true;
        super.onDestroy();
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.mRootView = null;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public boolean shouldBeAddedToBackStack() {
        return true;
    }

    public void show(View v) {
        if (v != null) {
            v.setVisibility(View.VISIBLE);
        }
    }

    public void hide(View v) {
        if (v != null) {
            v.setVisibility(View.GONE);
        }

    }

    public void invisible(View v) {
        if (v != null) {
            v.setVisibility(View.INVISIBLE);
        }
    }
}
