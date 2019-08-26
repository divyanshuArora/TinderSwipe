package com.example.tinderswipe;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils
{
    private static final String TAG = "Utils";
    public  static List<TinderModel> loadProfile (Context context)
    {
        try
        {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            JSONArray jsonArray = new JSONArray(loadJSONFromAssets(context,"profiles.json"));

            List<TinderModel> tinderModelList = new ArrayList<>();
            for (int i=0 ; i<jsonArray.length() ; i++ )
            {
                TinderModel tinderModel = gson.fromJson(jsonArray.getString(i),TinderModel.class);
                tinderModelList.add(tinderModel);
            }
            return  tinderModelList;

        }
        catch (Exception e)
        {
            return null;
        }
    }

    private static String loadJSONFromAssets(Context context, String jsonFileName)
    {
        String json = null;
        InputStream inputStream = null;
        try
        {
            AssetManager assetManager = context.getAssets();
            Log.d(TAG, "Path: "+jsonFileName);
            inputStream = assetManager.open(jsonFileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            Log.d(TAG, "loadJSONFromAssets: "+buffer);
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer,"UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }
        return  json;
    }






}
