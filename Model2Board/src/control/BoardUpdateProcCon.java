package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

/**
 * Servlet implementation class BoardUpdateProcCon
 */
@WebServlet("/BoardUpdateProcCon.do")
public class BoardUpdateProcCon extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//폼에서 넘어온 데이터를 받아줌
		int num = Integer.parseInt(request.getParameter("num"));
		String password = request.getParameter("password"); //사용자가 입력한 패스워드 값임
		String pass = request.getParameter("pass");  //실제 데이터베이스에 저장되어있는 패스워드값임
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//사용자가 입련한 password값과 기존 데이터베이스에 있는 pass 값을 비교해야한다
		if(password.equals(pass)) {//패스워드가 같다면 데이터를 수정
			BoardDAO bdao = new BoardDAO();
			bdao.updateBoard(num,subject,content);
			//수정이 완료되면 전체 게시글 보기로 이동시킴
			request.setAttribute("msg", "2");
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
			dis.forward(request, response);
		}else {
			//비밀번호가 일치하지 않았다면 이전 페이지로 이동 시킴
			request.setAttribute("msg", "1");
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
			dis.forward(request, response);
		}
		
	}
}
