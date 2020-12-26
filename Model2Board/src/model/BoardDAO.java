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
	
	//데이터 베이스에 연결 메소드
	public void getCon() {
		try {
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			con = ds.getConnection(); //커넥션연결 해주는 메소드
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//전체 게시글의 갯수를 리턴하는 메소드
	public int getAllCount() {
		getCon();
		
		int count=0;
		
		try {
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			//쿼리 실행후 결과를 리턴
			rs = pstmt.executeQuery();
			//단일행 함수이기 때문에 while 돌릴필요없다
			if(rs.next()) {
				count = rs.getInt(1);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//화면에 보여질 데이터를 10개씩 추출해서 리턴하는 메소드
	public Vector<BoardBean> getAllBoard(int startRow, int endRow){
		
		Vector<BoardBean> v = new Vector<>();
		getCon();
		
		try {
			String sql = "select * from (select A.* ,Rownum Rnum from (select * from board order by ref desc , re_stop asc)A)"
					+ "where Rnum >= ? and Rnum <=?";
			//쿼리 실행할 객체 선언
			pstmt = con.prepareStatement(sql);
			//?값 대입
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
				//패키징할 데이터를 백터에 저장
				v.add(bean);
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	//하나의 게시글을 저장하는 메소드
	public void insertBoard(BoardBean bean) {
		getCon();
		int ref = 0;
		int re_stop=1; //새글이기에 1로 초기화
		int re_level=1; //새글
		
		try {
			String refsql = "select max(ref) from board";
			pstmt = con.prepareStatement(refsql);
			//쿼리 실행후 결과 리턴
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ref = rs.getInt(1)+1;
			}
			//데이터를 삽입하는 쿼리
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
