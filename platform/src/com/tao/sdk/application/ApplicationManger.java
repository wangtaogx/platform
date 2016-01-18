package com.tao.sdk.application;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.tao.sdk.core.ConnectionManager;
import com.tao.sdk.core.Module;
import com.tao.sdk.core.http.HttpManager;
import com.tao.sdk.core.http.HttpProviderFactory;
import com.tao.sdk.module.eventbus.EventBus;
import com.tao.sdk.module.eventbus.EventBusManager;
import com.tao.sdk.module.preference.Preference;
import com.tao.sdk.module.preference.PreferenceManager;
import com.tao.sdk.module.serverstate.ServerStateManager;


public class ApplicationManger {
	
	private static ApplicationManger instance = new ApplicationManger();
	private List<String> moduleClasses = new ArrayList<String>();
	private ApplicationManger() {
	} 
	private void initModuleClasses(){
		moduleClasses.add(ServerStateManager.class.getName());
	}
	public void startModules(List<String> moduleClasses){
        initModuleClasses();
        for(String clazzName : this.moduleClasses ){
            try{
                Class<?> clazz = ApplicationManger.class.getClassLoader().loadClass(clazzName);
                Method method = clazz.getMethod("getInstance", null);
                Object object = method.invoke(null, null);
                if(object instanceof Module){
                    Module m = (Module) object;
                    m.init(ConnectionManager.getInstance());
                }
            }catch(Exception e){

            }
        }
    }
	public static ApplicationManger getInstance(){
		return instance;
	}

    public void initEventBusInstance(EventBus eventBus){
        EventBusManager.getInstance().setEventBus(eventBus);
    }
    public void initHttpProviderFactory(HttpProviderFactory httpProviderFactory){
        HttpManager.setHttpProviderFactory(httpProviderFactory);
    }
    public void initGlobalPreference(Preference preference){
        PreferenceManager.getInstance().setGlobalPreference(preference);
    }
    public void initCachePreference(Preference preference){
        PreferenceManager.getInstance().setCachePreference(preference);
    }
}
