package com.tao.sdk.module.preference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/22.
 */
public class PreferenceManager {
    public static final String PREFERENCE_GLOBAL = "global";
    public static final String PREFERENCE_CACHE = "cache";
    private static PreferenceManager instance = new PreferenceManager();
    private Map<String,Preference> preferenceMap = new HashMap<String,Preference>();
    private Logger logger = LoggerFactory.getLogger(PreferenceManager.class);
    private PreferenceManager(){
        preferenceMap.put(PREFERENCE_GLOBAL,new PreferenceDefault());
        preferenceMap.put(PREFERENCE_CACHE,new PreferenceDefault());
        logger.debug("PreferenceManager created");
    }
    public static PreferenceManager getInstance(){
        return instance;
    }
    public Preference getGlobalPreference(){
        return preferenceMap.get(PREFERENCE_GLOBAL);
    }
    public void setGlobalPreference(Preference preference){
        preferenceMap.put(PREFERENCE_GLOBAL,preference);
    }
    public Preference getCachePreference(){
        return preferenceMap.get(PREFERENCE_CACHE);
    }
    public Preference setCachePreference(Preference preference){
        return preferenceMap.put(PREFERENCE_CACHE,preference);
    }
    public Preference getCustomPreference(String preferenceID){
        return preferenceMap.get(preferenceID);
    }
    public Preference setCustomPreference(String preferenceID,Preference customPreference){
        return preferenceMap.put(preferenceID,customPreference);
    }
}
