<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h2>��ü�Խñ� ����</h2>
		<table width="700" border="1" bgcolor="skyblue">
		<tr height="40">
			<td align="right" colspan="5">
		<button onclick="location.href='BoardWriteForm.jsp'">�۾���</button>
			</td>
		</tr>
		<tr height="40">
			<td width="50" align="center">��ȣ</td>
			<td width="300" align="center">����</td>
			<td width="100" align="center">�ۼ���</td>
			<td width="150" align="center">�ۼ���</td>
			<td width="100" align="center">��ȸ��</td>
		</tr>
		<c:set var="number" value="${number }"/>
		<c:forEach var="bean" items="${v }">
		
		<tr height="40">
			<td width="50" align="center">${number}</td>
			<td width="300" align="left">
				<c:if test="${bean.re_stop > 1 }">
				<c:forEach var="j" begin="1" end="${(bean.re_stop-1)*5 }">
					&nbsp;
				</c:forEach>
				</c:if>
				<a href="BoardInfoControl.do?num=${bean.num }"> ${bean.subject } </a>
			</td>
			<td width="100" align="center">${bean.write }</td>
			<td width="150" align="center">${bean.reg_date }</td>
			<td width="100" align="center">${bean.readcount }</td>
		</tr>
		<c:set var="number" value="${number-1 }"/>
		</c:forEach>
	</table>
	<p>
	<!-- ������ ī���͸� �ҽ��� �ۼ� -->
		<c:if test="${count >0 }">
			<c:set var="pageCount" value="${count/pageSize + (count%pageSize == 0 ? 0 : 1) }"/>
			<c:set var="startPage" value="${1 }"/>
		<c:if test="${currentPage %10 != 0 }">
			<!-- ����� ���������� ���� �޾ƾ� �ϱ⿡ fmt�±׸� �������� -->
			<fmt:parseNumber var="result" value="${currentPage/10 }" integerOnly="true"/>
			<c:set var="startPage" value="${result*10+1 }"/>
		</c:if>
		<c:if test="${currentPage %10 == 0 }">
			<c:set var="startPage" value="${(result-1)*10+1 }"/>
		</c:if>
		
		<!-- ȭ�鿡 ������ ������ ó�� ���� ǥ�� -->
		<c:set var="pageBlock" value="${10 }"/>
		<c:set var="endPage" value="${startPage+pageBlock-1 }"/>
		
		<c:if test="${endPage > pageCount }">
			<c:set var="endPage" value="${pageCount }"/>
		</c:if>
		
		<!-- ���� ��ũ�� ���� �ľ� -->
		<c:if test="${startPage >10 }">
			<a href="BoardListCon.do?pageNum=${startPage-10}">����</a>
		</c:if>
		
		<!-- ����¡ó�� -->
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<a href="BoardListCon.do?pageNum=${i}">${i }</a>
		</c:forEach>
		
		<!-- ���� -->
		<c:if test="${endPage < pageCount }">
			<a href="BoardListCon.do?pageNum=${startPage+10}">����</a>
		</c:if>
		
		</c:if>
	</center>
</body>
</html>