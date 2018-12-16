package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhelper.Database;

/**
 * Servlet implementation class displayRetailer
 */
@WebServlet("/displayRetailer")
public class displayRetailer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayRetailer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		request.getSession(false).setAttribute("remail", email);
		Database db = new Database("myproject","root","icefire");
		int x[] = db.buyFruits(email);
		String s[]={"Banana","Apple","WaterMelon","Orange","Papaya","PineApple","Mango","Pomegranate","Guava"};
		
		String ans="<table class=\"table\"><tr><td>Fruit</td><td>Price</td><td>AddQuantity</td><td>RemoveQuantity</td><td>Added quantity</td></tr>";
		for(int i=0;i<17;i+=2){
			ans+= "<tr><td>" + s[i/2] + "</td>";
			ans+="<td><div class=\"form-group\"><input type=\"text\" style=\"width:50px;\" class=\"form-control\" id=\"fp" + Integer.toString(i/2+1) + "\" name=\"fp " + Integer.toString(i/2+1) + "\" readonly=\"readonly\" value=\"" + Integer.toString(x[i]) + "\"></div></td>";
			//ans+= "<td>" + x[i] + "</td>";
			ans+= "<td><select class=\"form-control\" id=\"f" + Integer.toString(i/2+1) + "\">";
			ans+="<option value=\"0\" selected=\"selected\">0</option>";
			for(int j=1;j<=x[i+1];j++){
				ans+="<option value=\""+ j + "\">" + j + "</option>";
			}
			ans+="</select><button type=\"button\" class=\"btn btn-default\" aria-label=\"Left Align\" id=\"add" + Integer.toString(i/2+1) + "\"><span class=\"glyphicon glyphicon-arrow-right\" aria-hidden=\"true\"></span></button></td>";
			ans+="<td><select class=\"form-control\" id=\"F"+ Integer.toString(i/2+1) + "\"><option value=\"0\" selected=\"selected\">0</option></select>";
			ans+="<button type=\"button\" class=\"btn btn-default\" aria-label=\"Left Align\" id=\"remove" + Integer.toString(i/2+1) + "\"><span class=\"glyphicon glyphicon-arrow-left\" aria-hidden=\"true\"></span></button></td>";
			ans+="<td><div class=\"form-group\"><input type=\"text\" class=\"form-control\" id=\"addedquantity" + Integer.toString(i/2+1) + "\" name=\"addedquantity" + Integer.toString(i/2+1) + "\" readonly=\"readonly\" value=\"0\"></div></td></tr>";
		}
		ans+="</table>";
		request.setAttribute("ans", ans);
		String rname = db.getName(email,(String)request.getSession(false).getAttribute("type"));
		request.getSession(false).setAttribute("rname", rname);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayRetailer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
