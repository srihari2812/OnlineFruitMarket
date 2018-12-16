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
 * Servlet implementation class updateWallets
 */
@WebServlet("/updateWallets")
public class updateWallets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateWallets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String fn[] = new String[3];
		int fq[] = new int[3];
		String remail,semail;
		remail=(String)request.getSession().getAttribute("remail");
		semail=(String)request.getSession().getAttribute("email");
		int price = (int)request.getSession().getAttribute("finalprice");
		for(int i=0;i<3;i++){
			String temp = "f" + Integer.toString(i+1);
			fn[i]=(String)request.getSession().getAttribute(temp);
			temp = "q" + Integer.toString(i+1);
			fq[i]=(int)request.getSession().getAttribute(temp);
		}
		Database db = new Database("myproject","root","icefire");
		String finalmsg="";
		String temp = db.getWallet(semail, "shoppers");
		if(Integer.parseInt(temp.substring(0,temp.length()-2))>=price){
			if(db.updatewallets(fn,fq,remail,semail,price))
				finalmsg="Purchase done successfully";
			else
				finalmsg="Purchase failed";
		}
		else{
			finalmsg="Insufficient balance";
		}
		request.setAttribute("finalmsg", finalmsg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/finalPage.jsp");
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
