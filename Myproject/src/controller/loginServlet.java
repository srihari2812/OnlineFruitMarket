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
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email=request.getParameter("email");
		String pass = request.getParameter("password");
		String url;
		HttpSession session = request.getSession(false);
		String  type=(String) session.getAttribute("type");
		Database db = new Database("myproject","root","icefire");
		RetailerShopper obj = new RetailerShopper();
		obj=db.validate(type, email, pass);
		if(obj != null){
			session.setAttribute("email",obj.getEmail());
			session.setAttribute("name",obj.getFname());
			session.setAttribute("wallet", obj.getWallet());
			request.setAttribute("failure", "");
			if(type.equals("retailers")){
				if(db.newRetailer(email))
					url="/createStore.jsp";
				else{
					url="/retailersHome.jsp";
					request.getSession(false).setAttribute("fail","");
				}
			}
			else
				url="/shoppersHome.jsp";
		}
		else{
			request.setAttribute("failure", "Incorrect email or password");
			url="/login.jsp";
		}
		db.close();
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
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
