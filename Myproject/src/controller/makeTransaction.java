package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class makeTransaction
 */
@WebServlet("/makeTransaction")
public class makeTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makeTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int price = Integer.parseInt(request.getParameter("price"));
		String s[]={"banana","apple","watermelon","orange","papaya","pineapple","mango","pomegranate","guava"};
		String f[] = new String[3];
		int q[] = new int[3];
		int arr[]=new int[9];
		int fcount=0;
		for(int i=0;i<9;i++){
			String name = "addedquantity" + Integer.toString(i+1);
			arr[i]= Integer.parseInt(request.getParameter(name));
			if(arr[i]!=0){
				f[fcount]=s[i];
				q[fcount]=arr[i];
				fcount++;
				if(fcount==3)
					break;
			}
		}
		request.getSession(false).setAttribute("f1", f[0]);
		request.getSession(false).setAttribute("f2", f[1]);
		request.getSession(false).setAttribute("f3", f[2]);
		request.getSession(false).setAttribute("q1", q[0]);
		request.getSession(false).setAttribute("q2", q[1]);
		request.getSession(false).setAttribute("q3", q[2]);
		request.getSession(false).setAttribute("finalprice", price);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/makeTransaction.jsp");
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
