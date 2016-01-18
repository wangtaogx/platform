package com.tao.sdk.util;

public class ConstUtil {

	/** 传感器类别 start **/
	/**
	 * 00--网关--
	 */
	public static final String DEV_TYPE_FROM_GW_GATEWAY = "00";
	/**
	 * 01--声光报警器--d
	 */
	public static final String DEV_TYPE_FROM_GW_WARNING = "01";
	/**
	 * 02--红外感应器--P
	 */
	public static final String DEV_TYPE_FROM_GW_MOTION = "02";
	/**
	 * 03--门窗磁感应器--M
	 */
	public static final String DEV_TYPE_FROM_GW_CONTACT = "03";
	/**
	 * 04--紧急按钮--J
	 */
	public static final String DEV_TYPE_FROM_GW_EMERGENCY = "04";
	/**
	 * 05--电子栅栏--F
	 */
	public static final String DEV_TYPE_FROM_GW_MOTION_F = "05";
	/**
	 * 06--漏水感应器--E
	 */
	public static final String DEV_TYPE_FROM_GW_WATER = "06";
	/**
	 * 07--烟雾感应器--Y
	 */
	public static final String DEV_TYPE_FROM_GW_FIRE = "07";
	/**
	 * 08--氨气感应器--c
	 */
	public static final String DEV_TYPE_FROM_GW_NH3 = "08";
	/**
	 * 09--可燃气感应器--Q
	 */
	public static final String DEV_TYPE_FROM_GW_GAS = "09";
	/**
	 * 10--可燃气阀门--h
	 */
	public static final String DEV_TYPE_FROM_GW_GAS_VALVE = "10";
	/**
	 * 11--照明开关--G
	 */
	public static final String DEV_TYPE_FROM_GW_LIGHT = "11";
	/**
	 * 12--调光开关--D
	 */
	public static final String DEV_TYPE_FROM_GW_D_LIGHT = "12";
	/**
	 * 13--二路调光开关--D
	 */
	public static final String DEV_TYPE_FROM_GW_DUAL_D_LIGHT = "13";
	/**
	 * 14--澳洲一键调光
	 */
	public static final String DEV_TYPE_FROM_GW_AUS_DIMMING_LIGHT = "14";
	/**
	 * 15--移动计量插座--E
	 */
	public static final String DEV_TYPE_FROM_GW_EMS = "15";
	/**
	 * 16--移动插座--S
	 */
	public static final String DEV_TYPE_FROM_GW_DOCK = "16";
	/**
	 * 17--温湿度检测器--H
	 */
	public static final String DEV_TYPE_FROM_GW_TEMHUM = "17";
	/**
	 * 18--CO2检测器--C
	 */
	public static final String DEV_TYPE_FROM_GW_CO2 = "18";
	/**
	 * 19--光强检测器--l
	 */
	public static final String DEV_TYPE_FROM_GW_LIGHT_S = "19";
	/**
	 * 20--VOC检测器--
	 */
	public static final String DEV_TYPE_FROM_GW_VOC = "20";
	/**
	 * 21--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_21 = "21";
	/**
	 * 22--红外转发器--T
	 */
	public static final String DEV_TYPE_FROM_GW_IR_CONTROL = "22";
	/**
	 * 23--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_23 = "23";
	/**
	 * 24--万能红外转发器--E
	 */
	public static final String DEV_TYPE_FROM_GW_AR_IR_CONTROL = "24";
	/**
	 * 25--机械手--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_MECHANICAL_ARM = "25";
	/**
	 * 26--自动门--h
	 */
	public static final String DEV_TYPE_FROM_GW_DOOR_CONTROL = "26";
	/**
	 * 27--道闸--h
	 */
	public static final String DEV_TYPE_FROM_GW_BARRIER = "27";
	/**
	 * 28--水阀--h
	 */
	public static final String DEV_TYPE_FROM_GW_WATER_VALVE = "28";
	/**
	 * 29--平板音响--d
	 */
	public static final String DEV_TYPE_FROM_GW_PANEL_SPEAKER = "29";
	/**
	 * 30--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_30 = "30";
	/**
	 * 31--中继器--e
	 */
	public static final String DEV_TYPE_FROM_GW_EXTENDER = "31";
	/**
	 * 32--二键场景开关--b
	 */
	public static final String DEV_TYPE_FROM_GW_TOUCH_2 = "32";
	/**
	 * 33--三键场景开关--b
	 */
	public static final String DEV_TYPE_FROM_GW_TOUCH_3 = "33";
	/**
	 * 34--四键场景开关--b
	 */
	public static final String DEV_TYPE_FROM_GW_TOUCH_4 = "34";
	/**
	 * 35--密码键盘--b
	 */
	public static final String DEV_TYPE_FROM_GW_KEYBOARD = "35";
	/**
	 * 36--六键场景开关--
	 */
	public static final String DEV_TYPE_FROM_GW_TOUCH_6 = "36";
	/**
	 * 37--六键场景开关--
	 */
	public static final String DEV_TYPE_FROM_GW_TOUCH_6_2 = "37";
	/**
	 * 38--小型遥控器--
	 */
	public static final String DEV_TYPE_FROM_GW_POCKET_KEYS = "38";
	/**
	 * 39--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_39 = "39";
	/**
	 * 40--红外感应器(移动侦测+光强)--P
	 */
	public static final String DEV_TYPE_FROM_GW_MOTION_LIGHT_S = "40";
	/**
	 * 41--水流检测器--o
	 */
	public static final String DEV_TYPE_FROM_GW_FLOW = "41";
	/**
	 * 42--空气质量--t
	 */
	public static final String DEV_TYPE_FROM_GW_CTHV = "42";
	/**
	 * 43--烟雾感应器--E
	 */
	public static final String DEV_TYPE_FROM_GW_FIRE_SR = "43";
	/**
	 * 44--粉尘检测器--E
	 */
	public static final String DEV_TYPE_FROM_GW_PM2P5 = "44";
	/**
	 * 45--电子秤--s
	 */
	public static final String DEV_TYPE_FROM_GW_SCALE = "45";
	/**
	 * 46--车位检测器--p
	 */
	public static final String DEV_TYPE_FROM_GW_CARPARK = "46";
	/**
	 * 47--人流量检测器--
	 */
	public static final String DEV_TYPE_FROM_GW_HUMAN_TRAFFIC = "47";
	/**
	 * 48--血压计--E
	 */
	public static final String DEV_TYPE_FROM_GW_SPHYGMOMETER = "48";
	/**
	 * 49--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_49 = "49";
	/**
	 * 50--墙面插座--v
	 */
	public static final String DEV_TYPE_FROM_GW_DOCK_1 = "50";
	/**
	 * 51--二路墙面插座--v
	 */
	public static final String DEV_TYPE_FROM_GW_DOCK_2 = "51";
	/**
	 * 52--一路绑定开关--w
	 */
	public static final String DEV_TYPE_FROM_GW_BUTTON_1 = "52";
	/**
	 * 53--三路墙面插座--v
	 */
	public static final String DEV_TYPE_FROM_GW_DOCK_3 = "53";
	/**
	 * 54--二路绑定开关--w
	 */
	public static final String DEV_TYPE_FROM_GW_BUTTON_2 = "54";
	/**
	 * 55--三路绑定开关--w
	 */
	public static final String DEV_TYPE_FROM_GW_BUTTON_3 = "55";
	/**
	 * 56--四路绑定开关--w
	 */
	public static final String DEV_TYPE_FROM_GW_BUTTON_4 = "56";
	/**
	 * 57--一路控制器--v
	 */
	public static final String DEV_TYPE_FROM_GW_CONTROL_1 = "57";
	/**
	 * 58--二路控制器--v
	 */
	public static final String DEV_TYPE_FROM_GW_CONTROL_2 = "58";
	/**
	 * 59--三路控制器--v
	 */
	public static final String DEV_TYPE_FROM_GW_CONTROL_3 = "59";
	/**
	 * 60--四路控制器--v
	 */
	public static final String DEV_TYPE_FROM_GW_CONTROL_4 = "60";
	/**
	 * 61--一路照明开关--v
	 */
	public static final String DEV_TYPE_FROM_GW_LIGHT_1 = "61";
	/**
	 * 62--二路照明开关--v
	 */
	public static final String DEV_TYPE_FROM_GW_LIGHT_2 = "62";
	/**
	 * 63--三路照明开关--v
	 */
	public static final String DEV_TYPE_FROM_GW_LIGHT_3 = "63";
	/**
	 * 64--四路照明开关--v
	 */
	public static final String DEV_TYPE_FROM_GW_LIGHT_4 = "64";
	/**
	 * 65--窗帘控制器--h
	 */
	public static final String DEV_TYPE_FROM_GW_SHADE = "65";
	/**
	 * 66--百叶窗--h
	 */
	public static final String DEV_TYPE_FROM_GW_BLIND = "66";
	/**
	 * 67--普通门锁--d
	 */
	public static final String DEV_TYPE_FROM_GW_DOORLOCK = "67";
	/**
	 * 68--纽扣门锁--d
	 */
	public static final String DEV_TYPE_FROM_GW_DOORLOCK_2 = "68";
	/**
	 * 69--指纹门锁--d
	 */
	public static final String DEV_TYPE_FROM_GW_DOORLOCK_3 = "69";
	/**
	 * 70--密码门锁--d
	 */
	public static final String DEV_TYPE_FROM_GW_DOORLOCK_4 = "70";
	/**
	 * 71--太阳能系统--z
	 */
	public static final String DEV_TYPE_FROM_GW_SOLARSYS = "71";
	/**
	 * 72--一路计量开关--
	 */
	public static final String DEV_TYPE_FROM_GW_EML_1 = "72";
	/**
	 * 73--二路计量开关--
	 */
	public static final String DEV_TYPE_FROM_GW_EML_2 = "73";
	/**
	 * 74--三路计量开关--
	 */
	public static final String DEV_TYPE_FROM_GW_EML_3 = "74";
	/**
	 * 75--一代云摄像机--d
	 */
	public static final String DEV_TYPE_FROM_GW_CLOUD_CAMERA = "75";
	/**
	 * 76--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_76 = "76";
	/**
	 * 77--移动计量插座--E
	 */
	public static final String DEV_TYPE_FROM_GW_EMS_SR = "77";
	/**
	 * 78--温控器--h
	 */
	public static final String DEV_TYPE_FROM_GW_THERMOSTAT = "78";
	/**
	 * 79--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_79 = "79";
	/**
	 * 80--一路可调窗帘--h
	 */
	public static final String DEV_TYPE_FROM_GW_CURTAIN_1 = "80";
	/**
	 * 81--二路可调窗帘--h
	 */
	public static final String DEV_TYPE_FROM_GW_CURTAIN_2 = "81";
	/**
	 * 82--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_82 = "82";
	/**
	 * 83--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_83 = "83";
	/**
	 * 84--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_84 = "84";
	/**
	 * 85--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_85 = "85";
	/**
	 * 86--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_86 = "86";
	/**
	 * 87--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_87 = "87";
	/**
	 * 88--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_88 = "88";
	/**
	 * 89--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_89 = "89";
	/**
	 * 90--LED炫彩灯--E
	 */
	public static final String DEV_TYPE_FROM_GW_LIGHT_LED = "90";
	/**
	 * 91--调温调色灯--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_91_Temp_led = "91";
	/**
	 * 92--调光LED灯--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_92 = "92";
	/**
	 * 93--调色调光模组--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_93_Module = "93";
	/**
	 * 94--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_94 = "94";
	/**
	 * 95--红外感应器(移动侦测+温度+湿度+光强)--E
	 */
	public static final String DEV_TYPE_FROM_GW_MOTION_TEMHUM_LIGHT_S = "95";
	/**
	 * 96--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_96 = "96";
	/**
	 * 97--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_97 = "97";
	/**
	 * 98--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_98 = "98";
	/**
	 * 99--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_99 = "99";

	/**
	 * A0--空气质量--E
	 */
	public static final String DEV_TYPE_FROM_GW_A0 = "A0";
	/**
	 * A1--四路输入转换器--E
	 */
	public static final String DEV_TYPE_FROM_GW_CONVERTERS_INPUT_4 = "A1";
	/**
	 * A2--二路输出转换器--E
	 */
	public static final String DEV_TYPE_FROM_GW_CONVERTERS_OUTPUT_2 = "A2";
	/**
	 * A3--未知--TODO
	 */
	public static final String DEV_TYPE_FROM_GW_A3 = "A3";
	/**
	 * A4--玻璃破碎感应器--E
	 */
	public static final String DEV_TYPE_FROM_GW_GLASS_BROKEN = "A4";
	/**
	 * A5--门铃按钮--E
	 */
	public static final String DEV_TYPE_FROM_GW_DOORBELL_C = "A5";
	/**
	 * A6--门铃声光器--E
	 */
	public static final String DEV_TYPE_FROM_GW_DOORBELL_S = "A6";
	/**
	 * E2--电压力煲--E
	 */
	public static final String DEV_TYPE_FROM_GW_PRESSURE_COOKER = "E2";
	/**
	 * B0--IPAD报警器--E
	 */
	public static final String DEV_TYPE_FROM_GW_IPADWARNING = "B0";
	/**
	 * B9--一路有线无线翻译器--E
	 */
	public static final String DEV_TYPE_FROM_GW_ONETRANSLATOR = "B9";
	/**
	 * C0--多功能人体运动感应器--E
	 */
	public static final String DEV_TYPE_FROM_GW_HUMANINDUCTOR = "C0";
	/**
	 * 温度检测器
	 */
	public static final String DEV_TYPE_FROM_GW_TEMPERATURE = "D1";
	/**
	 * 湿度检测器
	 */
	public static final String DEV_TYPE_FROM_GW_HUMIDITY = "D2";
	/**
	 * 光强检测器
	 */
	public static final String DEV_TYPE_FROM_GW_LIGHT_INTENSITY = "D3";
	/**
	 * 噪音检测
	 */
	public static final String DEV_TYPE_FROM_GW_NOISE = "D4";
	
