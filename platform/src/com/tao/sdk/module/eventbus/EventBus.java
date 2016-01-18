package com.tao.sdk.module.eventbus;

/**
 * Created by Administrator on 2015/12/16.
 */
public interface EventBus {

    public void post(Object event);
    public void resgister(Object subscriber);
    public void unresgister(Object subscriber);
}
