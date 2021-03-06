package com.charon.www.younghawkdemo.presenter;


import android.os.Handler;

import com.charon.www.younghawkdemo.R;
import com.charon.www.younghawkdemo.model.HomeBean;
import com.charon.www.younghawkdemo.model.Time;
import com.charon.www.younghawkdemo.ui.Fragments.HomeFragment;
import com.charon.www.younghawkdemo.view.IHomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class HomePresenter {
    private List<HomeBean> homeList;
    private IHomeView homeView;
    Handler handler = new Handler();
    public HomePresenter(IHomeView homeView) {
        this.homeView = homeView;
    }

    private List<HomeBean> addDate(int j) {
        homeList = new ArrayList<>();
        for (int i = 0 ; i < j ; i++) {
            Time time = new Time(2017,2,3,12,i);
            HomeBean homeBean = new HomeBean(R.drawable.charonhead,"Charon",time,"这是一个很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长的测试文字段"+i,0,0);
            homeList.add(homeBean);
        }
        return homeList;
    }

    public void getHomeInf() {
        homeView.loading(true);
        homeView.addView(addDate(20));
        homeView.loading(false);
    }

    public void getMoreInf() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                homeView.addView(addDate(5));
                HomeFragment.loading = false;
            }
        },1500);
    }

    public void getHeadInf() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                homeView.refreshList(addDate(1));
                HomeFragment.loading = false;
                homeView.refresh(false);
            }
        },500);
    }

    public void deleteItem(int position) {
        //可以删除
        homeView.deleteItem(position);
    }

    public void editItem(int position) {
        //可以编辑
        homeView.editItem(position);
    }

    public void clickLike(int position) {

    }

    public void clickComment(int position) {

    }
}