	/**
	 * E4--无线音乐盒--E
	 */
	public static final String DEV_TYPE_FROM_GW_MUSIC_BOX = "E4";
	/**
	 * a0--大金空调--E
	 */
	public static final String DEV_TYPE_FROM_GW_DAIKIN_AIR_CONDITIONING = "a0";
	/**
	 * a1--幕帘探测器--E
	 */
	public static final String DEV_TYPE_FROM_GW_CURTAIN_DETECTOR = "a1";
	/**
	 * f0--一键开关--E
	 */
	public static final String DEV_TYPE_FROM_GW_SWITCH_KEY_1 = "f0";
	/**
	 * f1--二键开关--E
	 */
	public static final String DEV_TYPE_FROM_GW_SWITCH_KEY_2 = "f1";
	/**
	 * O6--温控器--E
	 */
	public static final String DEV_TYPE_FROM_GW_THERMOSTAT_O6 = "O6";
	/**
	 * OK--电机--E
	 */
	public static final String DEV_TYPE_FROM_GW_ZHIHUANG_MOTOR = "OK";
	/**
	 * OK--梦想之花粉尘检测器--E
	 */
	public static final String DEV_TYPE_FROM_GW_DREAMFLOWER_PM2P5 = "D5";
	/**
	 * OK--梦想之花VOC--E
	 */
	public static final String DEV_TYPE_FROM_GW_DREAMFLOWER_VOC = "D6";
	
