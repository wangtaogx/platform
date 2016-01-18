package com.tao.dao.base.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.tao.common.parameter.Constant;
import com.tao.dao.base.BaseDao;
import com.tao.support.Pagination;

/**
 * 
 *
 */
public class BaseDaoImpl<T>  implements BaseDao<T> { 
	@Resource
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public void delete(String tag, T obj) throws DataAccessException {
		sqlMapClientTemplate.delete(tag, obj);
	}

	@SuppressWarnings("unchecked")
	public T get(String tag,T obj)throws DataAccessException {
		Object ojb = sqlMapClientTemplate.queryForObject(tag, obj);
		return (T)ojb;
	}
	
	public Object get(String tag,Serializable sil)throws DataAccessException{
		Object ojb = sqlMapClientTemplate.queryForObject(tag, sil);
		return ojb;
	}

	public void insert(String tag, T obj) throws DataAccessException {
			sqlMapClientTemplate.insert(tag, obj);
	}

	public void update(String tag, T obj) throws DataAccessException {
			sqlMapClientTemplate.update(tag, obj);
	}
	
	public void insertExecuteBatch(String tag,List<T> list)throws DataAccessException{
		for(Object obj: list){
			sqlMapClientTemplate.insert(tag, obj);
		}
	}
	
	public void deleteExecuteBatch(String tag,List<T> list)throws DataAccessException{
			for(Object obj: list){
				sqlMapClientTemplate.delete(tag, obj);
			}
	}

	public List<T> getAllListByObj(String tag, T obj) throws DataAccessException {
			@SuppressWarnings("unchecked")
			List<T> list = sqlMapClientTemplate.queryForList(tag, obj);
			return list;
	}

	public List<T> getAllList(String tag)throws DataAccessException{
			@SuppressWarnings("unchecked")
			List<T> list = sqlMapClientTemplate.queryForList(tag);
			return list;
	}
	
	public List<T> getPaginationList(String tag,T obj,Pagination<T> pg)throws DataAccessException{
			List<T> list = null;
			if(pg != null){
				long startIndex = pg.getStart();
				//int endIndex = pg.getStart()+pg.getPageSize();
				Object countAll = null;
				if(obj==null){
					//list = client.queryForList(tag, startIndex, pg.getPageSize());
					countAll = sqlMapClientTemplate.queryForObject(tag+Constant.COUNT_ALL);
				}else{
					//list = client.queryForList(tag, obj, startIndex, pg.getPageSize());
					countAll = sqlMapClientTemplate.queryForObject(tag+Constant.COUNT_ALL, obj);
				}
				if(countAll != null){
					int total = Integer.parseInt(countAll.toString());
					pg.setTotal(total);//总条数
					int quotient = total%pg.getPageSize();//剩余10条
					int pt = total/pg.getPageSize();//页数
					if(quotient!=0){
						pt++;
					}
					pg.setPageTotal(pt);
				}
			}
			return list;
	}
	
	public List<T> getAllList(String tag, T obj, Long start, Long end)
			throws DataAccessException {
			List<T> list = null;
			if(obj==null){
				//list = sqlMapClientTemplate.queryForList(tag, start, end);
			}else{
				//list = sqlMapClientTemplate.queryForList(tag, obj, start, end);
			}
			return list;
	}
}
