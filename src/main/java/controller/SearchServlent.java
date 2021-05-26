package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ResultBean;
import database.SQL_connection;

/**
 * Servlet implementation class SearchServlent
 */
@WebServlet("/SearchServlent")
public class SearchServlent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String SearchString = request.getParameter("SearchString");
		ArrayList<ResultBean> SearchResult = new ArrayList<ResultBean>();

		if (SQL_connection.connectSQL()) {
			if (!SearchString.isEmpty()) {
				SearchResult = SQL_connection.stateSQL(SearchString);
			}
			request.setAttribute("SearchResult", SearchResult);
			RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
			rd.forward(request, response);

		} else {

			request.setAttribute("SearchResult", SearchResult);
			RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
			rd.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
