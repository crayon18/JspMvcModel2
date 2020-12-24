package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.MemberDAO;

/**
 * Servlet implementation class MemberJoinProc
 */
@WebServlet("/proc.do")
public class MemberJoinProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		MemberBean bean = new MemberBean();
		bean.setId(request.getParameter("id"));
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");		
		bean.setPass1(pass1);
		bean.setPass2(pass2);
		bean.setEmail(request.getParameter("email"));
		bean.setTel(request.getParameter("tel"));
		String [] arr = request.getParameterValues("hobby");
		String data="";
		for (String string : arr) {
			data += string+" "; //�ϳ��� ��Ʈ������ ������ ����
		}
		
		bean.setHobby(data);
		bean.setJob(request.getParameter("job"));
		bean.setAge(request.getParameter("age"));
		bean.setInfo(request.getParameter("info"));
		
		//�н����尡 ���� ��쿡�� ������ ���̽��� ����
		if(pass1.equals(pass2)) {
			
			//�����ͺ��̽� ��ü ����
			MemberDAO mdao = new MemberDAO();
			mdao.insertMember(bean);
			
			//��Ʈ�ѷ����� �Ǵٸ� ��Ʈ�ѷ��� ȣ�����־�� �Ѵ�.(jsp������ ȭ�鸸 �ѷ���� �ϴϱ�)
			RequestDispatcher dis = request.getRequestDispatcher("MemberlistCon.do");
			dis.forward(request, response);
			
		}else {
			
			request.setAttribute("msg", "�н����尡 ��ġ���� �ʽ��ϴ�.");
			RequestDispatcher dis = request.getRequestDispatcher("LoginError.jsp");
			dis.forward(request, response);
		}
		
		
		//������ ���̽� ��ü �������� ����
		MemberDAO mdao = new MemberDAO();
	}
}
