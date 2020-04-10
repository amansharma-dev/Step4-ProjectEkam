package com.example.step4_projectekam.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

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
}
