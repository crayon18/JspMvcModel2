package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginProc.do")//어노테이션 기능
public class LopginProc extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		reqPro(request, response);
	}

	
	public void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식이든 post방식이든 reqPro가 받게끔 메소드 작성
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		request.setAttribute("id", id);//request객체에 데이터를 저장
		request.setAttribute("pass", pass);
		//
		RequestDispatcher dis = request.getRequestDispatcher("LoginProc.jsp");
		dis.forward(request, response);
	}
}


