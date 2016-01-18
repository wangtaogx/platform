package com.tao.sdk.module.eventbus;

/**
 * Created by Administrator on 2015/12/16.
 */
public class BaseEvent {
    public static final String EVENT_ADD = "EVENT_ADD";
    public static final String EVENT_DELETE = "EVENT_DELETE";
    public static final String EVENT_MODIFY = "EVENT_MODIFY";
    public static final String EVENT_QUERY = "EVENT_QUERY";
    public static final String EVENT_SWITCH = "EVENT_SWITCH";
    public static final String EVENT_REFRESH = "EVENT_REFRESH";

    private String action;

    public BaseEvent(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