	/**
	 * OK--梦想之花炫彩灯
	 */
	public static final String DEV_TYPE_FROM_GW_DREAMFLOWER_LIGHT = "D7";
	
	/**
	 * OK--
	 */
	public static final String DEV_TYPE_FROM_GW_LIGHT_OB_4 = "OB";

	/** 传感器类别 end **/

	/** 服务器通信的参数 start **/
	public static final String[] SVR_HOST_ARR = new String[] {
			"chinaapp.wuliancloud.com", "aws.wuliancloud.com", "netprc.com" };
	// public static final String[] SSL_SVR_HOST_ARR = new String[] {
	// "wuliancloud.com" };
	// "wuliancloud.com", "netprc.com" 7002 smartbuilding.cn 1234 ,"netprc.com"
	public static final int SVR_PORT = 7002;
	public static final int SSL_SVR_PORT = 12002;
	public static final String MULTI_SVR_HOST = "224.0.0.1";
	public static final int MULTI_SVR_PORT_SEND = 7301;
	public static final String MULTI_SVR_HOST_2 = "239.255.255.250";
	public static final int MULTI_SVR_PORT_SEND_2 = 1900;
	public static final int MULTI_SVR_PORT_LSTN = 7302;
	public static final String USER_TYPE_ROOT = "0";
	public static final String USER_TYPE_USER = "1";
	/** 服务器通信的参数 end **/

