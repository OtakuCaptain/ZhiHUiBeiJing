package com.chen.zhihuibeijing.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtil {

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static void setString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static void setInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).apply();
    }

}