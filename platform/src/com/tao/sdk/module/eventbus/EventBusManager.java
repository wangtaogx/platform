package com.tao.sdk.module.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2015/12/16.
 */
public class EventBusManager {

    private static EventBusManager instance = new EventBusManager();
    private EventBus eventBus = new EvetnBusDefault();
    private Logger logger = LoggerFactory.getLogger(EventBusManager.class);
    private EventBusManager(){
        logger.debug("EventBusManager created");
    }
    public static EventBusManager getInstance(){
        return  instance;
    }
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void post(Object object){
        if(eventBus != null){
            eventBus.post(object);
        }
    }
    public void register(Object subscriber){
        if(eventBus != null){
            eventBus.resgister(subscriber);
        }
    }
    public void unregister(Object subscriber){
        if(eventBus != null){
            eventBus.unresgister(subscriber);
        }
    }
}
