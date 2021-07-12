package com.example.sunnyweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.sunnyweather.City.CityMangerActivity;
import com.example.sunnyweather.db.DBManger;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ImageView addCityIv,moreIv;
LinearLayout pointLayout;
ViewPager mainVp;
List<Fragment> fragmentList;
List<String> cityList;
List<ImageView> imgList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCityIv=findViewById(R.id.main_iv_add);
        moreIv=findViewById(R.id.main_iv_more);
        pointLayout=findViewById(R.id.main_layout_point);
        mainVp=findViewById(R.id.main_vp);
        addCityIv.setOnClickListener(this);
        moreIv.setOnClickListener(this);
        fragmentList=new ArrayList<>();
        cityList= DBManger.queryAllCityName();//获取数据库包涵的城市数据列表
        imgList=new ArrayList<>();
        if(cityList.size()==0){
            cityList.add("北京");
        }
        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        if(!cityList.contains(city)||!TextUtils.isEmpty(city)){//当获取到的city不包含在citylist中或者city不等于空时，添加city到citylist中
            cityList.add(city);
        }
        initPager();
        CityFragmentPagerAdapter adapter = new CityFragmentPagerAdapter(getSupportFragmentManager(), 1, fragmentList);
        mainVp.setAdapter(adapter);
        initPoint();
    }



    private void initPoint() {
    mainVp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
        @Override
        public void onPageSelected(int position) {
for(int i=0;i<fragmentList.size();i++){
imgList.get(i).setImageResource(R.mipmap.a1);
}
imgList.get(position).setImageResource(R.mipmap.a2);
        }
    });


    }

    private void initPager() {
        for(int i=0;i<cityList.size();i++){
            CityWeatherFragment cityFrag=new CityWeatherFragment();
            Bundle bundle=new Bundle();
            bundle.putString("city",cityList.get(i));
            Log.d("TAG", "initPager: ");
            cityFrag.setArguments(bundle);
            fragmentList.add(cityFrag);
            ImageView view=new ImageView(this);
            view.setImageResource(R.mipmap.a1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)view.getLayoutParams();
            lp.setMargins(0,0,20,0);
            imgList.add(view);
            pointLayout.addView(view);
        }
        imgList.get(0).setImageResource(R.mipmap.a2);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.main_iv_add:
            intent.setClass(this, CityMangerActivity.class);
            startActivity(intent);
                break;
            case R.id.main_iv_more:
//                intent.setClass(this,MoreActivity.class);
                break;

        }
    }
}