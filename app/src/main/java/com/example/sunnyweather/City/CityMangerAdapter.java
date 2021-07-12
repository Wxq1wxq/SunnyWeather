package com.example.sunnyweather.City;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sunnyweather.R;
import com.example.sunnyweather.bean.WeatherBean;
import com.example.sunnyweather.db.DataBaseBean;
import com.google.gson.Gson;

import java.util.List;

public class CityMangerAdapter extends BaseAdapter {
    List<DataBaseBean> mData;
    Context context;

    public CityMangerAdapter(List<DataBaseBean> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }
    public List<DataBaseBean> getmData() {
        return mData;
    }

    public void setmData(List<DataBaseBean> mData) {
        this.mData = mData;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_city_manger,null);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
                vh=(ViewHolder) convertView.getTag();
        }
        DataBaseBean bean = mData.get(position);
        vh.cityTv.setText(bean.getCity());
        WeatherBean weatherBean = new Gson().fromJson(bean.getContent(), WeatherBean.class);
        vh.conTv.setText( weatherBean.getResult().getFuture().get(0).getWeather());
        vh.currentTempTv.setText(weatherBean.getResult().getRealtime().getTemperature());
        vh.windTv.setText(weatherBean.getResult().getRealtime().getDirect());
        vh.tempRangeTv.setText(weatherBean.getResult().getFuture().get(0).getTemperature());
        return convertView;
    }
    class ViewHolder{
        TextView cityTv,conTv,currentTempTv,windTv,tempRangeTv;
        public  ViewHolder(View view){
            cityTv=view.findViewById(R.id.item_cityName_tv);
            conTv=view.findViewById(R.id.item_city_condition);
            currentTempTv=view.findViewById(R.id.item_city_currentTemp_tv);
            windTv=view.findViewById(R.id.item_city_wind);
            tempRangeTv=view.findViewById(R.id.item_city_temprange_tv);
        }
    }
}
