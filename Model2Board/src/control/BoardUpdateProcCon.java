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
		
		//������ �Ѿ�� �����͸� �޾���
		int num = Integer.parseInt(request.getParameter("num"));
		String password = request.getParameter("password"); //����ڰ� �Է��� �н����� ����
		String pass = request.getParameter("pass");  //���� �����ͺ��̽��� ����Ǿ��ִ� �н����尪��
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//����ڰ� �Է��� password���� ���� �����ͺ��̽��� �ִ� pass ���� ���ؾ��Ѵ�
		if(password.equals(pass)) {//�н����尡 ���ٸ� �����͸� ����
			BoardDAO bdao = new BoardDAO();
			bdao.updateBoard(num,subject,content);
			//������ �Ϸ�Ǹ� ��ü �Խñ� ����� �̵���Ŵ
			request.setAttribute("msg", "2");
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
			dis.forward(request, response);
		}else {
			//��й�ȣ�� ��ġ���� �ʾҴٸ� ���� �������� �̵� ��Ŵ
			request.setAttribute("msg", "1");
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
			dis.forward(request, response);
		}
		
	}
}
