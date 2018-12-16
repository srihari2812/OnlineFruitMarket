package model;

public class RetailerShopper {
	String email,password,fname,lname,address,pan;
	boolean isRetailer;
	int wallet,scount=0;
	public RetailerShopper(String email, String password, String fname, String lname, String address, String pan, int wallet, boolean isRetailer) {
		super();
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.pan = pan;
		this.wallet = wallet;
		this.isRetailer = isRetailer;
	}
	public RetailerShopper() {
		// TODO Auto-generated constructor stub
		this.email = null;
		this.password = null;
		this.fname = null;
		this.lname = null;
		this.address = null;
		this.pan = null;
		this.wallet = 0;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getAddress() {
		return address;
	}
	public String getPan() {
		return pan;
	}
	public int getWallet() {
		return wallet;
	}
	public int getScount() {
		return scount;
	}
	public boolean isRetailer() {
		return isRetailer;
	}
	public void setScount(int scount){
		this.scount=scount;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public void setRetailer(boolean isRetailer) {
		this.isRetailer = isRetailer;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
}
