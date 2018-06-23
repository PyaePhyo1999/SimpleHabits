package com.example.acer.simplehabit.mvp.views;

import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.data.vo.ProgramVO;

/**
 * Created by Acer on 6/23/2018.
 */

public interface SeriesDetailView extends BaseView{
    void displayCurrentDetail(String currentId,CurrentProgramVO currentProgram);
    void displayCategoryDetail(String categoryId, String programId, ProgramVO program);

}
