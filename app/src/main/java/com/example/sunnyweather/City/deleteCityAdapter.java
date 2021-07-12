package com.example.sunnyweather.City;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunnyweather.R;

import java.util.List;

public class deleteCityAdapter extends BaseAdapter {
    Context context;
    List<String> mData;
    List<String> citys;

    public deleteCityAdapter(Context context, List<String> mData,List<String> citys) {
        this.context = context;
        this.mData = mData;
        this.citys=citys;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<String> getmData() {
        return mData;
    }

    public void setmData(List<String> mData) {
        this.mData = mData;
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
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_delete,null);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);

        }else{
            vh=(ViewHolder) convertView.getTag();
        }
        vh.cityTv.setText(mData.get(position));
        vh.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.remove(mData.get(position));
                citys.remove(mData.get(position));
                notifyDataSetChanged();
            }
        });


        return convertView;
    }
    class ViewHolder{
        TextView cityTv;
        ImageView deleteIv;
        public ViewHolder(View view){
            cityTv=view.findViewById(R.id.item_delete_tv);
            deleteIv=view.findViewById(R.id.item_delete_iv);
        }
    }
}
