package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhelper.Database;

/**
 * Servlet implementation class allShoppers
 */
@WebServlet("/allShoppers")
public class allShoppers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Database db = new Database("myproject","root","icefire");
		String ans="";
		ans = db.getAllShoppers((String)request.getSession(false).getAttribute("email"));
		if(ans.equals(""))
			ans="<label id=\"msg2\">No Shoppers </label>";
		request.setAttribute("ans", ans);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allShoppers.jsp");
		dispatcher.forward(request, response);
	}

}
