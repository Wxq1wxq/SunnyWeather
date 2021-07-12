package com.example.sunnyweather.City;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.sunnyweather.R;
import com.example.sunnyweather.db.DBManger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
ImageView errorIv,rightIv;
ListView deleteLv;
List<String> mData;
List<String> citys;
deleteCityAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        errorIv=findViewById(R.id.delete_iv_error);
        rightIv=findViewById(R.id.delete_iv_right);
        deleteLv=findViewById(R.id.delete_lv_content);
        mData=new ArrayList<>();
        citys=new ArrayList<>();
        adapter = new deleteCityAdapter(this, mData, citys);
        deleteLv.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        List<String> cityList= DBManger.queryAllCityName();
        mData.addAll(cityList);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.delete_iv_error:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示信息")
                        .setMessage("您确定要放弃更改吗？")
                        .setPositiveButton("放弃更改", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create()
                        .show();
                break;
            case R.id.delete_iv_right:
                for(int i=0;i<citys.size();i++){
                    String city=citys.get(i);
                    DBManger.deleteInfoByCity(city);
                }
                break;
        }
    }
}