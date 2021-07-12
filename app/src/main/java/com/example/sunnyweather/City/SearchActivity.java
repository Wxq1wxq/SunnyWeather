package com.example.sunnyweather.City;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sunnyweather.MainActivity;
import com.example.sunnyweather.R;
import com.example.sunnyweather.Utils.LoadDataAsyncTask;
import com.example.sunnyweather.bean.WeatherBean;
import com.google.gson.Gson;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener,LoadDataAsyncTask.WeatherListener, AdapterView.OnItemClickListener {
EditText searchEt;
ImageView searchIv;
GridView searchGv;
String[] hotCitys = {"北京","上海","广州","深圳","珠海","佛山","南京","苏州","厦门","长沙","成都","福州",
            "杭州","武汉","青岛","西安","太原","沈阳","重庆","天津","南宁"};
Integer errorCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        searchEt=findViewById(R.id.search_et);
        searchIv=findViewById(R.id.search_iv_submit);
        searchGv=findViewById(R.id.search_gv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_hostcity, hotCitys);
        searchGv.setAdapter(adapter);
        searchIv.setOnClickListener(this);
        searchGv.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.search_iv_submit:
                String city = searchEt.getText().toString();
                if (!TextUtils.isEmpty(city)) {
                    String weatherUrl1="http://apis.juhe.cn/simpleWeather/query?city=";
                    String weatherUrl2="&key=bfec4b933414336e5fcc129db3c57ad3";
                    String url=weatherUrl1+city+weatherUrl2;
                    LoadDataAsyncTask task = new LoadDataAsyncTask(this, this);
                    task.execute(url);
                    if(errorCode==0){
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("city",city);
                        startActivity(intent);

                    }else{
                        Toast.makeText(this, "输入的城市不存在", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(this, "输入的内容不能为空", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public void weatherOnSuccess(String json) {
        WeatherBean bean = new Gson().fromJson(json, WeatherBean.class);
        errorCode = bean.getErrorCode();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String hotCity = hotCitys[position];
    }
}