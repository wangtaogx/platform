package com.tao.model;

public class SystemParameter {

	private String key;
	private String value;
	private String desc;
	
	public SystemParameter(String key, String value, String desc) {
		this.key = key;
		this.value = value;
		this.desc = desc;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
