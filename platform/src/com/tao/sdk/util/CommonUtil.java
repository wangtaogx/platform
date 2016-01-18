package com.tao.sdk.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class CommonUtil {

	
	public String getUrl(){
		return "192.168.0.225";
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
    /**
     * 数组arry 中是否包含 item
     * @param arry
     * @param item
     * @return
     */
    public static boolean isContain(Object[] arry,Object item)
    {
    	if (arry == null) {
			return false;
		}else if (arry.length == 0) {
			return false;
		}
    	for (int i = 0; i < arry.length; i++) {
			if (arry[i] .equals(item)) {
				return true;
			}
		}
		return false;
    }


    /**
     * 获取当前时间
     * @return
     */
	public static String getSysNowTime(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
	}
	
	public static String getSysNowTimeForChat(){
		return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINA).format(new Date());
	}
	
	
	/**
	 * 获取当前时间，返回HH:MM:SS格式
	 * @return
	 */
	public static String getShortTime(){
		return new SimpleDateFormat("hh:mm:ss", Locale.CHINA).format(new Date());
	}
	
	/**
	 * 获取当前时间，返回yyyy-MM-dd格式
	 * @return
	 */
	public static String getShortDate(){
		return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date());
	}
	
	/**
	 * 删除文件
	 * @param file
	 * @param isDir 是否有子文件夹
	 * @return
	 */
	public static boolean deleteFile(File file, boolean isDir)
	{
		if (file == null)
			return false;
		
		if (!file.exists())
			return false;
		
		if (file.isFile())
		{
			boolean isSuccess = file.delete();
			if (!isSuccess)
				return false;
		}
		else if (file.isDirectory())
		{
			File files[] = file.listFiles();
			for (int i = 0; i < files.length; i++)
				deleteFile(files[i], isDir);
			
			if (isDir)
			{
				boolean isSuccess = file.delete();
				if (!isSuccess)
					return false;
			}
		}
		else
		{
			return false;
		}
		
		return true;
	}
	

	
	/**
	 * 创建文件夹
	 * @param dir
	 * @return
	 */
	public static boolean createDir(String dir)
	{
		if (dir == null)
			return false;
		
		 File file = new File(dir);
		if (!file.exists())
		{
			if (!file.mkdirs())
				return false;
		}
		
		return true;
	}
	
	/**
	 * 验证IP地址是否合格
	 * @param serciceIp
	 * @return
	 */
	public static boolean checkIp(String serciceIp) {
		if(StringUtil.isEmpty(serciceIp)) {
			return false;
		}
		//使用"\\."进行分隔，得到各个值
		String[] ipItems = serciceIp.split("\\.");
		if(ipItems == null || ipItems.length != 4) {
			return false;
		} else {
			boolean flag = true;
			for(int i=0; i<ipItems.length; i++) {
				if(NumberUtil.isNumber(ipItems[i]) == false) {
					flag = false;
					break;
				}
			}
			return flag;
		}
	}
	
	public static <K, V> List<V> mapConvertToList(Map<K, V> map) {
		List<V> list = new ArrayList<V>();
		for (V value : map.values()) {
			list.add(value);
		}
		return list;
	}
}