	/** 服务器通信的命令 start **/
	// 心跳命令
	public static final String CMD_HEART = "00";
	// 设备连接命令-注册终端信息
	public static final String CMD_LOGIN = "01";
	// 设备连接命令-断开服务器
	public static final String CMD_DISCONNECT_MOB = "02";
	// 设备连接命令-连接网关
	public static final String CMD_CONNECT_GW = "03";
	// 设备连接命令-断开网关
	public static final String CMD_DISCONNECT_GW = "04";
	// 设备连接命令-修改网关密码
	public static final String CMD_CHANGE_GW_PWD = "05";
	// 基本功能命令-刷新设备列表
	public static final String CMD_LIST_DEV = "11";
	// 基本功能命令-控制设备
	public static final String CMD_CTRL_DEV = "12";
	// 基本功能命令-返回设备数据
	public static final String CMD_RETN_DATA = "13";
	// 基本功能命令-网关上线
	public static final String CMD_GW_UP = "14";
	// 基本功能命令-网关下线
	public static final String CMD_GW_DOWN = "15";
	// 基本功能命令-设备上线
	public static final String CMD_DEV_UP = "16";
	// 基本功能命令-设备下线
	public static final String CMD_DEV_DOWN = "17";
	// 基本功能命令-查询设备数据(周期/单次)
	public static final String CMD_PERIOD_DEV = "18";
	// 基本功能命令-控制场景
	public static final String CMD_CTRL_SCENE = "19";
	// 扩展功能命令-设置红外转发键码(批处理)
	public static final String CMD_SET_DEV_IR = "20";
	// 扩展功能命令-设置设备信息
	public static final String CMD_SET_DEV = "21";
	// 扩展功能命令-设置区域信息
	public static final String CMD_SET_ROOM = "22";
	// 扩展功能命令-设置场景信息
	public static final String CMD_SET_SCENE = "23";
	// 扩展功能命令-设置任务信息
	public static final String CMD_SET_TASK = "24";
	// 扩展功能命令-设置监控信息
	public static final String CMD_SET_MONITOR = "25";
	// 扩展功能命令-读取区域列表信息
	public static final String CMD_GET_ROOM = "26";
	// 扩展功能命令-读取场景列表信息
	public static final String CMD_GET_SCENE = "27";
	// 扩展功能命令-读取任务列表信息
	public static final String CMD_GET_TASK = "28";
	// 扩展功能命令-读取监控列表信息
	public static final String CMD_GET_MONITOR = "29";
	// 扩展功能命令-读取红外转发键码
	public static final String CMD_GET_DEV_IR = "30";
	// 扩展功能命令-设置定时场景列表信息
	public static final String CMD_SET_TIMER_SCENE = "31";
	// 扩展功能命令-读取定时场景列表信息
	public static final String CMD_GET_TIMER_SCENE = "32";
	// 扩展功能命令-定时场景执行通知
	public static final String CMD_REP_TIMER_SCENE = "33";
	// 34:请求和设置二路干接点按键配置
	public static final String CMD_SET_TWO_KEY_CONFIG = "34";
	// 35:读取断线设备列表
	public static final String CMD_READ_OFFLINE_DEVICE = "35";
	// 36:断线设备列表
	public static final String CMD_OFFLINE_DEIVCE_BACK = "36";
	// 37:增值功能命令-设置联动自动程序任务信息
	public static final String CMD_SET_AUTO_PROGRAM_TASK = "37";
	// 38:增值功能命令-查询自动程序任务信息
	public static final String CMD_GET_AUTO_PROGRAM_TASK = "38";
	// 请求与设置网关信息
	public static final String CMD_REQUEST_SET_GATEWAY_INFO = "41";
	// 设置"组合设备"绑定信息
	public static final String CMD_SET_COMBINATION_DEV = "48";
	// 读取"组合设备"绑定信息
	public static final String CMD_GET_COMBINATION_DEV = "49";
	// 控制设备组调节
	public static final String CMD_CONTROL_GROUP_DEV = "50";
	// 设备配置命令-设置场景开关绑定信息(批处理)
	public static final String CMD_SET_BIND_SCENE = "51";
	// 设备配置命令-读取场景开关绑定信息
	public static final String CMD_GET_BIND_SCENE = "52";
	// 设备配置命令-设置设备绑定信息(批处理)
	public static final String CMD_SET_BIND_DEV = "53";
	// 设备配置命令-读取设备绑定信息
	public static final String CMD_GET_BIND_DEV = "54";
	// 设备配置命令-读取设备关联信息
	public static final String CMD_QUERY_RELA_INFO = "55";
	// 设备配置命令-读取设备RSSI值
	public static final String CMD_QUERY_RSSI_INFO = "56";
	// 设备配置命令-返回设备硬件状态
	public static final String CMD_RETN_HARD_STUS = "57";
	// 设备配置命令-控制设备指示灯闪烁
	public static final String CMD_MAKE_DEV_BLINK = "58";
	// 设备配置命令-允许/禁止设备加入网络
	public static final String CMD_PERMIT_DEV_JOIN = "59";
	// 数据挖掘命令-读取报警数量
	public static final String CMD_GET_ALARM_NUM = "61";
	// 数据挖掘命令-读取设备数据
	public static final String CMD_GET_DEV_RECORD = "62";
	// 增值功能命令-群发社交信息
	public static final String CMD_USER_CHAT_ALL = "90";
	// 增值功能命令-指定对象发送社交信息
	public static final String CMD_USER_CHAT_SOME = "91";
	// 增值功能命令-接收社交信息
	public static final String CMD_USER_CHAT_MSG = "92";
	// 路由设置
	public static final String CMD_ROUTER_CONFIG = "401";
	// 梦想之花设置
	public static final String CMD_DREAM_FLOWER_CONFIG = "402";
	// 把接口24设置的任务信息迁移到37设置的程序
	public static final String CMD_MIGRATION_TASK  = "403";

