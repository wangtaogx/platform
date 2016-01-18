package com.tao.support;

/**
 * 分页
 *
 * @param <T>
 */
public class Pagination<T> { 
	
	/**一页显示的信息个数*/
	private int pageSize;
	/**总信息数*/
	private long total;
	/**当前页*/
	private int pageNo;
	/**总页数*/
	private int pageTotal;
	
	private long start;
	
	private long end;
	
	public Pagination(long start,int pageSize){
		this.start = start;
		this.pageSize = pageSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}
	
	
}
