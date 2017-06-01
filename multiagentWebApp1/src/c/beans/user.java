package c.beans;

public class user {
	
	private int userID;
	private String name;
	private String email;
	private String password;
	private String phone;
	private String adminOrUser;
	
	public int getuserID() {
		return userID;
	}
	public void setuserID(int userID) {
		this.userID = userID;
	}
	
	public String getname() {
	       return name;
	}
	public void setname(String name) {
	       this.name = name;
	}
	
	public String getemail() {
	       return email;
	}
	public void setemail(String email) {
	       this.email = email;
	}
	
	public String getpassword() {
	       return password;
	}
	public void setpassword(String password) {
	       this.password = password;
	}
	
	public String getphone() {
	       return phone;
	}
	public void setphone(String phone) {
	       this.phone = phone;
	}
		
	public String getadminOrUser(){
		return adminOrUser;
	}
	public void setadminOrUser(String adminOrUser2){
		this.adminOrUser = adminOrUser2;
	}

}
