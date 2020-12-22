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

	<c:set var="i" value="4"/> <!-- request.setAttribute("i" , 4) 와 같다 즉 변수 선언 -->
	
	<!-- if문 사용법 -->
	<c:if test="${ i > 3 }">
	안녕하세요
	</c:if>
	
	<!-- 반복문 for -->
	<c:forEach var="i" begin="1" end="10">
	<c:set var="sum" value="${sum=sum+i }"/>
	</c:forEach>
	${sum }
</body>
</html> 