	// // 扩展功能命令-注册用户
	// public static final String CMD_USER_REGISTER = "60";
	// // 扩展功能命令-用户登录
	// public static final String CMD_USER_LOGIN = "61";
	// // 扩展功能命令-所有角色信息
	// public static final String CMD_QUERY_ROLE_INFO = "62";
	// // 扩展功能命令-当前用户信息
	// public static final String CMD_QUERY_CURR_USER_INFO = "63";
	// // 扩展功能命令-当前网关下用户的角色信息
	// public static final String CMD_QUERY_GW_USER_ROLE_INFO = "64";
	// // 扩展功能命令-选择角色
	// public static final String CMD_ROLE_CHOOSE= "65";
	// // 扩展功能命令-用户退出
	// public static final String CMD_USER_LOGOUT = "66";
	// // 扩展功能命令-用户(自己)权限查看
	// public static final String CMD_PERM_SHOW_OWN = "67";
	// // 扩展功能命令-用户权限验证
	// public static final String CMD_PERM_CHECK = "68";
	// // 扩展功能命令-设置用户验证状态
	// public static final String CMD_SET_VERIFY_STATUS = "69";
	// // 扩展功能命令-用户(其他)权限查看
	// public static final String CMD_PERM_SHOW_OTHER = "70";
	// // 网络连接命令-终端上线
	// public static final String CMD_APNS_CLIENT_UP = "80";
	// // 网络连接命令-终端下线
	// public static final String CMD_APNS_CLIENT_DOWN = "81";
	// // 网络连接命令-推送消息
	// public static final String CMD_APNS_ALARM_MSG = "82";
	// // 网络连接命令-删除超时的终端
	// public static final String CMD_APNS_REMOVE_CLIENT = "83";
	// // 网络连接命令-设备下线推送消息
	// public static final String CMD_APNS_DEV_DOWN = "84";
	// // 网络连接命令-网关下线推送消息
	// public static final String CMD_APNS_GW_DOWN = "85";
	// // 网络连接命令-已建立服务器连接
	// public static final String CMD_CONNECT_SVR = "91";
	// // 网络连接命令-已断开服务器连接
	// public static final String CMD_DISCONNECT_SVR = "92";
	// // 网络连接命令-已登录服务器连接
	// public static final String CMD_LOGIN_SVR = "93";
	// // 网络连接命令-已登出服务器连接
	// public static final String CMD_LOGOUT_SVR = "94";
	// // 调试命令
	// public static final String CMD_DEBUG_INFO = "99";
	/** 服务器通信的命令 end **/

