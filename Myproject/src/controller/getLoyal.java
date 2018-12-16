package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhelper.Database;

/**
 * Servlet implementation class getLoyal
 */
@WebServlet("/getLoyal")
public class getLoyal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String thold = request.getParameter("thold");
		Database db = new Database("myproject","root","icefire");
		String ans="";
		ans = db.getLoyalShoppers((String)request.getSession(false).getAttribute("email"),thold);
		if(ans.equals(""))
			ans="<label id=\"msg2\">No Loyal Shoppers for threshold " + thold + "</label>";
		response.setContentType("text/plain");
		response.getWriter().write(ans);
	}

}
