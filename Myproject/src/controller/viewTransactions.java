package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

import dbhelper.Database;
import model.Transaction;

/**
 * Servlet implementation class viewTransactions
 */
@WebServlet("/viewTransactions")
public class viewTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewTransactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String date = request.getParameter("date");
		Database db = new Database("myproject","root","icefire");
		String ans="";		ans = db.getTransactions((String)request.getSession(false).getAttribute("email"),date);
		if(ans.equals(""))
			ans="<label id=\"msg2\">No Transactions on " + date + "</label>";
		response.setContentType("text/plain");
		response.getWriter().write(ans);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
