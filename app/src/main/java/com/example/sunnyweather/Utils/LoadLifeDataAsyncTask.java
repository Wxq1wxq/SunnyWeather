package com.example.sunnyweather.Utils;

import android.content.Context;
import android.os.AsyncTask;

import androidx.core.content.ContextCompat;

public class LoadLifeDataAsyncTask extends AsyncTask<String,Void,String> {
    Context context;
    LifeListener listener;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public LifeListener getListener() {
        return listener;
    }

    public void setListener(LifeListener listener) {
        this.listener = listener;
    }

    public LoadLifeDataAsyncTask(Context context, LifeListener listener) {
        this.context = context;
        this.listener = listener;
    }

   public interface LifeListener{
        public void lifeOnSuccess(String json);
    }
    @Override
    protected String doInBackground(String... strings) {
      String json=  HttpUtils.getJsonFormNet(strings[0]);
        return json;
    }

    @Override
    protected void onPostExecute(String s) {
        listener.lifeOnSuccess(s);
        super.onPostExecute(s);
    }
}
