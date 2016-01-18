package com.tao.sdk.module.preference;

import com.alibaba.fastjson.JSONObject;
import com.tao.sdk.util.StringUtil;


/**
 * Created by Administrator on 2015/12/22.
 */
public class PreferenceDefault implements Preference {
    private JSONObject jsonObject = new JSONObject();
    @Override
    public String getString(String key, String defaultValue) {
        String result = jsonObject.getString(key);
        if(StringUtil.isEmpty(result))
            result = defaultValue;
        return  result;
    }

    @Override
    public void putString(String key, String value) {
        jsonObject.put(key,value);
    }

    @Override
    public int getInt(String key, int defaultValue) {
        Integer result = jsonObject.getInteger(key);
        if(result == null)
            result = defaultValue;
        return result;
    }

    @Override
    public void putInt(String key, int value) {
        jsonObject.put(key,value);
    }

    @Override
    public void putLong(String key, long value) {
        jsonObject.put(key,value);
    }

    @Override
    public long getLong(String key, long defaultValue) {
        Long result = jsonObject.getLong(key);
        if(result == null)
            result = defaultValue;
        return result;
    }

    @Override
    public void putFloat(String key, float value) {
        jsonObject.put(key,value);
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        Float result = jsonObject.getFloat(key);
        if(result == null)
            result = defaultValue;
        return result;
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        Boolean result = jsonObject.getBoolean(key);
        if(result == null)
            result = defaultValue;
        return result;
    }

    @Override
    public void putBoolean(String key, boolean value) {
        jsonObject.put(key,value);
    }

    @Override
    public void clearAllCustomGwData() {
        jsonObject.clear();
    }

    @Override
    public boolean containsKey(String key) {
        return jsonObject.containsKey(key);
    }
}