	/** 服务器通信的字段 start **/
	// 命令
	public static final String KEY_CMD = "cmd";
	// 类型
	public static final String KEY_TYPE = "type";
	// 名称
	public static final String KEY_NAME = "name";
	// 数据
	public static final String KEY_DATA = "data";
	// 状态
	public static final String KEY_STUS = "status";
	// 图标
	public static final String KEY_ICON = "icon";
	// 时间
	public static final String KEY_TIME = "time";
	// 模式
	public static final String KEY_MODE = "mode";

	// 设备的唯一标识
	public static final String KEY_IMEI_ID = "imeiId";
	// SIM卡的唯一标识
	public static final String KEY_IMSI_ID = "imsiId";
	// 网络类型
	public static final String KEY_NET_TYPE = "netType";
	// 网络运营商的国家代码
	public static final String KEY_NET_COUNTRY_ISO = "netCountryIso";
	// 网络运营商
	public static final String KEY_NET_OPERATOR = "netOperator";
	// 网络运营商名称
	public static final String KEY_NET_OPERATOR_NAME = "netOperatorName";
	// SIM卡序列号
	public static final String KEY_SIM_SERIAL_NO = "simSerialNo";
	// SIM卡运营商的国家代码
	public static final String KEY_SIM_COUNTRY_ISO = "simCountryIso";
	// SIM卡运营商
	public static final String KEY_SIM_OPERATOR = "simOperator";
	// SIM卡运营商名称
	public static final String KEY_SIM_OPERATOR_NAME = "simOperatorName";
	public static final String KEY_PHONE_TYPE = "phoneType";
	public static final String KEY_PHONE_OS = "phoneOS";
	// 第三方token
	public static final String KEY_SDK_TOKEN = "sdkToken";
	// 软件ID
	public static final String KEY_APP_ID = "appID";
	// 软件类型
	public static final String KEY_APP_TYPE = "appType";
	public static final String KEY_APP_VER = "appVer";
	// 用户类型
	public static final String KEY_USER_TYPE = "userType";
	// 网关ID
	public static final String KEY_GW_ID = "gwID";
	// 网关密码
	public static final String KEY_GW_PWD = "gwPwd";
	// 用户ID
	public static final String KEY_USER_ID = "userID";
	// 用户密码
	public static final String KEY_USER_PWD = "userPwd";
	// 网关IP
	public static final String KEY_GW_IP = "gwIP";
	// 网关所在服务端IP
	public static final String KEY_GW_SER_IP = "gwSerIP";

