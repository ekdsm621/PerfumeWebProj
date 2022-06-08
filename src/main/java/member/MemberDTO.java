package member;

import java.sql.Date;

public class MemberDTO {
	private int code;
	private String id;
	private String pw;
	private String name;
	private String birth;	
	private String gender;
	private String phone;
	private int phone_agree;
	private String email;
	private int email_agree;
	private String post;
	private String address;
	private int grade;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPhone_agree() {
		return phone_agree;
	}
	public void setPhone_agree(int phone_agree) {
		this.phone_agree = phone_agree;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmail_agree() {
		return email_agree;
	}
	public void setEmail_agree(int email_agree) {
		this.email_agree = email_agree;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
