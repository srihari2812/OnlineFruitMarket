package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import dbhelper.Database;
/**
 * Servlet implementation class createStoreServlet
 */
@WebServlet("/createStoreServlet")
public class createStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createStoreServlet() {
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
			Map<String,String> store = new HashMap<String,String>();
			Map<String,int[]> fruits = new HashMap<String,int[]>();
			HttpSession session = request.getSession(false);
			store.put("email", (String)session.getAttribute("email"));
			store.put("sname",request.getParameter("sname"));
			store.put("description",request.getParameter("description"));
			store.put("location",request.getParameter("location"));
			fruits.put("banana", new int[]{Integer.parseInt(request.getParameter("p_banana")),Integer.parseInt(request.getParameter("q_banana"))});
			fruits.put("apple", new int[]{Integer.parseInt(request.getParameter("p_apple")),Integer.parseInt(request.getParameter("q_apple"))});
			fruits.put("mango", new int[]{Integer.parseInt(request.getParameter("p_mango")),Integer.parseInt(request.getParameter("q_mango"))});
			fruits.put("orange", new int[]{Integer.parseInt(request.getParameter("p_orange")),Integer.parseInt(request.getParameter("q_orange"))});
			fruits.put("melon", new int[]{Integer.parseInt(request.getParameter("p_melon")),Integer.parseInt(request.getParameter("q_melon"))});
			fruits.put("papple", new int[]{Integer.parseInt(request.getParameter("p_papple")),Integer.parseInt(request.getParameter("q_papple"))});
			fruits.put("granate", new int[]{Integer.parseInt(request.getParameter("p_granate")),Integer.parseInt(request.getParameter("q_granate"))});
			fruits.put("guava", new int[]{Integer.parseInt(request.getParameter("p_guava")),Integer.parseInt(request.getParameter("q_guava"))});
			fruits.put("papaya", new int[]{Integer.parseInt(request.getParameter("p_papaya")),Integer.parseInt(request.getParameter("q_papaya"))});
			Database db = new Database("myproject","root","icefire");
			if(db.insertStore(store, fruits)){
				url="/retailersHome.jsp";
				request.getSession(false).setAttribute("fail","");
			}
			else{
				url="/createStore.jsp";
			}
			db.close();
		}
		catch(Exception e){
			e.printStackTrace();
			url="/createStore.jsp";
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
