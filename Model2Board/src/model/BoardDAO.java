package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.BoardBean;

public class BoardDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//������ ���̽��� ���� �޼ҵ�
	public void getCon() {
		try {
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			con = ds.getConnection(); //Ŀ�ؼǿ��� ���ִ� �޼ҵ�
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��ü �Խñ��� ������ �����ϴ� �޼ҵ�
	public int getAllCount() {
		getCon();
		
		int count=0;
		
		try {
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			//���� ������ ����� ����
			rs = pstmt.executeQuery();
			//������ �Լ��̱� ������ while �����ʿ����
			if(rs.next()) {
				count = rs.getInt(1);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//ȭ�鿡 ������ �����͸� 10���� �����ؼ� �����ϴ� �޼ҵ�
	public Vector<BoardBean> getAllBoard(int startRow, int endRow){
		
		Vector<BoardBean> v = new Vector<>();
		getCon();
		
		try {
			String sql = "select * from (select A.* ,Rownum Rnum from (select * from board order by ref desc , re_stop asc)A)"
					+ "where Rnum >= ? and Rnum <=?";
			//���� ������ ��ü ����
			pstmt = con.prepareStatement(sql);
			//?�� ����
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				BoardBean bean = new BoardBean();
				bean.setNum(rs.getInt(1));
				bean.setWrite(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_stop(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				//��Ű¡�� �����͸� ���Ϳ� ����
				v.add(bean);
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	//�ϳ��� �Խñ��� �����ϴ� �޼ҵ�
	public void insertBoard(BoardBean bean) {
		getCon();
		int ref = 0;
		int re_stop=1; //�����̱⿡ 1�� �ʱ�ȭ
		int re_level=1; //����
		
		try {
			String refsql = "select max(ref) from board";
			pstmt = con.prepareStatement(refsql);
			//���� ������ ��� ����
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ref = rs.getInt(1)+1;
			}
			//�����͸� �����ϴ� ����
			String sql = "insert into board values (board_seq.NEXTVAL,?,?,?,?,sysdate,?,?,?,0,?)";
			pstmt = con.prepareStatement(sql);
			//?
			pstmt.setString(1, bean.getWrite());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getSubject());
			pstmt.setString(4, bean.getPassword());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_stop);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, bean.getContent());
			
			pstmt.executeUpdate();
			
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}