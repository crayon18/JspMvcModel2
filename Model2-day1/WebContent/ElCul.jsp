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
		<h2>계산기</h2>
		<form action="ElCul.jsp" method="post">
		<table width="450" border="1">
			<tr height="40">
				<td align="center" width="100"><input type="text" name="exp1" value="${param.exp1 }"></td>
				<td align="center" width="50"><select name ="exp2" value="${param.exp2 }">
													<option value="+"> + </option>
													<option value="-"> - </option>
													<option value="*"> * </option>
													<option value="/"> / </option>
												</select></td>
				<td align="center" width="100"><input type="text" name="exp3" value="${param.exp3 }"></td>
				<td align="center" width="200">=</td>
				<td align="center" width="100">
	<%
		String exp2 = request.getParameter("exp2");
	
		//null point exption 나오면 null처리해줘야함
		if(exp2==null){
			exp2 = "+";
		}
		if(exp2.equals("+")){
	%>
		<input type="text" name="exp4" value="${param.exp1 + param.exp3 }">
	<%
		}
		if(exp2.equals("-")){
	%>
		<input type="text" name="exp4" value="${param.exp1 - param.exp3 }">
	<%
		}
		if(exp2.equals("*")){
	%>
		<input type="text" name="exp4" value="${param.exp1 * param.exp3 }">
	<%
		}
		if(exp2.equals("/")){
	%>
		<input type="text" name="exp4" value="${param.exp1 / param.exp3 }">
	<%
		}
	%>
				</td>
				<td align="center" width="100"><input type="submit" value="결과보기"></td>	
			</tr>
		</table>
		</form>
		
		
	</center>

</body>
</html>