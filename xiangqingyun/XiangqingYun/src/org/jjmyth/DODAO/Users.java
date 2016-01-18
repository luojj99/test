package org.jjmyth.DODAO;

import java.util.Date;

public class Users {
	 private Integer id;
	private String name;
	transient private String password;
	private String nickName;
	private Integer age;
	private String sex;
	private String city;
	private Float height;
	private Date birthday;
	private String pic;
	private String token;
	private int isFistLogin;
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getStudentId() {
		return id;
	}
	public void setStudentId(Integer studentId) {
		this.id = studentId;
	}
	
	
	public Users(String name, String password, String sex, String pic,
			Integer studentId) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.pic = pic;
		this.id = studentId;
	}
	public Users() {
		super();
	}
	
	public String toJSONString() {
		return "{\"name\":\""  +   name           +"\","+
		"\"sex\":\""          +   sex            +"\","+
		"\"pic\":\""          +   pic            +"\","+
		"\"id\":"          +    id      +"}";
	}
	
	
	public String toJSONStringHaveToken() {
		return "{\"name\":\""  +   name           +"\","+
		"\"token\":\""          +   token         +"\","+
		"\"sex\":\""          +   sex            +"\","+
		"\"pic\":\""          +   pic            +"\","+
		"\"id\":"          +    id      +"}";
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getIsFistLogin() {
		return isFistLogin;
	}
	public void setIsFistLogin(int isFistLogin) {
		this.isFistLogin = isFistLogin;
	}
	
	
	
}
