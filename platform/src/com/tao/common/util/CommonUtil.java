package com.tao.common.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class CommonUtil<T extends Object> {

	public static boolean stringIsNotEmpty(String text)
	{
		if(text !=null && !"".equals(text))
		{
			return true;
		}
		return false;
	}
	public static boolean stringIsEmpty(String text)
	{
		if(text ==null || "".equals(text))
		{
			return true;
		}
		return false;
	}
	public static boolean collectionIsEmpty(List<Object> list)
	{
		if(list != null && list.size() > 0)
			return true;
		return false;
	}
	public static boolean collectionIsNotEmpty(List<Object> list)
	{
		if(list == null || list.size() == 0)
			return true;
		return false;
	}
	public static<T> List<T> arrayToList(T[] objects)
	{
		ArrayList<T> list =new ArrayList<T>(); 
		if(objects!=null)
		{
			for(T o : objects)
			{
				list.add(o);
			}
		}
		return list;
	}
}
