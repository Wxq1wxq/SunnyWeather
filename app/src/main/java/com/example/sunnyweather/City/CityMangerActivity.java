package com.example.sunnyweather.City;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sunnyweather.CityFragmentPagerAdapter;
import com.example.sunnyweather.R;
import com.example.sunnyweather.db.DBManger;
import com.example.sunnyweather.db.DataBaseBean;

import java.util.ArrayList;
import java.util.List;

public class CityMangerActivity extends AppCompatActivity implements View.OnClickListener{
ImageView backIv,addIv,deleteIv;
ListView cityLv;
List<DataBaseBean> mData;
    CityMangerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manger);

        backIv=findViewById(R.id.city_iv_back);
        addIv=findViewById(R.id.city_add_iv);
        deleteIv=findViewById(R.id.city_iv_delete);
        cityLv=findViewById(R.id.item_city_Lv);
        mData=new ArrayList<>();
        addIv.setOnClickListener(this);
        deleteIv.setOnClickListener(this);
        backIv.setOnClickListener(this);
         adapter = new CityMangerAdapter(mData, this);
        cityLv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<DataBaseBean> list = DBManger.queryAllInfo();
        mData.clear();
        mData.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.city_iv_back:
                finish();
                break;

            case R.id.city_iv_delete:
                intent.setClass(this,DeleteActivity.class);
                startActivity(intent);
                break;

            case R.id.city_add_iv:
                int countCity = DBManger.getCountCity();
                if(countCity<5){
                    intent.setClass(this,SearchActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "存储城市信息已满，请删除红藕添加", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}