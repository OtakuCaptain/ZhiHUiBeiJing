package com.chen.zhihuibeijing.util;

import android.content.Context;

/**
 * Created by chen on 2016-12-19.
 */

public class CacheUtil {
    /**
     * @param url  key
     * @param json value
     */
    public static void setCache(Context context, String url, String json) {
        PrefUtil.setString(context, url, json);

    }

    /**
     * 获取缓存
     * @param context
     * @param url
     * @return
     */
    public static String getCache(Context context, String url) {
        return PrefUtil.getString(context, url, null);

    }
}
