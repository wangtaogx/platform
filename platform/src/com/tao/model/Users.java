package com.tao.model;

import java.io.Serializable;

import org.joda.time.DateTime;


/** 
  * @ClassName: User
  * @Description: 用户实体类
  * @date 2011-9-26 上午10:03:54 
  *  
  */
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long       id;
	private String     username;
	private String     password;
	private String     phone;
	private String     email;
	private DateTime   lastLogoffDate;
	private DateTime   lastLogonDate;
	private String     lastLogonIp;
	private Integer    status;
	private String     name;
	private String     enname;
	private String     userType;
	private DateTime   employedDate;
	private String     position;
	private String     age;          
	private DateTime   birthday;
	private String     nativePlace;
	private String     address; 
	private String     education;
	private String     marriage;
	private String     remark;
	private DateTime   registerDate;
	private String     sex;       
	private String     employNo;
	public Users()
	{
		
	}
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public DateTime getLastLogoffDate() {
		return lastLogoffDate;
	}
	public void setLastLogoffDate(DateTime lastLogoffDate) {
		this.lastLogoffDate = lastLogoffDate;
	}
	public DateTime getLastLogonDate() {
		return lastLogonDate;
	}
	public void setLastLogonDate(DateTime lastLogonDate) {
		this.lastLogonDate = lastLogonDate;
	}
	public String getLastLogonIp() {
		return lastLogonIp;
	}
	public void setLastLogonIp(String lastLogonIp) {
		this.lastLogonIp = lastLogonIp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnname() {
		return enname;
	}
	public void setEnname(String enname) {
		this.enname = enname;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public DateTime getEmployedDate() {
		return employedDate;
	}
	public void setEmployedDate(DateTime employedDate) {
		this.employedDate = employedDate;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public DateTime getBirthday() {
		return birthday;
	}
	public void setBirthday(DateTime birthday) {
		this.birthday = birthday;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public DateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(DateTime registerDate) {
		this.registerDate = registerDate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmployNo() {
		return employNo;
	}
	public void setEmployNo(String employNo) {
		this.employNo = employNo;
	}
}
