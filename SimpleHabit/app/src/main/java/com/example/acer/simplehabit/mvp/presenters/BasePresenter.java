package com.example.acer.simplehabit.mvp.presenters;

import com.example.acer.simplehabit.mvp.views.BaseView;

/**
 * Created by Acer on 6/21/2018.
 */

public abstract class BasePresenter <T extends BaseView>{
   protected T mView;

    public BasePresenter(T mView){
        this.mView = mView;
    }

    public void onCreate() {

    }

    public void onStart() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop() {
    }

    public void onDestroy() {

    }
}
