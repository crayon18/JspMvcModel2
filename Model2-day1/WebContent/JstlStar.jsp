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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="6" color="yellow">��</font><br>
<!-- 5���� �ݺ����� ���� �ϴ� outer for�� -->
<c:forEach var="i" begin="0" end="4">

	<!-- ������ ����ϴ� �ݺ����� �ۼ� -->
	<c:forEach var="j" begin="${i+1}" end="5">
	&nbsp;
	</c:forEach>

	<!-- *�� ����ϴ� �ݺ����� �ۼ� -->
	<c:forEach var="j" begin="1" end="${1+(i*2)}">
	<font color="green">*</font>
	</c:forEach>

	<br>
</c:forEach>

</body>
</html>