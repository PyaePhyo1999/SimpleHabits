package com.example.acer.simplehabit.mvp.views;

import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.data.vo.HomeScreenVO;
import com.example.acer.simplehabit.data.vo.TopicVO;

import java.util.List;

/**
 * Created by Acer on 6/21/2018.
 */

public interface SeriesView extends BaseView{
  void displaySeriesList(List<HomeScreenVO> mData);
  void launchCurrentDetailScreen(String currentId);
  void launchCategoryDetailScreen(String categoryId,String programId);

}
