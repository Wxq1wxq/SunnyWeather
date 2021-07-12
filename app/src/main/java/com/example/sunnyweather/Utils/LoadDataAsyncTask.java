package com.example.sunnyweather.Utils;

import android.content.Context;
import android.os.AsyncTask;

public class LoadDataAsyncTask extends AsyncTask<String,Void,String> {
    Context context;
    WeatherListener listener;

    public LoadDataAsyncTask(Context context, WeatherListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public WeatherListener getListener() {
        return listener;
    }

    public void setListener(WeatherListener listener) {
        this.listener = listener;
    }

    public interface WeatherListener{
        public void weatherOnSuccess(String json);
    }
    public LoadDataAsyncTask() {
    }

    @Override
    protected String doInBackground(String... strings) {//必须重写，里面包含网络请求等耗时操作
       String json= HttpUtils.getJsonFormNet(strings[0]);
        return json;
    }

    @Override
    protected void onPostExecute(String s) {//必须重写，里面包含相关的UI操作,s是doInBackground返回值
        listener.weatherOnSuccess(s);
        super.onPostExecute(s);
    }

}
