package com.example.sunnyweather;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sunnyweather.R;
import com.example.sunnyweather.Utils.LoadDataAsyncTask;
import com.example.sunnyweather.Utils.LoadLifeDataAsyncTask;
import com.example.sunnyweather.bean.LifeindexBean;
import com.example.sunnyweather.bean.WeatherBean;
import com.example.sunnyweather.db.DBManger;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("SwitchStatementWithoutDefaultBranch")
public class CityWeatherFragment extends Fragment implements View.OnClickListener , LoadDataAsyncTask.WeatherListener, LoadLifeDataAsyncTask.LifeListener {
TextView currentTempTv,cityTv,conditionTv,windTv,tempRangeTv,dateTv,clothIndexTv,carIndexTv,coldIndexTv,sportIndexTv,raysIndexTv;
ImageView dayIv;
LinearLayout futureLayout;
LifeindexBean.ResultDTO.LifeDTO lifeResultBean;
String city;
//天气查询地址
//http://apis.juhe.cn/simpleWeather/query?city=%E6%B8%A9%E5%B7%9E&key=bfec4b933414336e5fcc129db3c57ad3
String weatherUrl1="http://apis.juhe.cn/simpleWeather/query?city=";
String weatherUrl2="&key=bfec4b933414336e5fcc129db3c57ad3";
//生活指数查询地址http:
    //http://apis.juhe.cn/simpleWeather/life?city=%E4%B8%8A%E6%B5%B7&key=bfec4b933414336e5fcc129db3c57ad3
    String lifeUrl1="http://apis.juhe.cn/simpleWeather/life?city=";
    String lifeUrl2="&key=bfec4b933414336e5fcc129db3c57ad3";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_city_weather, container, false);
        initView(view);
        //通过从main setArgument方法，把city变量传递过来，使用getArgument 接收
        Bundle bundle = getArguments();
        city=bundle.getString("city");
        String weatherUrl=weatherUrl1+city+weatherUrl2;
        Log.d("TAG",weatherUrl );
        String lifeUrl=lifeUrl1+city+lifeUrl2;
        Log.d("TAG",lifeUrl );
        LoadDataAsyncTask weatherTask=new LoadDataAsyncTask(getContext(),this);
        weatherTask.execute(weatherUrl);
        LoadLifeDataAsyncTask lifeTask=new LoadLifeDataAsyncTask(getContext(),this);
        lifeTask.execute(lifeUrl);

        return view;
    }
    @Override
    public void weatherOnSuccess(String json) {
        WeatherBean weatherBean = new Gson().fromJson(json, WeatherBean.class);
        WeatherBean.ResultDTO resultBean = weatherBean.getResult();
        String date = resultBean.getFuture().get(0).getDate();
        dateTv.setText(date);
        cityTv.setText(resultBean.getCity());
        WeatherBean.ResultDTO.FutureDTO todayBean = resultBean.getFuture().get(0);
        currentTempTv.setText(resultBean.getRealtime().getTemperature());
        conditionTv.setText(resultBean.getRealtime().getInfo());
        windTv.setText(resultBean.getRealtime().getDirect());
        tempRangeTv.setText(todayBean.getTemperature());
        List<WeatherBean.ResultDTO.FutureDTO> future = resultBean.getFuture();
        future.remove(0);
        //设置未来多天的信息
        for (int i=0;i<future.size();i++){
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_main_center, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            futureLayout.addView(view);
            TextView tempTv=view.findViewById(R.id.item_center_temp);
            TextView dateTv=view.findViewById(R.id.item_center_date_tv);
            TextView weatherTv=view.findViewById(R.id.item_center_weather);
            WeatherBean.ResultDTO.FutureDTO weather = future.get(i);
            tempTv.setText(weather.getTemperature());
            dateTv.setText(weather.getDate());
            weatherTv.setText(weather.getWeather());
            Log.d("TAG", "parseShowWeatherData: ");
        }
       int i= DBManger.updateInfoByCity(city,json);
        if(i<=0){
            //更新数据库失败，说明没有这个城市信息，可以增加这个城市信息
            DBManger.addCityInfo(city,json);
        }
    }

    @Override
    public void lifeOnSuccess(String json) {
        LifeindexBean lifeindexBean = new Gson().fromJson(json, LifeindexBean.class);
        lifeResultBean =lifeindexBean.getResult().getLife();
        clothIndexTv.setOnClickListener(this);
        carIndexTv.setOnClickListener(this);
        coldIndexTv.setOnClickListener(this);
        sportIndexTv.setOnClickListener(this);
        raysIndexTv.setOnClickListener(this);

    }

    private void initView(View view) {
        currentTempTv=view.findViewById(R.id.frag_currenttemp_tv);
        cityTv=view.findViewById(R.id.frag_city_tv);
        conditionTv=view.findViewById(R.id.frag_condition_tv);
        windTv=view.findViewById(R.id.frag_wind_tv);
        tempRangeTv=view.findViewById(R.id.frag_temprange_tv);
        dateTv=view.findViewById(R.id.frag_date_tv);
        clothIndexTv=view.findViewById(R.id.frag_index_dress);
        carIndexTv=view.findViewById(R.id.frag_index_washcar);
        coldIndexTv=view.findViewById(R.id.frag_index_cold);
        sportIndexTv=view.findViewById(R.id.frag_index_sport);
        raysIndexTv=view.findViewById(R.id.frag_index_rays);
        dayIv=view.findViewById(R.id.frag_today_iv);
        futureLayout=view.findViewById(R.id.frag_center_layout);
    }

    @SuppressWarnings("SwitchStatementWithoutDefaultBranch")
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        switch (v.getId()) {
            case R.id.frag_index_dress:
                builder.setTitle("穿衣指数")
                        .setMessage(lifeResultBean.getChuanyi().getDes())
                        .setPositiveButton("确定",null);
                break;
            case R.id.frag_index_washcar:
                builder.setTitle("洗车指数")
                        .setMessage(lifeResultBean.getXiche().getDes())
                        .setPositiveButton("确定",null);
                break;
            case R.id.frag_index_cold:
                builder.setTitle("感冒指数")
                        .setMessage(lifeResultBean.getGanmao().getDes())
                        .setPositiveButton("确定",null);
                break;
            case R.id.frag_index_sport:
                builder.setTitle("运动指数")
                        .setMessage(lifeResultBean.getYundong().getDes())
                        .setPositiveButton("确定",null);
                break;
            case R.id.frag_index_rays:
                builder.setTitle("紫外线指数")
                        .setMessage(lifeResultBean.getZiwaixian().getDes())
                        .setPositiveButton("确定",null);
                break;
        }
        builder.create().show();
    }

}