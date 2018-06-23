package com.example.acer.simplehabit.mvp.presenters;

import com.example.acer.simplehabit.data.models.SimpleHabitModel;
import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.data.vo.ProgramVO;
import com.example.acer.simplehabit.delegates.SeriesDelegate;
import com.example.acer.simplehabit.events.DataReadyEvent;
import com.example.acer.simplehabit.mvp.views.SeriesView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Acer on 6/21/2018.
 */

public class SeriesListPresenter extends BasePresenter<SeriesView> implements SeriesDelegate {

    public SeriesListPresenter(SeriesView mView) {
        super(mView);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SimpleHabitModel.getsObjectInstance().loadData();

    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoadData(DataReadyEvent event){
        if (event.getData() == null){
            mView.displayErrorMsg("Error");
        }
        else {

                mView.displaySeriesList(event.getData());
            }

    }

    @Override
    public void onTapCurrent(CurrentProgramVO currentProgramVO) {
        mView.launchCurrentDetailScreen(currentProgramVO.getProgramId());
    }

    @Override
    public void onTapCategoryDelegate(CategoriesProgramsVO category,ProgramVO program) {
          mView.launchCategoryDetailScreen(category.getCategoryId(),program.getProgramId());
    }


}