	public static final String KEY_GW_VERSION = "gwVer";
	public static final String KEY_GW_NAME = "gwName";
	public static final String KEY_GW_LOCATION = "gwLocation";
	public static final String KEY_GW_PATH = "gwPath";
	public static final String KEY_GW_CHANNEL = "gwChannel";
	// 时区
	public static final String KEY_ZONE_ID = "zoneID";
	// 发送者
	public static final String KEY_FROM = "from";
	// 接收者
	public static final String KEY_TO = "to";
	// 别名
	public static final String KEY_ALIAS = "alias";

	// 设备ID
	public static final String KEY_DEV_ID = "devID";
	// 设备分类
	public static final String KEY_DEV_CAT = "category";
	// 设备属性组
	public static final String KEY_DEV_CLST = "clst";
	// 设备属性
	public static final String KEY_DEV_ATTR = "attr";
	// 设备端口
	public static final String KEY_EP = "ep";
	// 设备端口类型
	public static final String KEY_EP_TYPE = "epType";
	// 设备端口名称
	public static final String KEY_EP_NAME = "epName";
	// 设备端口状态
	public static final String KEY_EP_STUS = "epStatus";
	// 设备端口数据
	public static final String KEY_EP_DATA = "epData";
	// 设备端口属性组
	public static final String KEY_EP_CLST = "epClst";
	// 设备端口属性
	public static final String KEY_EP_ATTR = "epAttr";

	// 监控ID
	public static final String KEY_MONITOR_ID = "monitorID";
	// 主页地址
	public static final String KEY_HOST = "host";
	// 主页端口
	public static final String KEY_PORT = "port";
	// 用户名
	public static final String KEY_USER = "user";
	// 密码
	public static final String KEY_PWD = "pwd";
	// 数据流
	public static final String KEY_STREAM = "stream";

