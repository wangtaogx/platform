package com.tao.common.parameter;

public class EnumParameter {

	public static enum Status{
		ST_UNDEFINED(-1),
		ST_YES(1),
		ST_NO(2);
		private int value;
		Status(int value)
		{
			this.value = value;
		}
		public String getStatusDesc(int value)
		{
			switch(value)
			{
			case 1:
				return "开启";
			case 2:
				return "未开启";
			}
			return "未定义";
		}
	}
	
}
