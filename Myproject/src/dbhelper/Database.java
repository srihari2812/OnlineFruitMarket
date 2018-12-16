package dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import model.RetailerShopper;
import model.Transaction;
public class Database {
	Connection con;
	ResultSet rs;
	public Database(String dname, String uname, String pass){
		String url="jdbc:mysql://localhost:3306/" + dname;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.con = DriverManager.getConnection(url, uname, pass);
			this.con.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(){
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public RetailerShopper validate(String type, String email, String pass){
		RetailerShopper obj=new RetailerShopper();
		String query="select * from " + type + " where email='" + email + "' and password='" + pass + "';";
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			this.rs=ps.executeQuery();
			if(rs.next()){
				obj.setEmail(rs.getString(1));
				obj.setPassword(rs.getString(2));
				obj.setFname(rs.getString(3));
				obj.setLname(rs.getString(4));
				obj.setAddress(rs.getString(5));
				obj.setPan(rs.getString(6));
				obj.setWallet(rs.getInt(7));
				if(type.equals("retailers")){
					obj.setScount(rs.getInt(8));
					obj.setRetailer(true);
				}
				else{
					obj.setScount(0);
					obj.setRetailer(false);
				}
				//return obj;
			}
			else{
				//return null;
				obj=null;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			obj = null;
		}
		finally{
			return obj;
		}
	}
	public boolean insertData(RetailerShopper obj){
		String table;boolean ans=true;
		if(obj.isRetailer())
			table="retailers";
		else
			table="shoppers";
		String query = "insert into " + table + " values(\"" + obj.getEmail() + "\",\"" + obj.getPassword() + "\",\"" + obj.getFname() + "\",\"" + obj.getLname() + "\",\"" + obj.getAddress() + "\",\"" + obj.getPan() + "\","  + Integer.toString(obj.getWallet());
		if(obj.isRetailer())
			query = query + ",0);";
		else
			query= query + ");";
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			int result=ps.executeUpdate();
			if(result == -1){
				ans=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ans=false;
		}
		catch(Exception e){
			e.printStackTrace();
			ans=false;
		}
		finally{
				try {
					if(ans==false)
						this.con.rollback();
					else
						this.con.commit();
					return ans;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return ans;
				}
		}
	}
	
	public boolean newRetailer(String email){
		String query = "select * from stores where email=\"" + email + "\";";
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			rs = ps.executeQuery();
			if(!rs.next())
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public String getName(String email, String type){
		String query = "select fname,lname from " + type + " where email=\"" + email + "\";";
		String name="";
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				name+=rs.getString("fname") + " " + rs.getString("lname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return name;
		}
	}
	
	public boolean insertStore(Map<String,String> store,Map<String,int[]> fruits){
		String query1="insert into stores values(\"" + store.get("email") + "\",\"" + store.get("sname") + "\",\"" + store.get("description") + "\",\"" + store.get("location") + "\");";
		String query2="insert into fruits values(\"" + store.get("email") + "\"," + fruits.get("banana")[0] + "," + fruits.get("banana")[1] + "," + fruits.get("apple")[0] + "," + fruits.get("apple")[1] + "," + fruits.get("melon")[0] + "," + fruits.get("melon")[1] + "," + fruits.get("orange")[0] + "," + fruits.get("orange")[1] + "," + fruits.get("papaya")[0] + "," + fruits.get("papaya")[1] + "," + fruits.get("papple")[0] + "," + fruits.get("papple")[1] + "," + fruits.get("mango")[0] + "," + fruits.get("mango")[1] + "," + fruits.get("granate")[0] + "," + fruits.get("granate")[1] + "," + fruits.get("guava")[0] + "," + fruits.get("guava")[1] + ");";
		boolean flag=true;
		try {
			PreparedStatement ps = this.con.prepareStatement(query1);
			int result=ps.executeUpdate();
			if(result == -1){
				flag=false;
			}
			ps= this.con.prepareStatement(query2);
			result=ps.executeUpdate();
			if(result == -1){
				flag = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		finally{
			try {
				if(flag==false)
					this.con.rollback();
				else
					this.con.commit();
				return flag;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return flag;
			}
	}
	}
	
	public String getFruitsTable(String email){
		String table="";
		String query="select * from fruits where email=\"" + email + "\";";
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			this.rs=ps.executeQuery();
			while(rs.next()){
				table+="<table class=\"table\"><tr><td>Name</td><td>Price</td><td>Quantity</td></tr>";
				table+="<tr><td>Banana</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td></tr>";
				table+="<tr><td>Apple</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td></tr>";
				table+="<tr><td>Water Melon</td><td>" + rs.getString(6) + "</td><td>" + rs.getString(7) + "</td></tr>";
				table+="<tr><td>Orange</td><td>" + rs.getString(8) + "</td><td>" + rs.getString(9) + "</td></tr>";
				table+="<tr><td>Papaya</td><td>" + rs.getString(10) + "</td><td>" + rs.getString(11) + "</td></tr>";
				table+="<tr><td>Pine Apple</td><td>" + rs.getString(12) + "</td><td>" + rs.getString(13) + "</td></tr>";
				table+="<tr><td>Mango</td><td>" + rs.getString(14) + "</td><td>" + rs.getString(15) + "</td></tr>";
				table+="<tr><td>Pomegranate</td><td>" + rs.getString(16) + "</td><td>" + rs.getString(17) + "</td></tr>";
				table+="<tr><td>Guava</td><td>" + rs.getString(18) + "</td><td>" + rs.getString(19) + "</td></tr></table>";
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}
	public String getWallet(String email, String type){
		String wallet=" $";
		String query = "select wallet from " + type +" where email=\"" + email +"\";";
		PreparedStatement ps;
		try {
			ps = this.con.prepareStatement(query);
			this.rs=ps.executeQuery();
			while(rs.next()){
				wallet = rs.getString("wallet") + wallet;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wallet;
	}
	public boolean updateFruits(int a[],String email){
		String query="";
		String s[]={"banana_price","banana_quantity","apple_price","apple_quantity","watermelon_price","watermelon_quantity","orange_price","orange_quantity","papaya_price","papaya_quantity","pineapple_price","pineapple_quantity","mango_price","mango_quantity","pomegranate_price","pomegranate_quantity","guava_price","guava_quantity"};
		PreparedStatement ps;
		try {
			for(int i=0;i<18;i++){
				if(a[i]!=-1){
					query="update fruits set " + s[i] + "=" + a[i] + " where email=\"" + email +"\";";
					ps = this.con.prepareStatement(query);
					ps.executeUpdate();
				}
			}
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}
	public String getTransactions(String email, String date){
		String query2="select * from transaction where remail=\"" + email + "\" and date = \"" + date + "\";";
		PreparedStatement ps;
		String ans="";int flag=0;
		try {
			String sname="";
			ans="<table class=\"table\"><tr><td>Email</td><td>ShopperName</td><td>Date</td><td>Description</td><td>Amount</td></tr>";
			ps = this.con.prepareStatement(query2);
			this.rs=ps.executeQuery();	
			while(rs.next()){
				flag=1;
				System.out.println("inside");
				String query1 = "select fname,lname from shoppers where email = \"" + rs.getString("semail") + "\";";
				ps = this.con.prepareStatement("query1");
				ResultSet temp_rs = ps.executeQuery(query1);
				while(temp_rs.next())
					sname = temp_rs.getString("fname") + " " + temp_rs.getString("lname");
				System.out.println(sname);
				ans += "<tr><td>" + rs.getString("semail") + "</td><td>" + sname + "</td><td>" + rs.getString("date") + "</td><td>" + rs.getString("description") + "</td><td>" + rs.getInt("amount") + "</td></tr>";
			}
			ans+="</table>";
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(flag==0)
				return "";
			return ans;
		}
	}
	
	public String getLoyalShoppers(String email, String thold){
		String query2="select a.semail as semail from (select * from transaction where remail= '" + email + "') as a group by a.semail having count(a.semail) > " + thold + ";";
		PreparedStatement ps;
		String ans="";int flag=0;
		try {
			String sname="";
			ans="<table class=\"table\"><tr><td>Email</td><td>ShopperName</td></tr>";
			ps = this.con.prepareStatement(query2);
			this.rs=ps.executeQuery();	
			while(rs.next()){
				flag=1;
				System.out.println("inside");
				String query1 = "select fname,lname from shoppers where email = \"" + rs.getString("semail") + "\";";
				ps = this.con.prepareStatement("query1");
				ResultSet temp_rs = ps.executeQuery(query1);
				while(temp_rs.next())
					sname = temp_rs.getString("fname") + " " + temp_rs.getString("lname");
				System.out.println(sname);
				ans += "<tr><td>" + rs.getString("semail") + "</td><td>" + sname + "</td></tr>";
			}
			ans+="</table>";
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(flag==0)
				return "";
			return ans;
		}
	}
	
	public String getAllShoppers(String email){
		String query2="select a.semail as semail,count(a.semail) as count from (select * from transaction where remail=\"" + email +"\")as a group by a.semail;";
		PreparedStatement ps;
		String ans="";int flag=0;
		try {
			String sname="";
			ans="<table class=\"table\"><tr><td>Email</td><td>ShopperName</td><td>count</td></tr>";
			ps = this.con.prepareStatement(query2);
			this.rs=ps.executeQuery();	
			while(rs.next()){
				flag=1;
				System.out.println("inside");
				String query1 = "select fname,lname from shoppers where email = \"" + rs.getString("semail") + "\";";
				ps = this.con.prepareStatement("query1");
				ResultSet temp_rs = ps.executeQuery(query1);
				while(temp_rs.next())
					sname = temp_rs.getString("fname") + " " + temp_rs.getString("lname");
				System.out.println(sname);
				ans += "<tr><td>" + rs.getString("semail") + "</td><td>" + sname + "</td><td>" + rs.getString("count") + "</td></tr>";
			}
			ans+="</table>";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(flag==0)
				return "";
			return ans;
		}
	}
	
	public String getRetailersTable(String email){
		String table="<form action=\"displayRetailer\" method=\"get\"><table id=\"ret\" class=\"table\"><tr><td>Email</td><td>StoreName</td><td>Description</td><td>Location</td></tr>";
		//String table = "";
		//String query="select * from stores;";
		String query="select * from stores where email not in(select remail from transaction where semail=\"" + email + "\" and date = CURDATE())";
		try {
			PreparedStatement ps=this.con.prepareStatement(query);
			this.rs=ps.executeQuery();
			while(rs.next()){
				table+="<tr><td><input type=\"submit\" class=\"btn btn-primary btn-sm\" name= \"email\" value=\"" + rs.getString("email") + "\"/></td>";
				table+="<td>" + rs.getString("name") + "</td>";
				table+="<td>" + rs.getString("description") + "</td>";
				table+="<td>" + rs.getString("location") + "</td></tr>";
			}
			table+="</table>";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}
	public int[] buyFruits(String email){
		String query="select * from fruits where email=\"" + email + "\";";
		String s[]={"banana_price","banana_quantity","apple_price","apple_quantity","watermelon_price","watermelon_quantity","orange_price","orange_quantity","papaya_price","papaya_quantity","pineapple_price","pineapple_quantity","mango_price","mango_quantity","pomegranate_price","pomegranate_quantity","guava_price","guava_quantity"};
		int x[] = new int[18];
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			this.rs=ps.executeQuery();
			while(rs.next()){
				for(int i=0;i<18;i++)
					x[i]=rs.getInt(s[i]);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	public boolean updatewallets(String fn[],int fq[],String remail, String semail,int price){
		String des="'" + fn[0] + ":" + Integer.toString(fq[0]) + ", " + fn[1] + ":" + Integer.toString(fq[1]) + ", " + fn[2] + ":" + Integer.toString(fq[2]) + "'";
		String query1="update shoppers set wallet=wallet-" + Integer.toString(price) + " where email=\"" + semail + "\";";
		String query2="update retailers set wallet=wallet+" + Integer.toString(price) + ",scount=scount+1 where email=\"" + remail + "\";";
		String query3="update fruits set " + fn[0] + "_quantity=" + fn[0] + "_quantity-" + Integer.toString(fq[0]) + "," +  fn[1] + "_quantity=" + fn[1] + "_quantity-" + Integer.toString(fq[1]) + "," + fn[2] + "_quantity=" + fn[2] + "_quantity-" + Integer.toString(fq[2]) + " where email=\"" + remail + "\";";
		String query4="insert into transaction values(\"" + remail + "\",\"" + semail + "\"," + Integer.toString(price) + ",CURDATE()," + des + ");" ;
		boolean flag=true;
		try {
			PreparedStatement ps = this.con.prepareStatement(query1);
			ps.executeUpdate();
			ps=this.con.prepareStatement(query2);
			ps.executeUpdate();
			ps=this.con.prepareStatement(query3);
			ps.executeUpdate();
			ps=this.con.prepareStatement(query4);
			ps.executeUpdate();
			flag=true;
			this.con.commit();
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			flag=false;
		}
		finally{
			return flag;
		}
		
	}
}