	// 场景ID
	public static final String KEY_SCENE_ID = "sceneID";
	// 任务类型
	public static final String KEY_TASK_MODE = "taskMode";
	// 任务多联动
	public static final String KEY_TASK_MUTILLINKAGE = "mutilLinkage";
	// 操作类型
	public static final String KEY_CONTENT_ID = "contentID";
	// 是否启用
	public static final String KEY_AVAILABLE = "available";
	// 传感器ID
	public static final String KEY_SENSOR_ID = "sensorID";
	// 传感器端口
	public static final String KEY_SENSOR_EP = "sensorEp";
	// 传感器类型
	public static final String KEY_SENSOR_TYPE = "sensorType";
	// 传感器名称
	public static final String KEY_SENSOR_NAME = "sensorName";
	// 传感器条件
	public static final String KEY_SENSOR_COND = "sensorCond";
	// 传感器数据
	public static final String KEY_SENSOR_DATA = "sensorData";
	// 操作延时时间
	public static final String KEY_DELAY = "delay";
	// 是否发送传感器数据
	public static final String KEY_FORWARD = "forward";
	// 定时周期
	public static final String KEY_WEEKDAY = "weekday";
	// 版本号
	public static final String KEY_VERSION = "version";
	// 分组ID
	public static final String KEY_GROUP_ID = "groupID";
	// 分组名称
	public static final String KEY_GROUP_NAME = "groupName";
	public static final String KEY_GROUP = "group";

	// 绑定的设备ID
	public static final String KEY_BIND_DEV_ID = "bindDevID";
	// 梦想之花设备
	public static final String KEY_DREAM_FLOWER_DEVICE = "dreamflower";
	// 绑定的设备ep
	public static final String KEY_BIND_EP = "bindEp";
	// 绑定的设备数据
	public static final String KEY_BIND_DATA = "bindData";

	// 区域ID
	public static final String KEY_ROOM_ID = "roomID";
	// 网关区域ID
	public static final String KEY_GW_ROOM_ID = "gwRoomID";
	// 红外按键码
	public static final String KEY_KEYSET = "keyset";
	// 红外类型
	public static final String KEY_IR_TYPE = "irType";
	// 红外控制码
	public static final String KEY_CODE = "code";

	// 开始时间
	public static final String KEY_START_TIME = "startTime";
	// 结束时间
	public static final String KEY_END_TIME = "endTime";
	// 总数
	public static final String KEY_COUNT = "count";
	// 组合设备左
	public static final String KEY_COMBIND_DEV_LEFT = "bindDevID1";
	// 组合设备右
	public static final String KEY_COMBIND_DEV_RIGHT = "bindDevID2";
	public static final String KEY_COMBIND_BIND_ID = "bindID";
	/** 服务器通信的字段 end **/

	// 操作类型，C：新增 R:查询 U:修改 D:删除
	public static final String KEY_OPERATION_TYPE = "operType";
	// 自动程序ID
	public static final String KEY_PROGRAM_ID = "programID";
	// 程序的名字
	public static final String KEY_PROGRAM_NAME = "programName";
	// 程序的详细说明
	public static final String KEY_PROGRAM_DESC = "programDesc";
	// 规则生效状态
	public static final String KEY_PROGRAM_STATUS = "status";
	// 自动程序类型
	public static final String KEY_PROGRAM_TYPE = "programType";
	// 触发器数组
	public static final String KEY_TRIGGER_ARRAY = "triggerArray";
	// 触发器类型
	public static final String KEY_TRIGGER_TYPE = "type";
	// 触发器源对象
	public static final String KEY_TRIGGER_OBJECT = "object";
	// 触发器表达式
	public static final String KEY_TRIGGER_EXP = "exp";
	// 前提条件
	public static final String KEY_CONDITION_ARRAY = "conditionArray";
	// 前提条件表达式
	public static final String KEY_CONDITION_EXP = "exp";
	// 执行的任务列表
	public static final String KEY_ACTION_ARRAY = "actionArray";
	// 执行任务的顺序
	public static final String KEY_ACTION_SORTNUM = "sortNum";
	// 执行对象的类型
	public static final String KEY_ACTION_TYPE = "type";
	// 执行任务的对象
	public static final String KEY_ACTION_OBJECT = "object";
	// 执行任务的数据
	public static final String KEY_ACTION_EPDATA = "epData";
	// 执行任务的数据
	public static final String KEY_ACTION_DESCRIPTION = "description";
	// 执行任务的数据
	public static final String KEY_ACTION_DELAY = "delay";
	// 所有的自动程序任务列表
	public static final String KEY_RULE_ARRAY = "ruleArray";
	// 梦想之花
	public static final String KEY_CMD_INDEX = "cmdindex";
	public static final String KEY_CMD_TYPE = "cmdtype";
	public static final String KEY_CMD_TYPE_GET = "get";
	public static final String KEY_CMD_TYPE_SET = "set";

}
