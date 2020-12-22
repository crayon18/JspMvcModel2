<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h2>결과보기</h2>
	
	<%
		String exp2 = request.getParameter("exp2");
	
		if(exp2.equals("+")){
	%>
		결과는 ${param.exp1 + param.exp3 }
	<%
		}
		if(exp2.equals("-")){
	%>
		결과는 ${param.exp1 - param.exp3 }
	<%
		}
		if(exp2.equals("*")){
	%>
		결과는 ${param.exp1 * param.exp3 }
	<%
		}
		if(exp2.equals("/")){
	%>
		결과는 ${param.exp1 / param.exp3 }
	<%
		}
	%>
	
	</center>
</body>
</html>