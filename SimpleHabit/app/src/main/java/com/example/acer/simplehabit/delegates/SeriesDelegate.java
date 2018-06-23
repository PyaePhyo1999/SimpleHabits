package com.example.acer.simplehabit.delegates;

import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.data.vo.ProgramVO;

/**
 * Created by Acer on 6/23/2018.
 */

public interface SeriesDelegate {
    void onTapCurrent(CurrentProgramVO current);
    void onTapCategoryDelegate(CategoriesProgramsVO category, ProgramVO program);
}
