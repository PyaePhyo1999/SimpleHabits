package com.example.acer.simplehabit.mvp.presenters;

import com.example.acer.simplehabit.data.models.SimpleHabitModel;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.data.vo.ProgramVO;
import com.example.acer.simplehabit.mvp.views.SeriesDetailView;

/**
 * Created by Acer on 6/23/2018.
 */

public class CurrentDetailSectionPresenter extends BasePresenter<SeriesDetailView> {

    public CurrentDetailSectionPresenter(SeriesDetailView mView) {
        super( mView);
    }
    public void onFinishCurrentUIComponent(String currentId,CurrentProgramVO current){
         current = SimpleHabitModel.getsObjectInstance().getCurrentProgram();
          mView.displayCurrentDetail(currentId,current);

    }
    public void onFinishCategoryUIComponent(String categoryId, String programId, ProgramVO programVO){
        programVO = SimpleHabitModel.getsObjectInstance().getProgram(categoryId,programId);
        mView.displayCategoryDetail(categoryId,programId,programVO);
    }
}
