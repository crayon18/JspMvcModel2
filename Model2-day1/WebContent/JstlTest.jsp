<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<c:set var="i" value="4"/> <!-- request.setAttribute("i" , 4) �� ���� �� ���� ���� -->
	
	<!-- if�� ���� -->
	<c:if test="${ i > 3 }">
	�ȳ��ϼ���
	</c:if>
	
	<!-- �ݺ��� for -->
	<c:forEach var="i" begin="1" end="10">
	<c:set var="sum" value="${sum=sum+i }"/>
	</c:forEach>
	${sum }
</body>
</html> 