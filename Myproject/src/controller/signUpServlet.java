package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbhelper.Database;
import model.RetailerShopper;
/**
 * Servlet implementation class signUpServlet
 */
@WebServlet("/signUpServlet")
public class signUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url="";
		try{
			HttpSession session = request.getSession(false);
			String type=(String)session.getAttribute("type");
			String email,password,fname,lname,address,pan;
			boolean isRetailer;
			int wallet;
			email=request.getParameter("email");
			password=request.getParameter("password");
			fname=request.getParameter("fname");
			lname=request.getParameter("lname");
			address=request.getParameter("address");
			pan=request.getParameter("pan");
			wallet=Integer.parseInt(request.getParameter("wallet"));
			if(type.equals("retailers"))
				isRetailer=true;
			else
				isRetailer=false;
			RetailerShopper obj = new RetailerShopper(email,password,fname,lname,address,pan,wallet,isRetailer);
			Database db = new Database("myproject","root","icefire");
			if(db.insertData(obj)){
				session.setAttribute("email", email);
				session.setAttribute("name", fname);
				session.setAttribute("wallet",wallet);
				request.setAttribute("failure", "");
				if(type.equals("retailers"))
					url="/createStore.jsp";
				else
					url="/shoppersHome.jsp";
			}
			else{
				url="/signUp.jsp";
				request.getSession().setAttribute("failure2", "Use unique values!!");
			}
			db.close();
		}
		catch(Exception e){
			e.printStackTrace();
			url="/signUp.jsp";
			request.getSession().setAttribute("failure2", "Use unique values!!");
		}
		finally{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
