package model;

public class Transaction {
	
	String remail,semail,sname,date,description;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	int amount;
	public Transaction(String remail, String semail, String sname, String date, String description, int amount) {
		super();
		this.remail = remail;
		this.semail = semail;
		this.sname  = sname;
		this.date = date;
		this.description = description;
		this.amount = amount;
	}
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
