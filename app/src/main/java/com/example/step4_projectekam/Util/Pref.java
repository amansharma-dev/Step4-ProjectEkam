package com.example.step4_projectekam.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.core.content.ContextCompat;

import com.example.step4_projectekam.R;

public class Pref {

    private SharedPreferences sharedPreferences;

    public Pref(Activity activity) {
        this.sharedPreferences = activity.getPreferences(activity.MODE_PRIVATE);
    }

    public void saveReview(String review){
        sharedPreferences.edit().putString("new_review",review).apply();
    }

    public String getReview(){
        return sharedPreferences.getString("new_review","");
    }

    public void setState(int color){
        sharedPreferences.edit().putInt("bg_color",color).apply();
    }

    public int getState(){
        return sharedPreferences.getInt("bg_color", 0);
    }
}
