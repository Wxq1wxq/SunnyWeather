package com.example.sunnyweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class DBManger {
    public  static SQLiteDatabase database;
    public static  void initDB(Context context){
        DBHelper dbHelper = new DBHelper(context);
        database=dbHelper.getWritableDatabase();
    }
    //获取数据库中的城市数据信息
    public static List<String> queryAllCityName(){
        Cursor cursor = database.query("info", null, null, null, null, null, null);
        List<String> cityList=new ArrayList<>();
        while (cursor.moveToNext()) {
           String city= cursor.getString(cursor.getColumnIndex("city"));
           cityList.add(city);
        }
        return cityList;
    }
public static int updateInfoByCity(String city ,String content){
    ContentValues contentValues = new ContentValues();
    contentValues.put("content",content);
    int info = database.update("info", contentValues, "city=?", new String[]{city});
    return info;
    }

    public static long addCityInfo(String city ,String content){
        ContentValues contentValues = new ContentValues();
        contentValues.put("city",city);
        contentValues.put("content",content);
        return database.insert("info",null,contentValues);
    }
    public  static String queryInfoByCity(String city){
        Cursor cursor = database.query("info", null, "city=?", new String[]{city}, null, null, null);
        if (cursor.getCount()>0) {
            cursor.moveToFirst();
            String content=cursor.getString(cursor.getColumnIndex("content"));
            return content;
        }
        return null;
    }
public  static int getCountCity(){
    Cursor cursor = database.query("info", null, null, null, null, null, null);
    return cursor.getCount();

}
public static List<DataBaseBean> queryAllInfo(){
    Cursor cursor = database.query("info", null, null, null, null, null, null);
    List<DataBaseBean> list=new ArrayList<>();
    while(cursor.moveToNext()){
        int id = cursor.getInt(cursor.getColumnIndex("_id"));
        String city = cursor.getString(cursor.getColumnIndex("city"));
        String content = cursor.getString(cursor.getColumnIndex("content"));
        DataBaseBean bean = new DataBaseBean(city, id, content);
        list.add(bean);

    }
    return list;
}
public  static int deleteInfoByCity(String city){
       return database.delete("info","city=?",new String[]{city});
}

}
