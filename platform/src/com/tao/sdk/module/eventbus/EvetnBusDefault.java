package com.tao.sdk.module.eventbus;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Administrator on 2015/12/16.
 */
public class EvetnBusDefault implements EventBus{
    private Set<Object> subscribers  = new CopyOnWriteArraySet<Object>();
    @Override
    public void post(Object event) {
        for(Object sub : subscribers){
            try {
                Method method = sub.getClass().getMethod("onEvent", event.getClass());
                if(method != null){
                    method.invoke(sub,event);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void resgister(Object subscriber){
        subscribers.add(subscriber);
    }
    public void unresgister(Object subscriber){
        subscribers.remove(subscriber);
    }
}
