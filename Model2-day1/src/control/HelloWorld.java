package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloWorld") //������̼� /HelloWorld��� �ּ� url�� ǥ�����־�� �� ���� Ŭ������ ����ȴ�
public class HelloWorld extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	//�ϰ� ó��, do get �̴� do post�� �Ʒ� reqPro �޼ҵ尡 ����ǰ� ����
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ȭ�鿡 HelloWolrd��� ����� �ϰ� �����ϱ� jsp������ �Ѱ��� �����͸� �����Ѵ�
		String msg = "Hello World~";
		Integer data = 12;
		
		//jsp������ �����͸� request�� �����Ͽ� �Ѱ���
		request.setAttribute("msg", msg);
		request.setAttribute("data", data);
		
		//servlet���� jsp�� ȣ���ϸ鼭 �����͸� ���� �Ѱ� �ִ� ��ü�� ����
		RequestDispatcher rd = request.getRequestDispatcher("HelloWorld.jsp");//jsp���ϸ� ���
		rd.forward(request, response);
	}
	
}
