package com.tao.dao.base;

import java.io.Serializable;
import java.util.List;

import com.tao.support.Pagination;

/**
 * 
 * @author xiuqian.du
 *
 */
public interface BaseDao<T> { 
	
	public void insert(String tag,T obj)throws Exception;
	
	public void update(String tag,T obj)throws Exception;
	
	public void delete(String tag,T obj)throws Exception;
	
	public T get(String tag,T obj)throws Exception;
	
	public Object get(String tag,Serializable sil)throws Exception;
	
	public List<T> getAllListByObj(String tag,T obj)throws Exception;
	
	public List<T> getAllList(String tag)throws Exception;
	
	public List<T> getPaginationList(String tag,T obj,Pagination<T> pg)throws Exception;
	
	public List<T> getAllList(String tag,T obj,Long start,Long end)throws Exception;
	
	public void insertExecuteBatch(String tag,List<T> list)throws Exception;
	
	public void deleteExecuteBatch(String tag,List<T> list)throws Exception;
}
