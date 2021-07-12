package com.example.sunnyweather.Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {
    public static String  getJsonFormNet(String path){
        String json="";
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        try {
            URL url=new URL(path);
            try {
                HttpURLConnection con =(HttpURLConnection) url.openConnection();
                con.connect();
                InputStream is = con.getInputStream();
                int count=0;
                byte[] buff=new byte[1024];
                while((count=is.read(buff))!=-1){
                    byteArrayOutputStream.write(buff,0,count);
                }
                is.close();
                 json = byteArrayOutputStream.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return json;
    }
}
