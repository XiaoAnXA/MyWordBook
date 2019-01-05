package com.mask.mywordbook.app;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.mask.mywordbook.R;
import com.mask.mywordbook.adapter.SectionsPagerAdapter;
import com.mask.mywordbook.db.EnglishDbHelper;
import com.mask.mywordbook.fragment.ReadFragment;
import com.mask.mywordbook.fragment.NotesFragment;
import com.mask.mywordbook.fragment.TaskFragment;
import com.mask.mywordbook.fragment.TranslationFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, BottomNavigationBar.OnTabSelectedListener {
    public BottomNavigationBar mBnbBar;
    public ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(),getFragments()));
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(3);
        mBnbBar = findViewById(R.id.main_bottom_navigation_bar);
        mBnbBar.addItem(new BottomNavigationItem(R.drawable.main_bnb_item_trans,"翻译"))
                .addItem(new BottomNavigationItem(R.drawable.main_bnb_item_notes,"笔记"))
                .addItem(new BottomNavigationItem(R.drawable.main_bnb_item_amuse,"我的"))
                .setFirstSelectedPosition(0)
                .initialise();
        mBnbBar.setTabSelectedListener(this);
    }

    private List<Fragment> getFragments() {
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(TranslationFragment.newInstance("",""));
        fragmentArrayList.add(NotesFragment.newInstance("",""));
        fragmentArrayList.add(TaskFragment.newInstance("",""));
        return fragmentArrayList;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        mBnbBar.selectTab(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onTabSelected(int position) {
        mViewPager.setCurrentItem(position);

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
