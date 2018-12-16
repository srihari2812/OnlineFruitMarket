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
 * Servlet implementation class updateFruits
 */
@WebServlet("/updateFruits")
public class updateFruits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateFruits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			int a[] = new int[18];
			String s[] = {"p_banana","q_banana","p_apple","q_apple","p_melon","q_melon","p_orange","q_orange","p_papaya","q_papaya","p_papple","q_papple","p_mango","q_mango","p_granate","q_granate","p_guava","q_guava"};
			for(int i=0;i<18;i++){
				if(!request.getParameter(s[i]).isEmpty())
					a[i]=Integer.parseInt(request.getParameter(s[i]));
				else
					a[i]=-1;
			}
			Database db = new Database("myproject","root","icefire");
			if(db.updateFruits(a,(String)request.getSession(false).getAttribute("email")))
				request.setAttribute("fail","Please enter valid values");
			else
				request.setAttribute("fail","");
			db.close();
		}
		catch(Exception e){
			e.printStackTrace();
			request.setAttribute("fail","Please enter valid values");
		}
		finally{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/retailersHome.jsp");
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
